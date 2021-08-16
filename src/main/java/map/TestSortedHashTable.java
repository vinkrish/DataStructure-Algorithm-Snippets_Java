package map;

import java.util.Date;
import java.util.HashMap;

public class TestSortedHashTable {

	public static void main(String[] args) {
		SortedTableMap<Integer, String> map = new SortedTableMap<>();
        
		System.out.println("Testing time taken for insertion and reading of Sorted HashTable");
		System.out.println(new Date(System.currentTimeMillis()));
        for(int i = 0; i < 9000000; i++) {
        	if(i%2 == 0) {
        		map.put(i, "even");
        	} else {
        		map.put(i, "odd");
        	}
        }
        System.out.println(new Date(System.currentTimeMillis()));
        System.out.println(map.get(900001));
        System.out.println(new Date(System.currentTimeMillis()));
        
        System.out.println("Testing time taken for insertion and reading of HashMap");
        HashMap<Integer, String> hashMap = new HashMap<>();
        System.out.println(new Date(System.currentTimeMillis()));
        for(int i = 0; i < 9000000; i++) {
        	if(i%2 == 0) {
        		hashMap.put(i, "even");
        	} else {
        		hashMap.put(i, "odd");
        	}
        }
        System.out.println(new Date(System.currentTimeMillis()));
        System.out.println(hashMap.get(900001));
        System.out.println(new Date(System.currentTimeMillis()));

//        for (Entry<Integer, String> m:map.entrySet())
//            System.out.println(m.getKey() + " has " + m.getValue());
	}

}
