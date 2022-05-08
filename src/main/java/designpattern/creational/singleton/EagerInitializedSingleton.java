package designpattern.creational.singleton;

/*
 * If your singleton class is not using a lot of resources, use this pattern.
 * Creates instance even before it's being used and that is not the best practice.
 */
public class EagerInitializedSingleton {
	
	private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
	
	// private constructor to avoid client applications use constructor
	private EagerInitializedSingleton() {}
	
	public static EagerInitializedSingleton getInstance() {
		return instance;
	}

}
