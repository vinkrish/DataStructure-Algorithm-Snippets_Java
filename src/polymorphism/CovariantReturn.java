package polymorphism;

public class CovariantReturn extends A {
	CovariantReturn get() {
		return this;
	}

	void message() {
		System.out.println("welcome to covariant return type");
	}

	public static void main(String args[]) {
		new CovariantReturn().get().message();
	}
}

class A {
	A get() {
		return this;
	}
}
