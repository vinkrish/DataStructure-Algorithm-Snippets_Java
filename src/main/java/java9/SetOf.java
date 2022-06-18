package java9;

import java.util.HashSet;
import java.util.Set;

public class SetOf {

	public static void main(String[] args) {
		// Immutable Set with Immutable Set Objects
		Set<String> imtSet1 = Set.of("A1", "B1", "C1");
		Set<String> imtSet2 = Set.of("A2", "B2", "C2");	
		
		Set<Set<String>> imtFinalSet = Set.of(imtSet1, imtSet2);
		System.out.println(imtFinalSet);
		
		// unmodifiable Set containing the mutable objects is not the immutable Set
		Set<String> set1 = new HashSet<String>();
		set1.add("A1");
		set1.add("B1");
		set1.add("C1");
		Set<String> set2 = new HashSet<String>();
		set2.add("A2");
		set2.add("B2");
		set2.add("C2");	
		
		Set<Set<String>> finalSet = Set.of(set1, set2);
		System.out.println(finalSet);
		
		set1.add("D1");
		System.out.println(finalSet);
		
		// Immutable Set containing objects of custom immutable class
		Student s1 = new Student(33, "Moda");
		Student s2 = new Student(24, "Everest");
		Student s3 = new Student(0, "Kailani");

		Set<Student> imtSet = Set.of(s1, s2, s3);
		imtSet.forEach(s -> System.out.println(s.getName()));
	}

}
class Student {
	  final private int age;  
	  final private String name;
	  public Student(final int age, final String name) {
	      this.age = age;
	      this.name = name;
	  }
	  public int getAge() {
	    return age;
	  }

	  public String getName() {
	    return name;
	  }
	  @Override
	  public boolean equals(Object ob) {
	      return name.equals(((Student)ob).name) &&
	    	  age == ((Student)ob).age;
	  }
	  @Override
	  public int hashCode() {
	      int hash = 13;
	      hash = (31 * hash) + (null == name ? 0 : name.hashCode());
	      return hash;
	  }  
	} 
