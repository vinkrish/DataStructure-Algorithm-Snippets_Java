Often in Java programs you need to compare two objects to determine if they are equal or not.  It turns out there are two different kinds of equality one can determine about objects in Java, **reference equality** or **logical equality**.

Equality operator (==) compares the references (addresses in memory) of the two Strings as two different numbers - this is known as Reference Equality.

Logical equality compares the data of the objects instead of the value of the references.

> Why, you might ask, did the String class override the equals method inherited from the Object class? 

Because the equals method inherited from Object performs reference equality!  Here is what the implementation of the equals method in Object looks like:

```java
public boolean equals(Object other)
{
   return this == other;
}
```

Notice that the parameter type is Object - it must be Object or you will have overloaded equals instead of overriding it.

#### Inheritance and the equals Method

When overriding the equals method in classes making use of inheritance it is important to keep the super class and sub-class as loosely coupled as possible. Loosely coupled classes make as few assumptions about each other as possible making the code more maintainable over time. A secondary goal is to avoid duplication of code.
