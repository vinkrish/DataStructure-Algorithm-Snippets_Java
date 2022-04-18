package java8;

import java.util.Optional;

public class Person {
	
	private String name;
    private int age;
    private Double price;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public Person(String name, Double price) {
        this.name = name;
        this.price = price;
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
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Person {name=" + name + ", age=" + age + "}";
	}
	
	public static int compareAges(Person p1, Person p2) {
		Integer age1 = p1.getAge();
		return age1.compareTo(p2.getAge());
	}
	
	public boolean priceIsInRange1(Person person) {
	    boolean isInRange = false;

	    if (person != null  
	    		&& person.getPrice() != null 
	    		&& (person.getPrice() >= 10 && person.getPrice() <= 15)) {

	        isInRange = true;
	    }
	    return isInRange;
	}
	
	public boolean priceIsInRange2(Person person) {
	     return Optional.ofNullable(person)
	       .map(Person::getPrice)
	       .filter(p -> p >= 10)
	       .filter(p -> p <= 15)
	       .isPresent();
	 }

}
