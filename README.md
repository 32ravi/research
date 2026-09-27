# research

A collection of standalone Java examples for exploring core language and JDK features.
Each class is self-contained and most have their own `main` method.

## Layout

Example sources live under `src/main/java`:

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
| `disruptor` | Placeholder (empty `Test` class) |
| `nativeCode`, `HelloJNI.java` | JNI examples |
| `rjunitPowerMock` | JUnit / PowerMock examples |

JUnit, Mockito, and PowerMock tests live under `src/test/java` (`rjunit`, `rjunitPowerMock`).

## Running

The project was built in Eclipse (`.project`, `.classpath`), and `pom.xml` doesn't declare any
dependencies or a Java version yet. Because of that, `mvn compile` won't work as-is: some classes
need JUnit, Mockito, or PowerMock on the classpath. Import the project into an IDE, add those
libraries, and run individual classes through their `main` methods.
