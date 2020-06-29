package java8;

public class People implements PeopleInterface {
	private String name;
    private int age;
    
    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public void setAge(int age) {
		this.age = age;
	}

}
