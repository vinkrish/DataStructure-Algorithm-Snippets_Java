package operators;

public class Shift {
	public static void main(String args[])  {
       int x = -4;
       System.out.println(x>>1);  
       int y = 4;
       System.out.println(y<<1); 
       //arithmetic shift
       
       int z = -1;  
       System.out.println(z>>>29);  
       System.out.println(z>>>30);  
       System.out.println(z>>>31); 
       //logical shift
    }
}
