package designpattern.creational.singleton;

/*
 * Similar to eager initialization, 
 * except that instance of class is created in the static block that provides option for exception handling.
 * 
 * Creates instance even before it's being used and that is not the best practice.
 */
public class StaticBlockSingleton {
	
	private static StaticBlockSingleton instance;
	
	private StaticBlockSingleton() {}
	
	static {
		try {
			instance = new StaticBlockSingleton();
		} catch(Exception e) {
			throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}
	
	public static StaticBlockSingleton getInstance() {
		return instance;
	}

}
