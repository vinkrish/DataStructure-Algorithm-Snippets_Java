package generics;

public class BoundedTypeParameters<T> {
	
	private T t;          

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public <U extends Number> void inspect(U u){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

	public static void main(String[] args) {
		BoundedTypeParameters<Integer> integerBox = new BoundedTypeParameters<Integer>();
        integerBox.set(Integer.valueOf(10));
        
        integerBox.inspect(Integer.valueOf(10));
        
        // integerBox.inspect("some text"); // error: this is still String!
	}
	
	// Use a type parameter bounded by the Comparable<T> interface
	public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
	    int count = 0;
	    for (T e : anArray)
	        if (e.compareTo(elem) > 0)
	            ++count;
	    return count;
	}

}
