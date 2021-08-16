package polymorphism;

public class Downcasting {

	public static void main(String[] args) {
		Animl a=new DogD();  
	    DogD.method(a);  
	}

}

class Animl {}

class DogD extends Animl {
	static void method(Animl a) {  
	    if(a instanceof DogD){  
	       DogD d=(DogD)a; //downcasting  
	       System.out.println("ok downcasting performed");  
	    }  
	  }
}
