package java16;

public class InstanceClass {

	public static void main(String[] args) {
		Object obj = "This is a string";
		if (obj instanceof String) {
		    String objString = (String) obj;
		    System.out.println(objString.length());
		}
		if (obj instanceof String objIsString) {
		    System.out.println(objIsString.length());
		}
	}
}

/*
	class Animal {}
	class Dog extends Animal {
	    void bark() { System.out.println("Woof!"); }
	}
	class Cat extends Animal {
	    void meow() { System.out.println("Meow!"); }
	}
	
	void handleAnimal(Animal animal) {
	    if (animal instanceof Dog dog) {
	        dog.bark();
	    } else if (animal instanceof Cat cat) {
	        cat.meow();
	    }
	}
*/
