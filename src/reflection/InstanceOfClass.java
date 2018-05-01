package reflection;

public class InstanceOfClass {

	public static void main(String[] args) throws Exception {
		Class c = Class.forName("reflection.PrivateMethod");
		System.out.println(c.getName());

		PrivateMethod p = new PrivateMethod();
		InstanceOfClass i = new InstanceOfClass();
		i.printName(p);

		Class clas = boolean.class;
		System.out.println(clas.getName());

		Class classs = InstanceOfClass.class;
		System.out.println(classs.getName());
	}

	void printName(Object obj) {
		Class c = obj.getClass();
		System.out.println(c.getName());
	}

}
