package designpattern.creational.singleton;

import java.lang.reflect.Constructor;

/*
 * You will notice that hashCode of both the instances is not same, that destroys the singleton pattern.
 */
public class ReflectionSingletonTest {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();
		EagerInitializedSingleton instanceTwo = null;
		
		try {
			Constructor[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
			for(Constructor constructor: constructors) {
				// Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				instanceTwo = (EagerInitializedSingleton) constructor.newInstance();
				break;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
	}
}
