package classes;

public class StaticTest {
	
	static {
		System.out.println("Hello from the static");
	}
	
	{
		System.out.println("Hello from default method");
	}

	public static void main(String[] args) {
		StaticTest st = new StaticTest();
	}

}
