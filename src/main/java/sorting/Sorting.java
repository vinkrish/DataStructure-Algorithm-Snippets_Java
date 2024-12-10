package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Sorting {

	public static void main(String[] args) {
		int[] numbers = {4, 2, 9, 1, 5};
        Arrays.sort(numbers); // Sort in ascending order
        System.out.println(Arrays.toString(numbers)); // Output: [1, 2, 4, 5, 9]
        
        // Convert int[] to Integer[]
        Integer[] numbersArray = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        Arrays.sort(numbersArray, Collections.reverseOrder()); // Sort in descending order
        System.out.println(Arrays.toString(numbersArray)); // Output: [9, 5, 4, 2, 1]
        
        String[] names = {"Vinay", "Lydia", "Angel"};
        Arrays.sort(names); // Sort alphabetically
        System.out.println(Arrays.toString(names)); // Output: [Angel, Lydia, Vinay]
        
        Arrays.sort(names, Collections.reverseOrder());
        System.out.println(Arrays.toString(names)); // Output: [Vinay, Lydia, Angel]
        
        // Sorting List of Class Objects
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Angel", 27));
        people.add(new Person("Lydia", 0));
        people.add(new Person("Vinay", 36));

        // Sort by age (ascending)
        Collections.sort(people, Comparator.comparingInt(p -> p.age));
        System.out.println(people); // Output: [Lydia (0), Angel (27), Vinay (36)]
        
        // Sort by age (descending)
        Collections.sort(people, (p1, p2) -> p2.age - p1.age);
        System.out.println(people); // Output: [Vinay (36), Angel (27), Lydia (0)]
        
        // Sort by name (alphabetically)
        Collections.sort(people, Comparator.comparing(p -> p.name));
        System.out.println(people); // Output: [Angel (27), Lydia (0), Vinay (36)]
        
        // Sort by name in descending alphabetical order
        Collections.sort(people, Comparator.comparing((Person p) -> p.name).reversed());
        System.out.println(people); // Output: [Vinay (36), Lydia (0), Angel (27)]

        Collections.sort(people, (p1, p2) -> p2.name.compareTo(p1.name));
        System.out.println(people); // Output: [Vinay (36), Lydia (0), Angel (27)]
        
        // Sorting Maps
        Map<String, Integer> map = new HashMap<>();
        map.put("Vinay", 36);
        map.put("Angel", 27);
        map.put("Lydia", 0);

        // Sort by keys
        Map<String, Integer> sortedByKey = new TreeMap<>(map);
        System.out.println(sortedByKey); // { Angel=27, Lydia=0, Vinay=36 }
        
        // Create a TreeMap with a custom comparator for descending order
        Map<String, Integer> sortedByKeyDesc = new TreeMap<>(Collections.reverseOrder());
        sortedByKeyDesc.putAll(map);
        System.out.println(sortedByKeyDesc); // Output: {Vinay=36, Lydia=0, Angel=27}
        
        // Sort by values
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByValue());
        // Convert sorted list back to a LinkedHashMap to maintain order
        Map<String, Integer> sortedByValue = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            sortedByValue.put(entry.getKey(), entry.getValue());
        }
        System.out.println(sortedByValue); // Output: {Lydia=0, Vinay=27, Angel=36}

        entries.sort((e1, e2) -> e2.getValue() - e1.getValue()); // Sort in descending order
        Map<String, Integer> sortedByValueDesc = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            sortedByValueDesc.put(entry.getKey(), entry.getValue());
        }
        System.out.println(sortedByValueDesc); // Output: {Angel=36, Vinay=27, Lydia=0}

	}

}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}