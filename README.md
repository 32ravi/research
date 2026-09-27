# research

A collection of standalone Java examples for exploring core language and JDK features.
Each class is self-contained and most have their own `main` method.

## Layout

All sources live under `src/main/java`:

| Package | Topic |
| --- | --- |
| `Algorithms` | Algorithm exercises |
| `ds` | Data structures |
| `concurrency` | Threads, locks, thread pools, `ThreadLocal`, atomics |
| `IO` | Streams, readers/writers, memory-mapped files, serialization |
| `networking` | Sockets and networking examples |
| `rmi` | Java RMI client/server example |
| `rStrings` | String handling and regex |
| `reflection` | Reflection API |
| `InnerClasses` | Inner, nested, and anonymous classes |
| `miscLang` | Miscellaneous language features |
| `performance` | Performance experiments |
| `disruptor` | LMAX Disruptor example |
| `nativeCode`, `HelloJNI.java` | JNI examples |
| `rjunitPowerMock` | JUnit / PowerMock examples |

## Building

```sh
mvn compile
```

Run an individual example from your IDE, or with `java -cp target/classes <package>.<ClassName>`.
