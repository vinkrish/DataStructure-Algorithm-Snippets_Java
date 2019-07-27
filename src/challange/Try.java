package challange;

class A {
    public A() {
        System.out.print("A");
    }
}

class B extends A {
    public B() {
        System.out.print("B");
        //super(); super alwasy runs first
    }
}

public class Try {
    public static void main(String[] args) {
        new B();
    }
}
