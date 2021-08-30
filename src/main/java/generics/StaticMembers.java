package generics;

import java.util.ArrayList;
import java.util.List;

/*
 * static members of a generic class are shared across all instantiations of that class, 
 * including instantiations at different types. 
 * 
 * Static members of a class cannot refer to the type parameter of a generic class, 
 * and when accessing a static member the class name should not be parameterized.
 */
public class StaticMembers {

	public static void main(String[] args) {
		Cell<String> a = new Cell<String>("one");
		Cell<Integer> b = new Cell<Integer>(2);
		Cell.getCount();
		
		Cell2<String> c = new Cell2<String>("three");
		Cell2<Integer> d = new Cell2<Integer>(4);
		Cell2.getValues();
	}

}

class Cell<T> {
	private final int id;
	private final T value;
	private static int count = 0;
	private static synchronized int nextId() { return count++; }
	public Cell(T value) { this.value=value; id=nextId(); }
	public T getValue() { return value; }
	public int getId() { return id; }
	public static synchronized int getCount() { return count; }
}

class Cell2<T> {
	private final T value;
	private static List<Object> values = new ArrayList<Object>(); // ok
	public Cell2(T value) { this.value=value; values.add(value); }
	public T getValue() { return value; }
	public static List<Object> getValues() { return values; } // ok
}
