package commontests;

public class VarArgs {
	
	 static void display(String... values){
		System.out.println("Number of arguments is: "+ values.length); 
		  
		// using for each loop to display contents of values
		for (String val: values) 
		    System.out.print(val + " "); 
	 } 

	public static void main(String[] args) {
		
		display();//zero argument
		
		display("my","name","is","varargs");//four arguments  
		
		printArray(1, 2, 3, 4);                 // Output: 1 2 3 4
	    printArray("A", "B", "C");              // Output: A B C
	    printArray(1.5, 2.7, 3.9);              // Output: 1.5 2.7 3.9

	}
	
	public static <T> void printArray(T... elements) {
	    for (T element : elements) {
	        System.out.println(element);
	    }
	}

}
