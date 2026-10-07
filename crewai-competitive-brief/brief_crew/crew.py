"""Three-agent competitive brief Crew for DigitalOcean Managed Agents.

Standard CrewAI — no platform-specific imports. The platform clones the
github.com mirror of this package, installs requirements.txt, and imports
`crew` (named in crewai.json). Each turn is one `crew.kickoff(inputs=...)`.

Kickoff inputs (declared in agents.yaml under crewai.inputs):

  company     string   filled from the turn's prompt text (prompt_key)
  competitor  string   who to compare against
  audience    string   who the brief is for
  max_sources integer  how many sources the scout should cite
  focus       string   pricing | features | gtm | overall
"""

from __future__ import annotations

import os

from crewai import LLM, Agent, Crew, Process, Task

from brief_crew.tools import action_gateway_tools


def _require(name: str) -> str:
    value = os.environ.get(name, "").strip()
    if not value:
        raise RuntimeError(
            f"{name} is not set. On Managed Agents, declare it in agents.yaml "
            "(env or secrets); locally, copy .env.example to .env and fill it in."
        )
    return value


def _build_llm() -> LLM:
    """Prefer OPENAI_* (BYOK). Managed Agents rewrites HARNESS_INFERENCE_BASE_URL
    to the VPC trusted endpoint, which rejects OpenAI sk-proj keys — so BYOK
    must dial api.openai.com via OPENAI_BASE_URL, not HARNESS_INFERENCE_*.
    """
    openai_key = os.environ.get("OPENAI_API_KEY", "").strip()
    if openai_key:
        model = (
            os.environ.get("OPENAI_MODEL", "").strip()
            or os.environ.get("HARNESS_INFERENCE_MODEL", "").strip()
            or "gpt-4o-mini"
        )
        base_url = (
            os.environ.get("OPENAI_BASE_URL", "").strip()
            or "https://api.openai.com/v1"
        )
        return LLM(
            model=model,
            base_url=base_url,
            api_key=openai_key,
            provider="openai",
            temperature=0.2,
        )
    return LLM(
        model=_require("HARNESS_INFERENCE_MODEL"),
        base_url=_require("HARNESS_INFERENCE_BASE_URL"),
        api_key=_require("HARNESS_INFERENCE_API_KEY"),
        provider="openai",
        temperature=0.2,
    )


llm = _build_llm()

tools = action_gateway_tools()

scout = Agent(
    role="Scout",
    goal=(
        "Gather current, verifiable public facts about {company} versus "
        "{competitor}, focusing on {focus}"
    ),
    backstory=(
        "You are a competitive-intelligence scout. You prefer short, sourced "
        "facts over speculation. You use web search and fetch when available, "
        "and you say so when a claim is unconfirmed."
    ),
    llm=llm,
    tools=tools,
    allow_delegation=False,
)

analyst = Agent(
    role="Analyst",
    goal=(
        "Turn scout notes on {company} vs {competitor} into a clear comparison "
        "for {audience}, focused on {focus}"
    ),
    backstory=(
        "You structure competitive research into strengths, gaps, and open "
        "questions. You do not invent numbers."
    ),
    llm=llm,
    allow_delegation=False,
)

strategist = Agent(
    role="Strategist",
    goal=(
        "Write a one-page competitive brief on {company} vs {competitor} for "
        "{audience}"
    ),
    backstory=(
        "You write crisp product briefs: situation, comparison, and a short "
        "recommendation. No fluff."
    ),
    llm=llm,
    allow_delegation=False,
)

scout_task = Task(
    description=(
        "Research {company} versus {competitor} with focus={focus}. Collect up "
        "to {max_sources} solid public sources. Prefer primary pages (pricing, "
        "docs, blogs, filings) over aggregator noise. List facts with URLs when "
        "you have them."
    ),
    expected_output=(
        "A numbered list of at most {max_sources} short facts, each with a "
        "source URL when available."
    ),
    agent=scout,
)

analyze_task = Task(
    description=(
        "Using the scout's notes, compare {company} and {competitor} for "
        "{audience}. Focus on {focus}. Call out strengths, gaps, and unknowns. "
        "Do not add unsourced claims."
    ),
    expected_output=(
        "Three short sections: Strengths, Gaps, Unknowns — each as bullets."
    ),
    agent=analyst,
    context=[scout_task],
)

brief_task = Task(
    description=(
        "Write a one-page competitive brief for {audience} on {company} vs "
        "{competitor} (focus={focus}). Structure: (1) Situation in 2-3 "
        "sentences, (2) Comparison bullets, (3) Recommendation with next "
        "steps. Keep it under ~400 words."
    ),
    expected_output="A short brief with Situation, Comparison, and Recommendation.",
    agent=strategist,
    context=[analyze_task],
)

# crewai.json points here: "crew": "brief_crew.crew:crew"
# Must be a constructed Crew, not a factory. Never set human_input=True.
crew = Crew(
    agents=[scout, analyst, strategist],
    tasks=[scout_task, analyze_task, brief_task],
    process=Process.sequential,
)
