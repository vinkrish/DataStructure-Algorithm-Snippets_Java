### Equality

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

### HashCode

General Contracts for hashCode() in Java:

- If two objects are considered equal, their hashcodes must also be equal.
- Whenever the hashCode() method is invoked on the same object more than once within a single execution of the application, hashCode() must return the same integer provided no information or fields used in equals and hashcode is modified.
- If two objects are not equaled by equals() method it is not require that there hashcode must be different. Though it’s always good practice to return different hashCode for unequal object.

You must override hashCode() in every class that overrides equals(). Failure to do so will result in a violation of the general contract for Object.hashCode(), which will prevent your class from functioning properly in conjunction with all hash-based collections, including HashMap, HashSet and HashTable.

Hashing retrieval is a two-step process:

- Find the right bucket...using hashCode()
- Search the bucket for the right element...using equals()

[Follow this for complete example...](https://stackoverflow.com/questions/1894377/understanding-the-workings-of-equals-and-hashcode-in-a-hashmap)
