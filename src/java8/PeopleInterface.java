package java8;

public interface PeopleInterface {
	String getName();
	void setName(String name);
	int getAge();
	void setAge(int age);
	
	default String getPersonInfo() {
		return getName() + "(" + getAge() + ")";
	}
	
	static String getStaticPersonInfo(People p) {
		return p.getName() + "(" + p.getAge() + ")";
	}
}
