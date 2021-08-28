package generics;

public class GenericClass {
	
	public static void main(String[] args) {
		/**
		 * create an instance of Box<Integer>
		 */

		Box<Integer> integerBox = new Box<>();
		integerBox.set(1);
		System.out.println(integerBox.get());

		
		/**
		 * raw type
		 */

		Box rawBox = new Box();
		rawBox.set(2);
		System.out.println(rawBox.get());

	}
	
}

/**
 * Generic version of the Box class.
 * @param <T> the type of the value being boxed
 */
class Box<T> {
    // T stands for "Type"
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }
}
