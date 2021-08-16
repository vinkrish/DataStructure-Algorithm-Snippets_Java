package classes;

public class ConstructorThis {
	
	private int x, y;
    private int width, height;
        
    public ConstructorThis() {
        this(0, 0, 1, 1);
    }
    
    public ConstructorThis(int width, int height) {
        this(0, 0, width, height);
    }
    
    public ConstructorThis(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

}
