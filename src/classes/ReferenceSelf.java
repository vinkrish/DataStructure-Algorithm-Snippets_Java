package classes;

public class ReferenceSelf {
	int a = 1;
    int b = 2;
 
    ReferenceSelf func(ReferenceSelf obj)
    {
    	ReferenceSelf obj3 = new ReferenceSelf();
        obj3 = obj;
        obj3.a = obj.a++ + ++obj.b;
        obj.b = obj.b;
        return obj3;
    }
 
    public static void main(String[] args)
    {
    	ReferenceSelf obj1 = new ReferenceSelf();
    	ReferenceSelf obj2 = obj1.func(obj1);
 
        System.out.println("obj1.a = " + obj1.a + "  obj1.b = " + obj1.b);
        System.out.println("obj2.a = " + obj2.a + "  obj1.b = " + obj2.b);
 
        // obj1 and obj2 refer to same object
    }
}
