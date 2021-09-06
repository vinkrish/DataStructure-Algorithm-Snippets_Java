package commontests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ComplexSort {

	public static void main(String[] args) {
		Integer[] arr = new Integer[]{11,132,22};
	    
	    complexSort(arr);

	}
	
	static void complexSort(Integer[] arr) {
	    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
	    for(Integer a: arr) {
	      System.out.println(Integer.toString(a).substring(0, 1));
	      if(map.get(Integer.parseInt(Integer.toString(a).substring(0, 1))).size() > 0) {
	        ArrayList<Integer> temp = map.get(Integer.parseInt(Integer.toString(a).substring(0, 1)));
	        temp.add(a);
	        map.put(Integer.parseInt(Integer.toString(a).substring(0, 1)), temp);
	      } else {
	        ArrayList<Integer> temp = new ArrayList<>();
	        temp.add(a);
	        map.put(Integer.parseInt(Integer.toString(a).substring(0, 1)), temp);
	      }
	    }
	    
	    for(Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()) {
	      System.out.println(entry.getKey() + ": " + entry.getValue());
	    }
	    
	  }

}
