package designpattern.creational.singleton;

/*
 * Make global access method synchronized, so that only one thread can execute at any given time.
 * It reduces the performance because of the cost associated with the synchronized method.
 */
public class ThreadSafeSingleton {

	private static ThreadSafeSingleton instance;
	
	private ThreadSafeSingleton() {}
	
	public static synchronized ThreadSafeSingleton getInstance() {
		if(instance == null) {
			instance = new ThreadSafeSingleton();
		}
		return instance;
	}
	
	/*
	 * We only need to worry for the first few threads who might create the separate instances.
	 * To avoid this extra overhead every time, double checked locking principle is used.
	 * 
	 * In this principle, the synchronized block is used inside the if condition with an additional check to ensure that 
	 * only one instance of a singleton is created.
	 */
	public static ThreadSafeSingleton getInstanceUsingDoubleLocking() {
		if(instance == null) {
			synchronized(ThreadSafeSingleton.class) {
				if(instance == null) {
					instance = new ThreadSafeSingleton();
				}
			}
		}
		return instance;
	}
}
