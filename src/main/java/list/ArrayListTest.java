package list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		// size of ArrayList
        int n = 5;
 
        //declaring ArrayList with initial size n
        List<Integer> arrli = new ArrayList<>(n);
 
        // Appending the new element at the end of the list
        for (int i=1; i<=n; i++)
            arrli.add(i);
 
        // Printing elements
        System.out.println(arrli);
 
        // Remove element at index 3
        arrli.remove(3);
 
        // Displaying ArrayList after deletion
        System.out.println(arrli);
 
        // Printing elements one by one
        for (Integer i: arrli)
            System.out.print(arrli.get(i)+" ");
        
	}

}
