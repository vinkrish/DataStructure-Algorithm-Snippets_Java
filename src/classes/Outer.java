package classes;

public class Outer {
	private static String msg = "GeeksForGeeks";

	public class Inner {
		// Both static and non-static members of Outer class are accessible in
		// this Inner class
		public void display() {
			System.out.println("Message from non-static nested class: " + msg);
		}
	}

	public static class StaticNested {
		public void printMessage() {
			// Try making 'message' a non-static variable, there will be
			// compiler error
			System.out.println("Message from nested static class" + msg);
		}
	}

	public void method() {
		// non-static methods can instantiate static and non-static nested
		// classes
		Inner i = new Inner(); // 'this' is the implied enclosing instance
		StaticNested s = new StaticNested();
	}

	public static void main(String[] args) {
		// Inner i = new Inner(); // <-- ERROR! there's no enclosing instance, so cant do this
		
		StaticNested s = new StaticNested(); // ok: no enclosing instance needed
		
		Outer.StaticNested os = new Outer.StaticNested();
		os.printMessage();

		// but we can create an Inner if we have an Outer:
		Outer o = new Outer();
		Inner oi = o.new Inner(); // ok: 'o' is the enclosing instance
		oi.display();
	}

}
