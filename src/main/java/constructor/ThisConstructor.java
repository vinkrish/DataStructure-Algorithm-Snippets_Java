package constructor;

public class ThisConstructor {
	int m_x, m_y;
	   
	public ThisConstructor(int x, int y) { m_x = x; m_y = y; }
	public ThisConstructor() { this(10, 10); }
	public int getX() { return m_x; }
	public int getY() { return m_y; }
   
	public static void main(String args[]) {
		ThisConstructor p = new ThisConstructor();
		System.out.println(p.getX());
	}
}
