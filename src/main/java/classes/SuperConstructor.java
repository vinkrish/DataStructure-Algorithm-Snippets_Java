package classes;

public class SuperConstructor {

	public static void main(String[] args) {
		Child child = new Child();
	}

}

class Parent {
    Parent(String message) {
        System.out.println("Parent constructor with message: " + message);
    }
    Parent() {
        System.out.println("Parent default constructor");
    }
}

class Child extends Parent {
    Child() {
        super("From Child"); // Calls parameterized constructor of Parent
        System.out.println("Child constructor called");
    }
}

