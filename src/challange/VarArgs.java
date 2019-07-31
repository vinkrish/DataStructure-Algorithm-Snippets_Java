package challange;

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

	}

}
