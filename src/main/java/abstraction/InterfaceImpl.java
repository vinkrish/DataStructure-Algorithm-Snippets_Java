package abstraction;

public class InterfaceImpl {

	public void createObj() {
		Drawable d = new Circle(); 
		d.draw();
		
		DrawableDummy dd = new Rectangle();
		dd.draw();
		
		Rectangle r = new Rectangle();
		r.draw();
	}

}

interface Drawable {
	void draw();
}

interface DrawableDummy {
	void draw();
}

class Rectangle implements Drawable, DrawableDummy {
	public void draw() {
		System.out.println("drawing rectangle");
	}
}

class Circle implements Drawable {
	public void draw() {
		System.out.println("drawing circle");
	}
}
