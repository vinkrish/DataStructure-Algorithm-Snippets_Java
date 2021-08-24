package abstraction;

public class InterfaceInheritance implements Showable {

	@Override
	public void print() {
		System.out.println("Hello");
	}

	@Override
	public void show() {
		System.out.println("Welcome");
	}

}

interface Printable {
	void print();
}

interface Showable extends Printable {
	void show();
}
