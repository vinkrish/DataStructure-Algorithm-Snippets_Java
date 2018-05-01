package classes;

public class StaticInnerClass {

	static int data = 30;

	static class Inner {
		void msg() {
			System.out.println("data is " + data);
		}
	}

	public static void main(String[] args) {
		StaticInnerClass.Inner obj = new StaticInnerClass.Inner();
		obj.msg();
	}

}
