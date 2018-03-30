package challange;

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
