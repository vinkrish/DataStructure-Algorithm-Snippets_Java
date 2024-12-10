package java8;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MethodReference {
	
	public static void saySomething(){
        System.out.println("Hello, this is static method.");  
    }

	public static void main(String[] args) {
		
		List<String> helloWorld = Arrays.asList("Hello", "World", "!");
		PrintStream ps = System.out;
		// Using instance::instanceMethod
		helloWorld.stream().forEach(ps::println);
		
		Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
		// Using instance::instanceMethod for comparison
		helloWorld.stream().sorted(comparator::compare).forEach(System.out::println);
		
		Greeter greeter = new Greeter();
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
		// Using instance::instanceMethod
		names.forEach(greeter::greet);

		// You can pass methods of a class as implementations to interfaces
        Sayable sayable = MethodReference::saySomething;  // Referring static method  
        
        // Calling interface method  
        sayable.say();
        
        // Constructor Reference:
        Creator creator = MyObject::new;
        MyObject obj = creator.create("Test Object");
        obj.print();
        
        List<Person> persons = Arrays.asList(
                new Person("Vinay", 30),
                new Person("Krishna", 31),
                new Person("Angel", 22),
                new Person("Krishna", 1)
        );
        
        // static method reference
        Collections.sort(persons, Person::compareAges);
        persons.forEach(people -> System.out.println(people));
        
        // instance method reference 
        MethodReference mr = new MethodReference();
        mr.sortData();
        
	}
	
	public void sortData() {
		List<Person> persons = Arrays.asList(
                new Person("Vinay", 30),
                new Person("Krishna", 31),
                new Person("Angel", 22),
                new Person("Krishna", 1)
        );
		
		Collections.sort(persons, this::compareAges);
		persons.forEach(people -> System.out.println(people));
	}
	
	public int compareAges(Person p1, Person p2) {
		Integer age1 = p1.getAge();
		return age1.compareTo(p2.getAge());
	}

}

class Greeter {
    public void greet(String name) {
        System.out.println("Hello, " + name);
    }
}

interface Sayable{  
    void say();  
}

class MyObject {
    private String name;

    public MyObject(String name) {
        this.name = name;
    }
    
    public void print() {
    	System.out.println(this.name);
    }
}

@FunctionalInterface
interface Creator {
    MyObject create(String name);
}

