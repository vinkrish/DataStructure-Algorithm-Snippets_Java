package inheritance;

class Base {
    public void Print() {
        System.out.println("Base");
    }         
}
 
class DerivedBase extends Base {    
    public void Print() {
        System.out.println("Derived");
    }
}
 
class Derived{
    public static void DoPrint( Base o ) {
        o.Print();   
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
