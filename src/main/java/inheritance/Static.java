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

/*
	Polymorphism in Java works for instance methods (non-static methods) because they are resolved at runtime, 
	based on the actual object's type.
	 
	Static methods, however, are resolved at compile-time based on the reference type, 
	and thus static methods cannot be overridden in the same way instance methods can be.
	 
	This is known as method hiding in Java, not overriding.
	
	In this case, DerivedA.show() is hiding the BaseA.show() method.
*/