"""Action Gateway tools (DO-maintained web_search / web_fetch — not Exa).

When agents.yaml attaches `- do.actions` with those tools, Managed Agents puts
the session-pinned MCP URL in HARNESS_MCP_URL_DO_ACTIONS. No credential is in
the URL. Locally the variable is unset and the Crew runs without tools.
"""

from __future__ import annotations

import os
from typing import Any

# Provider-qualified slugs. Must match tools + preload_tools + allow rules
# in agents.yaml. Prefer DO-maintained web_* over prepaid exa_*.
ACTION_GATEWAY_TOOLS = ["web_search", "web_fetch"]

_adapter: Any = None


def action_gateway_tools() -> list[Any]:
    global _adapter

    url = os.environ.get("HARNESS_MCP_URL_DO_ACTIONS")
    if not url:
        return []

    try:
        from crewai_tools import MCPServerAdapter
    except ImportError as e:
        raise RuntimeError(
            "HARNESS_MCP_URL_DO_ACTIONS is set but crewai-tools[mcp] is not "
            "installed. Uncomment / install it from requirements.txt."
        ) from e

    # MCPServerAdapter (not Agent(mcps=[MCPServerHTTP(...)])): the latter
    # prefixes tool names with the endpoint URL and truncates them.
    _adapter = MCPServerAdapter(
        {"url": url, "transport": "streamable-http"},
        *ACTION_GATEWAY_TOOLS,
    )
    return list(_adapter.tools)
