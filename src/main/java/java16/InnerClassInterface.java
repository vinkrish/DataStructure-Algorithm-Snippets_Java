package java16;

public class InnerClassInterface {

	public static void main(String[] args) {
		class InnerClass {
            interface Calculator {
                static int add(int a, int b) {
                    return a + b;
                }
            }
        }
        System.out.println(InnerClass.Calculator.add(5, 10));  // Output: 15
	}
}

/*
 * Java 16 allows interfaces in local inner classes to have static members.
 * This is useful when defining utility methods inside an interface in a local class.
 * 
 * Here InnerClass is a local class, A local class is a class defined within a method or block.
 */
