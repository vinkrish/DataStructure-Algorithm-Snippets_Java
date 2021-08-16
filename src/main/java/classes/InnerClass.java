package classes;

class DemoClass {
	private static String msg = "Vinkrish";
	int a = 1;

	void func() {
		Demo obj = new Demo();
		obj.display();
	}

	public class Demo {
		int a = 3;
		int b = 2;

		void display() {
			System.out.println("a = " + a);
			System.out.println("Outer a = " + DemoClass.this.a);
			System.out.println("Outer msg = " + msg);
		}
	}

	// only nested class can be declared static, no outer class can be declared static
	public static class StaticDemo {
		int a = 3;
		int b = 2;

		void display() {
			System.out.println("a = " + a);
			System.out.println("Outer msg = " + msg);
		}
	}

}

class InnerClass {
	public static void main(String[] args) {
		DemoClass obj = new DemoClass();
		obj.func();

		System.out.println();
		
		DemoClass.Demo demo = obj.new Demo();
		demo.display();

		System.out.println();
		
		DemoClass.StaticDemo staticDemo = new DemoClass.StaticDemo();
		staticDemo.display();
	}
}
