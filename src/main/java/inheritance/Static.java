package inheritance;

class BaseA {
    public static void show() {
       System.out.println("Base::show() called");
    }
}
  
class DerivedA extends BaseA {
    public static void show() {
       System.out.println("Derived::show() called");
    }
}
  
class Static {
    public static void main(String[] args) {
        BaseA b = new DerivedA();
        b.show();
        DerivedA.show();
    }
}