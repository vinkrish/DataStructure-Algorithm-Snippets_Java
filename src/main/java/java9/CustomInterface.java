package java9;

/*
 * Java 8 allowed default methods in Interface and Java 9 allows private scoped and static methods in interfaces. 
 * This will help programmers to keep reusable codes in private interface methods
 */
public interface CustomInterface {
	
	public abstract void method1();
	
	public default void method2() {
		method4();
		method5();
		System.out.println("default method");
	}
	
	public static void method3() {
		method5();
		System.out.println("static method");
	}
	
	private void method4() {
		System.out.println("private method");
	}
	
	private static void method5() {
		System.out.println("private static method");
	}

}
