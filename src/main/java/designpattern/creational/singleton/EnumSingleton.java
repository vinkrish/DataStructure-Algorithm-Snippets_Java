package designpattern.creational.singleton;

/*
 * To overcome problem with reflection, 
 * Joshua Bloch suggests to use enum as java ensures any enum value is instantiated only once in a Java program.
 * 
 * drawback is that enum type is inflexible (doesn't allow lazy initialization)
 */
public enum EnumSingleton {
	
	INSTANCE;
	
	public static void doSomething() {
		// do something
	}

}
