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
			System.out.println("\na = " + a);
			System.out.println("\nOuter a = " + DemoClass.this.a);
			System.out.println("\nOuter msg = " + msg);
		}
	}

	public static class StaticDemo {
		int a = 3;
		int b = 2;

		void display() {
			System.out.println("\na = " + a);
			System.out.println("\nOuter msg = " + msg);
		}
	}

}

class InnerClass {
	public static void main(String[] args) {
		DemoClass obj = new DemoClass();
		obj.func();

		DemoClass.Demo demo = obj.new Demo();
		demo.display();

		DemoClass.StaticDemo staticDemo = new DemoClass.StaticDemo();
		staticDemo.display();
	}
}
