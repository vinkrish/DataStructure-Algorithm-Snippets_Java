CGLIB is a byte instrumentation library used in many Java frameworks such as Hibernate or Spring. The bytecode instrumentation allows manipulating or creating classes after the compilation phase of a program.

Classes in Java are loaded dynamically at runtime. cglib is using this feature of Java language to make it possible to add new classes to an already running Java program.

Hibernate uses cglib for generation of dynamic proxies. For example, it will not return full object stored in a database but it will return an instrumented version of stored class that lazily loads values from the database on demand.

Popular mocking frameworks, like Mockito, use cglib for mocking methods. The mock is an instrumented class where methods are replaced by empty implementations.