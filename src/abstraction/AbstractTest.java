package abstraction;

public class AbstractTest {

	public static void main(String[] args) {
		Bike obj = new Honda();
		obj.run();
		obj.changeGear();
	}

}

abstract class Bike {
	Bike() {
		System.out.println("bike is created");
	}

	protected abstract void run();

	void changeGear() {
		System.out.println("gear changed");
	}
}

class Honda extends Bike {
	
	public void run() {
		System.out.println("running safely..");
	}
}
