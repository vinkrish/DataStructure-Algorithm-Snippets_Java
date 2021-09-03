package reflection;

import java.lang.reflect.*;

/*
 * reflection for generics: where Java adds methods and classes that support access to generic types.
 * 
 * Although the reified type information for objects and class tokens contains no information about generic types, 
 * the actual bytecode of the class does encode information about generic types as well as erased types.
 * 
 * The information about generic types is essentially a comment. 
 * It is ignored when running the code, and it is preserved only for use in reflection.
 * 
 * Unfortunately, there is no toGenericString method for the class Class, even though this would be useful.
 */
public class ReflectionForGenerics {
	
	public static void toString(Class<?> k) {
		System.out.println(k + " (toString)");
		
		for (Field f : k.getDeclaredFields())
			System.out.println(f.toString());
		
		for (Constructor c : k.getDeclaredConstructors())
			System.out.println(c.toString());
		
		for (Method m : k.getDeclaredMethods())
			System.out.println(m.toString());
		
		System.out.println();
	}
	public static void toGenericString(Class<?> k) {
		System.out.println(k + " (toGenericString)");
		
		for (Field f : k.getDeclaredFields())
			System.out.println(f.toGenericString());
		
		for (Constructor c : k.getDeclaredConstructors())
			System.out.println(c.toGenericString());
		
		for (Method m : k.getDeclaredMethods())
			System.out.println(m.toGenericString());
		
		System.out.println();
	}
	public static void main (String[] args) throws ClassNotFoundException {
		/*
		for (String name : args) {
			Class<?> k = Class.forName(name);
			toString(k);
			toGenericString(k);
		}
		
		java ReflectionForGenerics Cell
		*/
		Class<?> k = Cell.class;
		toString(k);
		toGenericString(k);
	}
}
