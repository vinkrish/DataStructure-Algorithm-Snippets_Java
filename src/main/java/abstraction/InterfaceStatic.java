package abstraction;

public class InterfaceStatic implements DrawableStatic {
	
	public void draw() {
		System.out.println("drawing rectangle");
	}

}

interface DrawableStatic {
	void draw();

	static int cube(int x) {
		return x * x * x;
	}
}
