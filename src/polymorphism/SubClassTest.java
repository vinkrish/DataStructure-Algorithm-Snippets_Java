package polymorphism;

public class SubClassTest {

	public static void main(String[] args) {
		Subclass sc = new Subclass();
		sc.foo();
		sc.bar();
		Subclass.staticFoo(); // sc.staticFoo() works too with warning
		Super s = new Subclass();
		s.foo();
		// s.bar();
		// s.staticFoo();
	}

}

class Super {
	void foo() {
		System.out.println("Super");
	}
}

class Subclass extends Super {
	void foo() {
		System.out.println("Subclass");
	}
	void bar() {
		System.out.println("bar");
	}
	static void staticFoo() {
		System.out.println("static subclass method");
	}
}