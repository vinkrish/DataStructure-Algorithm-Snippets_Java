## Pattern Groups

- Creational
- Structural
- Behavioral

<li></li>

### Creational Pattern

|   | Concepts | Design | Example |
| - | -------- | ------ | ------- |
| Singleton | <ul><li>Only one instance created</li><li>Guarantees control of a resource</li><li>Lazily loaded</li></ul> | <ul><li>Class is responsible for lifecycle</li><li>Static in nature</li><li>Needs to be thread safe</li><li>Private instance</li><li>Private constructor</li><li>No parameters required for construction</li></ul> | <ul><li>Runtime</li><li>Logger</li><li>Spring Beans</li><li>Graphic Managers</li></ul> |
| Builder | <ul><li>Handles complex constructors</li><li>Large number of parameters</li><li>Immutability</li></ul> | <ul><li>Flexibility over telescoping constructors</li><li>Static inner class</li><li>Calls appropriate constructor</li><li>Negates the need for exposed setters</li></ul> | <ul><li>StringBuilder</li><li>DocumentBuilder</li><li>Locale.Builder</li></ul> |
| Factory | <ul><li>Doesn’t expose instantiation logic</li><li>Defer to subclasses</li><li>Common interface</li><li>Specified by architecture, implemented by user</li></ul> | <ul><li>Factory is responsible for lifecycle</li><li>Common Interface</li><li>Concrete Classes</li><li>Parameterized create method</li></ul> | <ul><li>Calendar</li><li>ResourceBundle</li><li>NumberFormat</li></ul> |
| Prototype | <ul><li>Avoids costly creation</li><li>Avoids subclassing</li><li>Typically doesn’t use “new”</li><li>Often utilizes an Interface</li><li>Usually implemented with a Registry</li></ul> | <ul><li>Clone / Cloneable</li><li>Although a copy, each instance unique</li><li>Costly construction not handled by client</li><li>Can still utilize parameters for construction</li><li>Shallow VS Deep Copy</li></ul> | <ul><li>Inspiration: Object clone method</li></ul> |
| AbstractFactory | <ul><li>Factory of Factories</li><li>Factory of related objects</li><li>Common Interface</li><li>Defer to Subclasses</li></ul> | <ul><li>Factory is responsible for lifecycle</li><li>Concrete Classes</li><li>Parameterized create method</li><li>Composition</li></ul> | <ul><li>DocumentBuilder</li><li>Frameworks</li></ul> |

### Structural Pattern

|   | Concepts | Design | Example |
| - | -------- | ------ | ------- |
| Adapter | <ul><li>Plug adaptor</li><li>Convert interface into another interface</li><li>Legacy</li><li>Translates requests</li><li>Client, Adapter, Adaptee</li></ul> | <ul><li>Client centric</li><li>Integrate new with old</li><li>Interface, but not required</li><li>Adaptee can be the implementation</li></ul> | <ul><li>Arrays -> Lists</li><li>Streams</li></ul> |
| Decorator | <ul><li>Also called a wrapper</li><li>Add behavior without affecting others</li><li>More than just inheritance</li><li>Single Responsibility Principle</li><li>Compose behavior dynamically</li></ul> | <ul><li>Inheritance based</li><li>Utilizes composition and inheritance (is-a, has-a)</li><li>Alternative to subclassing</li><li>Constructor requires instance from hierarchy</li></ul> | <ul><li>InputStream</li><li>Collections#CheckedList</li><li>UI Component</li></ul> |
| Facade | <ul><li>Make an API easier to use</li><li>Reduce dependencies on outside code</li><li>Simplify the interface or client usage</li><li>Usually a refactoring pattern</li></ul> | <ul><li>Class that utilizes composition</li><li>Shouldn’t have a need for inheritance</li><li>Typically encompasses full lifecycle</li></ul> | <ul><li>java.net.URL</li><li>javax.faces.context.FacesContext</li></ul> |
| Bridge | <ul><li>Decouple Abstraction and implementation</li><li>Encapsulation, Composition, Inheritance</li><li>Changes in Abstraction won’t affect client</li><li>Details won’t be right</li></ul> | <ul><li>Interfaces and Abstract classes</li><li>Composition over Inheritance</li><li>Expect change from both sides</li><li>More than Composition</li><li>Abstraction, Implementor, Refined
Abstraction, Concrete Implementor</li></ul> | <ul><li>Driver</li><li>JDBC</li></ul> |
| Composite | <ul><li>Components represent part or whole structure</li><li>Compose objects into tree structures</li><li>Individual object treated as a Composite</li><li>Same operations applied on individual and composites</li></ul> | <ul><li>Tree structured</li><li>Component</li><li>Leaf or Composite, same operations</li><li>Composite knows about child objects</li><li>Component, Leaf, Composite</li></ul> | <ul><li>RESTful service GETs</li><li>JSF widgets</li><li>java.AWT.Component</li></ul> |
| Flyweight | <ul><li>More efficient use of memory</li><li>Large number of similar objects</li><li>Immutable</li><li>Most of the object states can be extrinsic</li></ul> | <ul><li>Pattern of patterns</li><li>Utilizes a Factory</li><li>Encompasses Creation and Structure</li><li>Client, Factory, Flyweight, ConcreteFlyweight</li></ul> | <ul><li>String</li><li>Integer#valueOf(int)</li><li>Boolean, Byte, Character, Short, Long</li></ul> |
| Proxy | <ul><li>Interface by wrapping</li><li>Can add functionality</li><li>Security, Simplicity, Remote, Cost</li><li>Proxy called to access real object</li></ul> |  | <ul><li>java.lang.reflect.Proxy</li><li>java.rmi.*</li></ul> |

