### Method References

Java provides a new feature called method reference in Java 8. Method reference is used to refer method of functional interface. It is compact and easy form of lambda expression. Each time when you are using lambda expression to just referring a method, you can replace your lambda expression with method reference.

#### Types of Method References

- Reference to a static method
- Reference to an instance method
- Reference to a constructor

#### 1. Reference to a Static Method

You can refer to static method defined in the class. Following is the syntax and example which describe the process of referring static method in Java.

```java
ContainingClass::staticMethodName
```

#### 2. Reference to an Instance Method

like static methods, you can refer instance methods also

```java
containingObject::instanceMethodName  
```

#### 3. Reference to a Constructor

You can refer a constructor by using the new keyword

```java
ClassName::new
```

### Optional

Java 8 has introduced a new class Optional in java.util package. It is used to represent a value is present or absent. The main advantage of this new construct is that No more too many null checks. It avoids any runtime `NullPointerExceptions` and supports us in developing clean and neat Java APIs or Applications. Like Collections and arrays, it is also a Container to hold at most one value. Let us explore this new construct with some useful examples.

Advantages of Java 8 Optional:

- Null checks are not required.
- No more NullPointerException at run-time.
- We can develop clean and neat APIs.
- No more Boiler plate code

