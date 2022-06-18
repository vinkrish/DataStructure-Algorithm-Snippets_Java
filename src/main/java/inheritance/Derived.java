package inheritance;

class Base {
    public void print() {
        System.out.println("Base");
    }         
}
 
class DerivedBase extends Base {    
    public void print() {
        System.out.println("Derived");
    }
    public void derivedPrint() {
    	System.out.println("Derived Print");
    }
}
 
class Derived{
	/*
	 * Upcasting refers to the process where an object of a subclass is treated as an instance of its superclass.
	 */
    public static void DoPrint( Base o ) {
        if (o instanceof DerivedBase db) db.derivedPrint();
        else o.print();
    }
    public static void main(String[] args) {
        Base x = new Base();
        Base y = new DerivedBase();
        DerivedBase z = new DerivedBase();
        DoPrint(x);
        DoPrint(y);
        DoPrint(z);
    }
}
