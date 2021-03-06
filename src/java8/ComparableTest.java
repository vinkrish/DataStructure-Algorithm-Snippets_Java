package java8;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableTest {

	public static void main(String[] args) {

		ArrayList<Student> al=new ArrayList<Student>();  
		al.add(new Student(101,"Vijay",23));  
		al.add(new Student(106,"Ajay",27));  
		al.add(new Student(105,"Jai",21));  

		// Collections.sort(al);
		al.sort((s1, s2) -> s1.name.compareTo(s2.name));
		
		for(Student st:al){ 
			System.out.println(st.rollno+" "+st.name+" "+st.age);  
		} 

	}

	static class Student implements Comparable<Student>{  
		int rollno;  
		String name;  
		int age;  
		
		Student(int rollno,String name,int age){  
			this.rollno=rollno;  
			this.name=name;  
			this.age=age;  
		}  

		public int compareTo2(Student st){  
			if(age==st.age)  
				return 0;  
			else if(age>st.age)  
				return 1;  
			else  
				return -1;  
		}
		
		public int compareTo(Student st){
			return this.name.compareTo(st.name);
		}
	} 

}
