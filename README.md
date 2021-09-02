# Data Structure, Algorithm and code snippets in java

## Contents
 * [Abstraction](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/abstraction)
 * [Algorithms](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/algorithms)
 * [Annotations](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/annotations)
 * [Challenge](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/challange)
 * [Classes](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/classes)
 * [CompletableFuture](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/completablfutures)
 * [Constructor](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/constructor)
 * [Data Structure](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/datastructure)
 * [Data Time](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/datetime)
 * [Deep Copy](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/deepcopy)
 * [Design Pattern](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/designpattern)
 * [Dynamic Programming](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/dynamicprog)
 * [Exception](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/exception)
 * [Graph](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/graph)
 * [Inheritance](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/inheritance)
 * [Java 8](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/java8)
 * [List](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/list)
 * [Lombok](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/lombokk)
 * [Map](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/map)
 * [Miscellaneous](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/misc)
 * [Operators](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/operators)
 * [Polymorphism](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/polymorphism)
 * [Queue](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/queue)
 * [Recursion](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/recursion)
 * [Reflection](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/reflection)
 * [Regex - Email](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/regex/email)
 * [Reification](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/reification)
 * [Searching](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/searching)
 * [Set](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/set)
 * [Shallow Copy](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/shallowcopy)
 * [Sorting](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/sorting)
 * [Synchronization](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/synchronization)
 * [Threading](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/master/src/main/java/threading)
 * [Java 9 Module Reference](https://github.com/vinkrish/DataStructure-Algorithm-Snippets_Java/tree/java9_module)
 
# Java

Java is a general-purpose programming language that is class-based, object-oriented, and designed to have as few implementation dependencies as possible.
 
**Class** : A template that describes the kinds of state and behavior that objects of its type support.

**Object** : An instance of class, which will have its own state and access to all of the behaviors defined by its class.

**State** : (Instance variable).

**Behavior** : (methods) where class' logic is stored or data gets manipulated.

...

**Inheritance** : allows code defined in one class to be reused in other classes.

**Interfaces** : 100 % abstract superclass that defines the methods a subclass must support but not how they must be supported.

## Java identifiers

1. Legal Identifiers - rules the compiler uses to determine whether a name is legal.
2. Sun's Java Code Conventions - for naming classes, vaiables and methods.
3. JavaBeans Naming Standards

### Legal Identifiers

- Identifiers can't start with a number.
- Java keywords can't be a identifier.
- Identifiers are case-sensitive.

### Sun's Java Code Conventions

- Classes and interfaces - camelCase, for interfaces names should typically be adjectives eg:(Runnable, Serializable).
- Methods - lower_camelcase, names should be verb-noun pairs.
- Variables - lower_camelcase.
- Constants - are created by marking variables static and final, names should be uppercase letters with underscore characters as seperators.

### JavaBeans Naming Standards

JavaBeans are Java classes that have properties:

- if property is not a boolean, the getter method's prefix must be get.
- if property is boolean, the getter method's prefix is either get or is.
- the setter method's prefix must be set.
- To complete the name of a getter or setter method, change the first letter of the property name to uppercase and then append.
- setter method signature must be marked public, with a void return type and argument that represents the property type.
- getter method signature must be marked public, take no arguments, and have a return type that matches the argument type of the setter method for that property.

JavaBean spec supports events, (eg: mouse click is multicast to many objects). The objects that receive the information that an event occurred are called  listeners.

JavaBean Listener Naming Rules:

- Listener method names must end with the words "Listener".
- The type of listener to be added or removed must be passed as the argument to the method.
- Listener method names used to register/remove a listner with an event source must use the perfix add/remove, followed by the listener type.

## Class Declarations and Modifiers:

| Modifier | Class | Package | Subclass(same pkg) | Subclass(diff pkg) | World |
| -------- | ------| ------- | ------------------ | ------------------ | ----- |
| public | + | + | + | + | + |
| protected | + | + | + | + | |
| no modifier | + | + | + | | |
| private | + | | | | |

Modifiers:
 
- Access modifiers(public, protected, private) 
- Non-access modifiers(strictfp, final, abstract)

four access controls but three access modifiers, the fourth access control level (called default or package access) is what you get when you don't use any of the three access modifiers.

### Class Access(access a class)
 
Access means visibility. class can be declared with default or public access.

- Default Access : class with default access can be seen only by classes within the same package.
- Public Access : gives all classes from all packages access to public class.

Non-access class modifiers - used in addition to access control. (below are valid combination)

- public_final, default_final
- public_abstract, default_final
- strictfp_final, public_strictfp, default_strictfp

Final Classes - class can't be subclassed.  
Abstract Classes - can never be instantiated.

Static members are shared across all instantiations of a class, static members are independent of any type parameters.

### Interface

It is a contract for what a class can do, without saying anything about how the class will do it.
Interface variables must be public, static and final = constants.

Interface methods:

- must not be static.
- can extend only Interface(many).
- cannot implement another interface or class.

### Modifiers On Member

Access Modifiers:

- Public Members - all other classes can access the member.
- Private Members - can be accessed by code in which they are declared.
- Protected and Default Members - default member may be accessed only if the class accessing the member belongs to the same package, whereas a protected member can be accessed by a subclass.
- Default Members - package level.

Nonaccess Member Modifiers:

- Final Methods - final keyword prevents the method from being overridden.
- Abstract Methods - declared but not implemented.
- Synchronized Methods - method can be accessed by only one thread at a time (applied only to methods).
- Native Methods - implemented in platform dependent code(like in C).

## Variable Declarations:

1. Primitives - char, boolean, byte, short, int, long, double, float.
2. Reference variables - used to refer (or access) an object. they can be static, instance variables, method parameters or local variables.

**Instance Variables** : are defined inside class but outside any method, and are only initialized when class is instantiated. they are the fields that belong to each unique object.

**Array** : objects that store multiple variables of the same type or variables that are all subclasses of the same type. can hold both primitives and object references.

**Final Variable** : cannot be reinitialized (primitives) or reference variable cannot be changed but data within the object can be modified.(no final object only final references).

**Static variables and Methods** : will exist independently of any instances created for the class (exist before we make instance of a class). one copy of static member exist regardless of number of instances of that class. static blocks are called before constructor.

**Enums** : (java 5)> restrict a variable to have pre-defined value from an enumerated list. (items in the list are called enums). Enums can be declared as seperate class or class member but never within a method.

...

Benefit of encapsulation - The ability to make changes in your implementation code without breaking the code of others who use your code.

access methods - getters and setters(accessors and mutators).

Hide implementation details behind a public programming interface, interface in the sense set of accessible methods your code makes available for other code to call - your code's API.

## Inheritance, Is-A, Has-A

instanceof operator: returns true if the reference variable being tested is of the type being compared to.
every class is subclass of class Object.

inheritance relationships can be created by extending a class. 
Reasons to use inheritance: To promote code reuse, To use polymorphism.

code reuse - generic functionality (like method) don't have to be reimplemented, all subclasses are guaranteed to have capabilities of the superclass.

**polymorphism** - treats any subclass of classA as classA, which allows you to write methods that don't need to change if new subclasses are created.
Runtime polymorphism doesn't happen when static

**IS-A** : based on class inheritance and interface implementation, "this thing is a type of that thing".

**HAS-A** : based on usage, class A HAS-A B if code in class A has a reference to an	instance of class B.
Polymorphic method invocations apply only to instance methods, at runtime the only things that are dynamically selected based on the actual object are instance methods. Only overriden instance methods are dynamically invoked based on the real object's type.

Overridden Methods - based on object type.
Polymorphism lets you use a abstract supertype reference to refer to one of its subtypes.

Overloading Methods - based on reference type.

...

**Coupling and Cohesion** : good OO design calls for loose coupling and high cohesion.

...

A primitive literal is merely a source code representation of primitive data types(eg:integer, floating-point number, boolean or character).

## Assignment

- Variables are bit Holders, with a designed type.
- A variable referring to an object is just that - a reference variable.
- A reference variable bit holder contains bits representing a way to get to the object.

## Reification

In computing, reification has come to mean an explicit representation of a type — that is, run-time type information.  
In Java, arrays reify information about their component types, while generic types do not reify information about their type parameters (while the type of a
parameterized type is reified without its type parameters).

In Java, we say that a type is reifiable if the type is completely represented at run time — that is, if erasure does not remove any useful information. 

To be precise, a type is reifiable if it is one of the following:

- A primitive type (such as int)
- A nonparameterized class or interface type (such as Number, String, or Runnable)
- A parameterized type in which all type arguments are unbounded wildcards (such as `List<?>, ArrayList<?>, or Map<?, ?>`)
-  A raw type (such as List, ArrayList, or Map)
-  An array whose component type is reifiable (such as `int[], Number[], List<?>[], List[], or int[][]`)

A type is not reifiable if it is one of the following:

- A type variable (such as T)
- A parameterized type with actual parameters (such as `List<Number>`, `ArrayList<String>`, or `Map<String, Integer>`)
- A parameterized type with a bound (such as `List<? extends Number>` or `Comparable<? super String>`)

So the type `List<? extends Object>` is not reifiable, even though it is equivalent to `List<?>`. Defining reifiable types in this way makes them easy to identify syntactically.

**Principle of Indecent Exposure:** This principle guarantees that the component type at compile time will be a reifiable type.

**Principle of Truth in Advertising:** This principle guarantees that the reified component type returned at run time must be a subtype of the reifiable component type declared at compile time. 

Converse to cast-iron guarantee, above principle illustrates if there are unchecked warnings, then casts inserted by erasure may fail.

## Generics

In Java 5, the class Class has been made generic, and now has the form `Class<T>`. 

What does the T stand for?  
An instance of type `Class<T>` represents the type T. For example, `String.class` has type `Class<String>`.

**cast-iron guarantee:** No cast inserted by erasure will fail, so long as there are no unchecked warnings.

**The Get and Put Principle:**  
- use an extends wildcard when you only get values out of a structure
- use a super wildcard when you only put values into a structure
- don’t use a wildcard when you both get and put.

## Reflection

Every type in Java, including primitive types and array types, has a class literal and a corresponding class token.

generics for reflection: some of the types used for reflection are now generic types.  
reflection for generics: reflection now returns information about generic types.

Class represents information about the type of an object at run time. The method getClass() is defined on every object and returns a class token that represents the reified type information carried by that object at run-time.

class always represents a reifiable type, there is no point in parameterizing the class Class with a type that is not reifiable. Hence, the two main methods for producing a class with a type parameter, namely the getClass method and class literals, are both designed to yield a reifiable type for the type parameter in all cases.

## Data Strucures

Collections come in four basic flavors:

- **Lists** : Lists of things (classes that implement List)
- **Sets** : Unique things (classes that implement Set)
- **Maps** : Things with a unique ID (classes that implement Map)
- **Queues** : Things arranged by the order in which they are to be processed

The core interfaces:

![Interfaces](https://vinkrish-notes.s3-us-west-2.amazonaws.com/collection_interface.png)

The core concrete implementation classes:

![Classes](https://vinkrish-notes.s3-us-west-2.amazonaws.com/collection_class.png)

The interface and class hierarchy for collections:

![Collection](https://vinkrish-notes.s3-us-west-2.amazonaws.com/collection.png)

Arrays
- Arrays are objects in Java that store multiple variables of same type.
- Arrays can store either primitives or object references.
- Array subtyping is covariant, meaning that type S[] is considered to be a subtype of T[] whenever S is a subtype of T.
- Arrays do not support contravariant subtyping.

List
- The subtyping relation for generics is invariant, meaning that type `List<S>` is not considered to be a subtype of `List<T>`.
- Wildcards reintroduce covariant subtyping for generics, in that type `List<S>` is considered to be a subtype of `List<? extends T>` when S is a subtype of T.
- Wildcards also introduce contravariant subtyping for generics, in that type `List<S>` is considered to be a subtype of `List<? super T>` when S is a supertype of T (as opposed to a subtype).
- methods related to the index.
- eg:get(int index), indexof(Object o), add(int index, Object obj)

ArrayList
- ordered collection
- implements RandomAccess, marker Interface
- supports fast random access

Vector
- synchronized for thread safety
- implement RandomAccess

LinkedList
- ordered by index position and also elements are doubly linked to one another
- choose this for implementing a stack or queue

Set
- doesn't allow duplicates [using equals() method to determine identical objects]

HashSet
- unsorted, unordered Set
- uses hashcode of the object being inserted

LindkedHashset
- ordered and unsorted Set
- maintains doubly linked List across all elements
- iterates through the order in which they were inserted

TreeSet
- Sorted Set
- elements will be in ascending order, according to natural order

Map
- maps a unique key(ID) to a specific value
- can search for a valued based on the key
- uses equals() method to determine whether two keys are the same or different

HashMap
- unsorted and unordered Map
- allows one null key and multiple null values in a collection

LinkedHashMap
- maintains insertion order (optionally access order)
- faster iteration

Hashtable
- doesn't allow any null
- can't synchronize class: only key methods of the class are synchronized

TreeMap
- Sorted Map
- can define custom sort order(via a Comparable or Comparator)

Queue
- holds things to be processed in some way

Priority Queue
- to create "priority-in, priority-out" queue as opposed to FIFO
- ordered either by natural ordering or according to a Comparator

## Comparable Interface:

- A comparable object is capable of comparing itself with another object.
- Comparable provides compareTo() method to sort elements.
- Comparable affects the original class, i.e., the actual class is modified.
- Used by Collections.sort() and java.util.Arrays.sort() method.

## Comparator Interface

- A comparator object is capable of comparing two different objects. It is not comparing its instances, but some other class's instances. 
- Comparator provides compare() method to sort elements.
- Comparator doesn't affect the original class, i.e., the actual class is not modified.

## Developlment

```
javac [options] [source files]
java p[options] class [args]
```

## AOP

- Join Point represents the effective execution of a method where the aspect will be applied.
- Advice is the action taken by an aspect at the particular Join Point. eg: Before, After, AfterReturning, AfterThrowing.
- Spring AOP may create chains of Advice for one single Join Point.
- Pointcut is a predicate that matches Join Point.
- An Advice is associated with a Pointcut expression and runs at any Join Point matching that Pointcut.
