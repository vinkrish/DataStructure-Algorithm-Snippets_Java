package dynamicprog;

/*
 * https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
 */
public class RodCutting {
	 /* Returns the best obtainable price for a rod of length 
    	n and price[] as prices of different pieces */
	 static int cutRod(int price[], int n) 
	 { 
		 System.out.println("Outer n: " + n);
		 System.out.println("\n");
	     if (n <= 0) 
	         return 0; 
	     int max_val = Integer.MIN_VALUE; 
	
	     // Recursively cut the rod in different pieces and 
	     // compare different configurations 
	     
	     for (int i = 0; i<n; i++) {
	    	 System.out.println("before n: " + n);
	    	 System.out.println("before i: " + i);
	    	 System.out.println("price at i: " + price[i]);
	    	 System.out.println("\n");
	    	 max_val = Math.max(max_val, price[i] + cutRod(price, n-i-1)); 
	    	 System.out.println("after n: " + n);
	    	 System.out.println("after i: " + i);
	    	 System.out.println("Inner max_val: " + max_val);
	     }	        
	
	     System.out.println("max_val: " + max_val);
	     System.out.println("\n");
	     return max_val; 
	 } 
	
	 /* Driver program to test above functions */
	 public static void main(String args[]) 
	 { 
	     int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20}; 
	     int size = arr.length; 
	     System.out.println("Maximum Obtainable Value is " + cutRod(arr, 5));
	 } 

}
