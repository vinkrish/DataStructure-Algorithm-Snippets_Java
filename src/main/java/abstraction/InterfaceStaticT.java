package abstraction;

public class InterfaceStaticT {

	public static void main(String[] args) {
		DrawableS d = new RectangleS();  
		d.draw();  
		System.out.println(DrawableS.cube(3));  
	}

}

interface DrawableS {
	void draw();

	static int cube(int x) {
		return x * x * x;
	}
}

class RectangleS implements DrawableS {
	public void draw() {
		System.out.println("drawing rectangle");
	}
}
