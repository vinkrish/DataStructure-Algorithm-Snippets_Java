package misc;

public class OverrideEquals {

	public static void main(String[] args) {
		// Reference Equality
		
		// Create three String objects.
		String strA = new String("APPLES");
		String strB = new String("APPLES");
		String strC = new String("ORANGES");
		
		// Create a String reference and assign an existing String's reference to it
		// so that both references point to the same String object in memory.
		String strD = strA;
				
		// Print out the results of various equality checks
		System.out.println(strA == strB);
		System.out.println(strA == strC);
		System.out.println(strA == strD);
		
		// Logical Equality
		System.out.println(strA.equals(strB));
		System.out.println(strA.equals(strC));
		System.out.println(strA.equals(strD));
		
		// Thread works same way?
		Thread t1 = new Thread();
        Thread t2 = new Thread();
        Thread t3 = t1;
        
        System.out.println(t1 == t3);
        System.out.println(t1 == t2);
 
        System.out.println(t1.equals(t2));
        System.out.println(t1.equals(t3));
	}

	public class A
	{
	   // Class implementation not shown except for equals

	   public boolean equals(Object other)
	   {
	      if (other == null)
	      {
	         return false;
	      }

	      if (this.getClass() != other.getClass())
	      {
	         return false;
	      }

	      // Rest of equals method here, i.e., check all class A instance variables for equality
	      A obj = (A) other;
	      // obj.getMethod1() == this.getMethod1() && obj.getMethod2().equals(this.getMethod2());
	      
	      return true;
	   }
	}
	
	public class B extends A
	{
	   // Class implementation not shown except for equals

	   public boolean equals(Object other)
	   {
	      if (!super.equals(other))
	      {
	         return false;
	      }

	      // Rest of equals method here, i.e., check all class B instance variables for equality
	      return true;
	   }
	}
	
	public class C extends B
	{
	   // Class implementation not shown except for equals

	   public boolean equals(Object other)
	   {
	      if (!super.equals(other))
	      {
	         return false;
	      }

	      // Rest of equals method here, i.e., check all class C instance variables for equality
	      return true;
	   }
	}
	
}


