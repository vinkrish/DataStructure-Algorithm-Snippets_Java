package set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public static void main(String[] args) {
		HashSet<String> h = new HashSet<String>();
		 
        // adding into HashSet
        h.add("India");
        h.add("Australia");
        h.add("South Africa");
        h.add("India");// adding duplicate elements
 
        // printing HashSet
        System.out.println(h);
        System.out.println("List contains India or not:" +
                           h.contains("India"));
 
        // Removing an item
        h.remove("Australia");
        System.out.println("List after removing Australia:"+h);
 
        // Iterating over hash set items
        System.out.println("Iterating over list:");
        Iterator<String> i = h.iterator();
        while (i.hasNext())
            System.out.println(i.next());
        
        
        Employee employee = new Employee("rajeev", 24);
        Employee employee1 = new Employee("rajeev", 25);
        Employee employee2 = new Employee("rajeev", 24);

        HashSet<Employee> employees = new HashSet<Employee>();
        employees.add(employee);
        employees.add(employee1);
        System.out.println(employees.contains(employee2));
        System.out.println("employee.hashCode():  " + employee.hashCode()
        + "  employee2.hashCode():" + employee2.hashCode());

	}

}

class Employee {

    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Employee))
            return false;
        Employee employee = (Employee) obj;
        return employee.getAge() == this.getAge()
                && this.getName().equals(getName());
    }

	@Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + age;
        hash = 31 * hash + (name!=null ? name.hashCode():0);
        return hash;
    }
}
