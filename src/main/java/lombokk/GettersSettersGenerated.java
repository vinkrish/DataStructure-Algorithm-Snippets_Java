package lombokk;

public class GettersSettersGenerated {
	private int age = 10;

	private String name;

	public int getAge() {
		return this.age;
	}

	public void setAge(int paramInt) {
		this.age = paramInt;
	}

	protected void setName(String paramString) {
		this.name = paramString;
	}

	public String toString() {
		return String.format("%s (age: %d)", new Object[] { this.name, Integer.valueOf(this.age) });
	}
}