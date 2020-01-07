package classes;

public class Reference {
	
	public static void main(String[] args) {
		Demo obj1 = new Demo();
		Demo obj2 = obj1;
 
        obj1.a += 1;
        obj1.b += 1;
 
        System.out.println ("values of obj1 : ");
        obj1.print();
        
        System.out.println ("values of obj2 is same as obj1 as they both reference same object : ");
        obj2.print();
        
        changeObject(obj2);
        
        System.out.println ("values of obj1 after making changes to obj2 : ");
        obj1.print();
    }
	
	public static void changeObject(Demo obj) {
		obj.b -= 1;
	}
}

class Demo {
    int a, b;
     
    Demo() {
        a = 10;
        b = 20;
    }
     
    public void print() {
        System.out.println ("a = " + a + " b = " + b + "\n");
    }
}
 