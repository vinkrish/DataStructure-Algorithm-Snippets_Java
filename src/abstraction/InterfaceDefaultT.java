package abstraction;

public class InterfaceDefaultT {

	public static void main(String[] args) {
		DrawableD d = new RectangleD();
		d.draw();
		d.msg();
	}

}

interface DrawableD {
	void draw();

	default void msg() {
		System.out.println("default method");
	}
}

class RectangleD implements DrawableD {
	public void draw() {
		System.out.println("drawing rectangle");
	}
}