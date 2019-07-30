package java8;

public class ConstructorReference {

	public static void main(String[] args) {
		Messageable hello = Message::new;  
        hello.getMessage("Hello");
	}

}

interface Messageable{  
    Message getMessage(String msg);  
}

class Message{  
    Message(String msg){  
        System.out.print(msg);  
    }
} 
