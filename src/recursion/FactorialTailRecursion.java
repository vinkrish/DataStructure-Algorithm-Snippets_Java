package recursion;
import java.util.Scanner;

public class FactorialTailRecursion {
	  public static long factorial(int n) {
	    return factorial(n, 1); // Call auxiliary method
	  }
	    
	  /** Auxiliary tail-recursive method for factorial */
	  private static long factorial(int n, int result) {
	    if (n == 0) 
	      return result;
	    else
	      return factorial(n - 1, n * result);
	  }
	  
	  public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    System.out.print("Enter a non-negative integer: ");
	    int n = input.nextInt();
	    
	    System.out.println("Factorial of " + n + " is " + factorial(n));
	  }
	}
