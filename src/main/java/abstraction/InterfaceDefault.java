package abstraction;

public class InterfaceDefault implements DrawableDefault {
	
	public void draw() {
		System.out.println("drawing rectangle");
	}

}

interface DrawableDefault {
	void draw();

	default void msg() {
		System.out.println("default method");
	}
}