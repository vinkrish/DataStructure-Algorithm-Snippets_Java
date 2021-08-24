package abstraction;

public class AbstractImpl extends Bike {
	public void run() {
		System.out.println("running safely");
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
