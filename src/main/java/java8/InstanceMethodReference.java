package java8;

public class InstanceMethodReference {
	
	public void saySomething(){  
        System.out.println("Hello, this is non-static method.");  
    }  

	public static void main(String[] args) {
		InstanceMethodReference methodReference = new InstanceMethodReference();
		
        // Referring non-static method using reference
		Sayabl sayable = methodReference::saySomething;
        
        // Calling interface method  
        sayable.say();
        
        // Referring non-static method using anonymous object  
        Sayabl sayable2 = new InstanceMethodReference()::saySomething;
        
        // Calling interface method  
        sayable2.say();  

	}

}

interface Sayabl{  
    void say();  
}
