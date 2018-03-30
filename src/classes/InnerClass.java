package classes;

class demoClass
{
    int a = 1;
 
    void func()
    {
        demo obj = new demo();
        obj.display();
    }
 
 
    class demo
    {
    	int a = 3;
        int b = 2;
 
        void display()
        {
        	System.out.println("\na = " + a);
            System.out.println("\nOuter a = " + demoClass.this.a);
        }
    }
 
}
 
 
class InnerClass
{
    public static void main(String[] args)
    {
        demoClass obj = new demoClass();
        obj.func();
        demoClass.demo demo = obj.new demo();
        demo.display();
    }
}