### Behavioral Pattern

|   | Concepts | Design | Example |
| - | -------- | ------ | ------- |
| Observer | <ul><li>One to Many</li><li>Decoupled</li><li>Event Handling</li><li>Pub/Sub</li><li>M-V-C</li></ul> | <ul><li>Subject</li><li>Observer</li><li>Observable</li><li>Views are Observers</li><li>Subject, Concrete Subject, Observer, Concrete Observer</li></ul> | <ul><li>java.util.Observer</li><li>java.util.EventListener</li><li>javax.jms.Topic</li></ul> |
| Strategy | <ul><li>Eliminate conditional statements</li><li>Behavior encapsulated in classes</li><li>Difficult to add new strategies</li><li>Client aware of strategies</li><li>Client chooses strategy</li></ul> | <ul><li>Abstract base class</li><li>Concrete class per strategy</li><li>Removes if/else conditionals</li><li>Strategies are independent</li><li>Context, Strategy, ConcreteStrategy</li></ul> | <ul><li>Comparator</li></ul> |
| Mediator | <ul><li>Loose coupling</li><li>Well-defined, but complex</li><li>Reusable components</li><li>Hub / Router</li></ul> | <ul><li>Interface based</li><li>Concrete class</li><li>Minimizes inheritance</li><li>Mediator knows about colleagues</li><li>Mediator, ConcreteMediator</li></ul> | <ul><li>java.util.Timer</li><li>reflect.Method#invoke()</li></ul> |
| Command | <ul><li>Encapsulate request as an Object</li><li>Object-oriented callback</li><li>Decouple sender from processor</li><li>Often used for “undo” functionality</li></ul> | <ul><li>Object per command</li><li>Command Interface</li><li>Execute / Unexecute Method</li><li>Reflection</li><li>Command, Invoker, ConcreteCommand</li></ul> | <ul><li>Runnable</li><li>javax.swing.Action</li></ul> |
| Chain of Responsibility | <ul><li>Decoupling of sender and receiver</li><li>Receiver contains reference to next receiver</li><li>Promotes loose coupling</li><li>No Handler - OK</li></ul> | <ul><li>Chain of receiver objects</li><li>Handler is Interface based</li><li>ConcreteHandler for each implementation</li><li>Each Handler has a reference to the next</li><li>Handler, ConcreteHandler</li></ul> | <ul><li>Logger#Log()</li><li>javax.servlet.Filter#doFilter()</li><li>Spring Security Filter Chain</li></ul> |
| Memento | <ul><li>Restore Object to previous state</li><li>Externalize internal state</li><li>Undo/Rollback</li><li>Shields complex internals</li></ul> | <ul><li>Class based</li><li>Originator</li><li>Caretaker</li><li>Memento</li><li>Magic Cookie</li></ul> | <ul><li>java.util.Date</li><li>Serializable</li></ul> |
| Interpreter | <ul><li>Represent grammar</li><li>Interpret a sentence</li><li>Map a domain</li><li>AST</li></ul> | <ul><li>AbstractExpression</li><li>Interpret</li><li>TerminalExpression</li><li>NonterminalExpression</li></ul> | <ul><li>java.util.Pattern</li><li>java.text.Format</li></ul> |
| Visitor |  |  | <ul><li>java.lang.model.elemment.Element</li><li>java.lang.model.elemment.ElementVisitor</li></ul> |
| Template Method | <ul><li>Code reuse</li><li>Common in libraries/frameworks</li><li>IoC</li><li>Algorithm emphasis</li></ul> | <ul><li>Abstract Base class</li><li>Base calls Child</li><li>Hooks</li><li>Operations</li><li>AbstractBase, ConcreteClass</li></ul> | <ul><li>Collections#sort()</li><li>AbstractList#indexOf()</li></ul> |