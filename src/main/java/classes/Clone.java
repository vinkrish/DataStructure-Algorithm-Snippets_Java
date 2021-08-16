package classes;

public class Clone {
	public static void main(String args[])
    {
		TestClone obj1 = new TestClone();
		TestClone obj2;
        obj1.a = 10;
        obj2 = obj1.cloning();
        obj2.a = 20;
 
        System.out.println("obj1.a = " + obj1.a);
        System.out.println("obj2.a = " + obj2.a);
        
        // below is not a clone
        Box box1 = new Box();
		Box box2 = new Box();
		box1.height = 1;
		
		box2 = box1;
		box2.height = 2;
		System.out.println("box1.height = " + box1.height);
		System.out.println("box2.height = " + box2.height);
    }
}

class TestClone implements Cloneable
{
    int a;
 
    TestClone cloning()
    {
        try
        {
            return (TestClone) super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            System.out.println("CloneNotSupportedException is caught");
            return this;
        }
    }
}

class Box {
	int height;
	int length;
	int width;
}
