### Functional Interfaces

- A functional interface has a single abstract method.
- Functional interfaces included with Java runtime. eg: Runnable, Callable, Comparator, TimerTask
- Prior to Java 8 it is known as Single Abstract Method (SAM) Types. 

### Method References

A method reference provides a way to refer to a method of an existing class or instance in a concise manner. Instead of writing a full lambda expression, method references allow you to reuse an existing method and pass it directly as an argument where a functional interface is expected. The method reference can be used in contexts where a lambda expression would be used.

Method reference is used to refer method of functional interface. It is compact and easy form of lambda expression. Each time when you are using lambda expression to just referring a method, you can replace your lambda expression with method reference.

#### Types of Method References

- Reference to a static method
- Reference to an instance method of a particular object or arbitrary object
- Reference to an instance method from class type
- Reference to a constructor

#### 1. Reference to a Static Method

You can refer to static method defined in the class. Following is the syntax and example which describe the process of referring static method in Java.

```java
ContainingClass::staticMethodName
Math::max => Math.max(x,y)
```

#### 2. Reference to an Instance Method

a. Like static methods, you can refer instance methods also  
b. Invoke the instance method on a reference to an object supplied by the context

```java
containingObject::instanceMethodName  
System.out::println => System.out.println(x)

String::length => str.length()

// Reference to an instance method of an arbitrary object of a particular type:
String::toUpperCase
```

#### 3. Reference to a Constructor

You can refer a constructor by using the new keyword

```java
ClassName::new
ArrayList::new => ArrayList()
```

### Lambda Expressions

Lambda expressions can only appear in places where they will be assigned to a variable whose type is a functional interface.

Syntax:

```java
(parameters) -> {expression or code block}
```

One issue with anonymous classes is that if the implementation of your anonymous class is very simple, such as an interface that contains only one method, then the syntax of anonymous classes may seem unwieldy and unclear. In these cases, you're usually trying to pass functionality as an argument to another method, such as what action should be taken when someone clicks a button. Lambda expressions enable you to do this, to treat functionality as method argument, or code as data.

Anonymous Classes, shows you how to implement a base class without giving it a name. Although this is often more concise than a named class, for classes with only one method, even an anonymous class seems a bit excessive and cumbersome. Lambda expressions let you express instances of single-method classes more compactly.

### Optional

Java 8 has introduced a new class Optional in java.util package. It is used to represent a value is present or absent. The main advantage of this new construct is that No more too many null checks. It avoids any runtime `NullPointerExceptions` and supports us in developing clean and neat Java APIs or Applications. Like Collections and arrays, it is also a Container to hold at most one value. Let us explore this new construct with some useful examples.

Advantages of Java 8 Optional:

- Null checks are not required.
- No more NullPointerException at run-time.
- We can develop clean and neat APIs.
- No more Boiler plate code

### Streams

1. The main difference between intermediate and terminal operations is that intermediate operations return a stream as a result and terminal operations return non-stream values like primitive or object or collection or may not return anything.

2. As intermediate operations return another stream as a result, they can be chained together to form a pipeline of operations. Terminal operations cannot be chained together.

3. Pipeline of operations may contain any number of intermediate operations, but there has to be only one terminal operation, that too at the end of pipeline.

4. Intermediate operations are lazily loaded. When you call intermediate operations, they are actually not executed. They are just stored in the memory and executed when the terminal operation is called on the stream.

5. As the names suggest, intermediate operations doesn’t give end result. They just transform one stream to another stream. On the other hand, terminal operations give end result.

![Streams](https://vinkrish-notes.s3.us-west-2.amazonaws.com/streams.jpeg)