package challange;

import java.util.*;

public class ComparatorTest {

	public static void main(String[] args) {
		
		ArrayList<Student> ar = new ArrayList<Student>();
        ar.add(new Student(111, "bbbb", "london"));
        ar.add(new Student(131, "aaaa", "nyc"));
        ar.add(new Student(121, "cccc", "jaipur"));
 
        System.out.println("Unsorted");
        for (Student stud: ar)
            System.out.println(stud);
 
        // Collections.sort(ar, new Sortbyroll());
        
        // Sorting using lambda expression
        Collections.sort(ar, (s1, s2) -> s1.rollno - s2.rollno);
 
        System.out.println("\nSorted by rollno");
        for (Student stud: ar)
            System.out.println(stud);
 
        // Collections.sort(ar, new Sortbyname());
        
        // Sorting using lambda expression
        Collections.sort(ar, (s1, s2) -> s1.name.compareTo(s2.name));
 
        System.out.println("\nSorted by name");
        for (Student stud: ar)
            System.out.println(stud);

	}
	
	static class Student
	{
	    int rollno;
	    String name, address;
	 
	    // Constructor
	    public Student(int rollno, String name, String address){
	        this.rollno = rollno;
	        this.name = name;
	        this.address = address;
	    }
	 
	    // Used to print student details in main()
	    public String toString(){
	        return this.rollno + " " + this.name + " " + this.address;
	    }
	}
	 
	static class Sortbyroll implements Comparator<Student>
	{
	    // Used for sorting in ascending order of
	    // roll number
	    public int compare(Student a, Student b)
	    {
	        return a.rollno - b.rollno;
	    }
	}
	 
	static class Sortbyname implements Comparator<Student>
	{
	    // Used for sorting in ascending order of
	    // roll name
	    public int compare(Student a, Student b)
	    {
	        return a.name.compareTo(b.name);
	    }
	}

}
