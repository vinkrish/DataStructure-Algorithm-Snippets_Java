package list;

import java.util.ArrayList;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		Vector v = new Vector();
           
        v.add(1);
        v.add(2);
        v.add("geeks");
        v.add("forGeeks");
        v.add(3);
        
        System.out.println("Vector v: " + v);
        
        ArrayList arr = new ArrayList();
        arr.add(3);
        arr.add("geeks");
        arr.add("forgeeks");
        arr.add(4);
         
        
         // createn default vector
         Vector v2 = new Vector();
          
         v2.add(2);
         // copying all element of array list int0 vector
         v2.addAll(1, arr);
          
         // checking vector v
         System.out.println("vector v2:" + v2);
	}

}
