package designpattern.creational.singleton;

/*
 * Creates the instance in the global access method.
 * Causes issues in multi-threaded system if multiple threads are inside the if condition at the same time.
 */
public class LazyInitializedSingleton {
	
	private static LazyInitializedSingleton instance;
	
	private LazyInitializedSingleton() {}
	
	public static LazyInitializedSingleton getInstance() {
		if(instance == null) {
			instance = new LazyInitializedSingleton();
		}
		return instance;
	}

}
