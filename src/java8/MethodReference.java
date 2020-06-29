package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MethodReference {
	
	public static void saySomething(){
        System.out.println("Hello, this is static method.");  
    }

	public static void main(String[] args) {
		
		// Referring static method  
        Sayable sayable = MethodReference::saySomething;  
        
        // Calling interface method  
        sayable.say();
        
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

interface Sayable{  
    void say();  
} 
