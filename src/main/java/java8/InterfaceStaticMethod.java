package java8;

interface CalculatorStatic {
    static int add(int a, int b) {
        return a + b;
    }
}

public class InterfaceStaticMethod {
	public static void main(String[] args) {
        int result = CalculatorStatic.add(5, 10);
        System.out.println(result);
    }
}

/* Why Static Methods Were Introduced:
	Utility Methods: Similar to static methods in classes, these methods allow the definition of helper or utility functions related to the interface.
	
	Consistency: Java already allowed static methods in classes, and introducing them to interfaces brought consistency between interfaces and classes.
	
	Evolution of API Design: By adding static methods to interfaces, 
	library authors can provide commonly used behavior that operates on types related to the interface, 
	without forcing each implementing class to re-implement them.
 */
