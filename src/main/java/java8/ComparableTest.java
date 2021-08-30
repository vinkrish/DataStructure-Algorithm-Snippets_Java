package java8;

import java.util.ArrayList;
import java.util.Collections;

/*
 * The ordering provided by the Comparable interface is called the natural ordering
 */
public class ComparableTest {

	public static void main(String[] args) {

		ArrayList<Student> al=new ArrayList<Student>();  
		al.add(new Student(102,"Vijay",23));  
		al.add(new Student(103,"Ajay",27));  
		al.add(new Student(101,"Jai",21));  

//		Collections.sort(al);
		
//		al.sort((s1, s2) -> Integer.valueOf(s1.rollno).compareTo(Integer.valueOf(s2.rollno)));
		al.sort((s1, s2) -> s1.name.compareTo(s2.name));
		
		for(Student st:al){ 
			System.out.println(st.rollno+" "+st.name+" "+st.age);  
		} 

	}

}

 class Student implements Comparable<Student> {
	int rollno;  
	String name;  
	int age;  
	
	Student(int rollno,String name,int age){  
		this.rollno=rollno;  
		this.name=name;  
		this.age=age;  
	}  

	public int compareToAge(Student st){  
		if(age==st.age)  
			return 0;  
		else if(age>st.age)  
			return 1;  
		else  
			return -1;  
	}
	
	public int compareToName(Student st){
		return this.name.compareTo(st.name);
	}
	
	public int compareTo(Student st) {
		return this.rollno < st.rollno ? -1 : this.rollno == st.rollno ? 0 : 1 ;
	}
} 
