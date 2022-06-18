package java16;

public class Record {
    public static void main(String[] args) {
        Person person = new Person("Vinay", 30);
        System.out.println(person.name());
        System.out.println(person.age());
    }
    /*
     * For small-scale projects or prototyping, it’s acceptable to define the record in the same file as another class
     */
    public record Person(String name, int age) {}
}

/*
 * Records are a special kind of class in Java that aim to reduce boilerplate code needed for data carriers
 * (i.e., classes that only contain fields, constructors, and accessor methods).
 */
