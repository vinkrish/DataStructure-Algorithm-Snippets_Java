package set;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class CommonElementsSet {
	
	private final static int numberOfEntries = 20000000;
    private final static int maxRandom = numberOfEntries;
    
    private Set<Integer> s1;
    private Set<Integer> s2;

    private Set<Integer> fillWithRandomEntries(Random random, int entries) {
        Set<Integer> rv = new HashSet<>();
        for (int i = 0; i < entries; i++) {
            rv.add(random.nextInt(maxRandom));
        }
        return rv;
    }

    public void classic() {
        long start = System.currentTimeMillis();
        HashSet<Integer> intersection = new HashSet<>();
          s1.forEach((i) -> {
           if (s2.contains(i))
             intersection.add(i);
        });
        long end = System.currentTimeMillis();
        System.out.println("foreach duration: " + (end-start) + " ms");
        System.out.println("intersection.size() = " + intersection.size());
    }


    public void retainAll() {
        long start = System.currentTimeMillis();
        s1.retainAll(s2);
        long end = System.currentTimeMillis();
        System.out.println("Retain all duration: " + (end-start) + " ms");
        System.out.println("intersection.size() = " + s1.size());
    }

    public void streams() {
        long start = System.currentTimeMillis();
        Set<Integer> intersection = s1.stream().filter(i -> s2.contains(i)).collect(Collectors.toSet());
        long end = System.currentTimeMillis();
        System.out.println("streaming: " + (end-start) + " ms");
        System.out.println("intersection.size() = " + intersection.size());
    }

    public void parallelStreams() {
        long start = System.currentTimeMillis();
        Set<Integer> intersection = s1.parallelStream().filter(i -> s2.contains(i)).collect(Collectors.toSet());
        long end = System.currentTimeMillis();
        System.out.println("parallel streaming: " + (end-start) + " ms");
        System.out.println("intersection.size() = " + intersection.size());
    }

	public static void main(String[] args) {
		Random random = new Random(42);
		
		CommonElementsSet cse = new CommonElementsSet();
		cse.s1 = cse.fillWithRandomEntries(random, numberOfEntries);
		cse.s2 = cse.fillWithRandomEntries(random, numberOfEntries);
		
		cse.classic();
		
		cse.retainAll();
		
		cse.streams();
		
		cse.parallelStreams();
	}

}
