package reflection;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

/*
 * Unchecked casts are required because the methods in the Java reflection library cannot return sufficiently accurate types, for various reasons.
 * 
 * In each of the following case the unchecked cast is safe, 
 * and users can call on the four library routines defined here without violating the cast-iron guarantee.
 */
public class GenericReflection {
	
	/*
	 * finds the class of that object, and returns a new instance of the class.
	 * 
	 * The method getClass, when called on a receiver of type T, 
	 * returns a token not of type Class<? extends T> but of type Class<?>, 
	 * because of the erasure that is required to ensure that class tokens always have a reifiable type.
	 */
	public static <T> T newInstance(T obj) 
			throws InstantiationException, 
					IllegalAccessException, 
					InvocationTargetException, 
					NoSuchMethodException {
		Object newobj = obj.getClass().getConstructor().newInstance();
		return (T)newobj; // unchecked cast
	}
	
	/*
	 * returns a class token for its component type.
	 * 
	 * The method getComponentType is in the class Class<T>, 
	 * and Java provides no way to restrict the receiver type to be Class<T[]> in the signature of the method 
	 * (though the call raises an exception if the receiver is not a class token for an array type).
	 */
	public static <T> Class<? extends T> getComponentType(T[] a) {
		Class<?> k = a.getClass().getComponentType();
		return (Class<? extends T>)k; // unchecked cast
	}
	
	/*
	 * allocates a new array with its component type specified by a given class token and a specified size.
	 * 
	 * The method newInstance in java.lang.reflect.Array must have the return type Object rather than the return type T[], 
	 * because it may return an array of a primitive type.
	 */
	public static <T> T[] newArray(Class<? extends T> k, int size) {
		if (k.isPrimitive())  throw new IllegalArgumentException
			("Argument cannot be primitive: "+k);
		Object a = Array.newInstance(k, size);
		return (T[])a; // unchecked cast
	}
	
	/*
	 * allocates a new array with the same component type as the given array and the given size; 
	 * it simply composes calls to the previous two methods.
	 */
	public static <T> T[] newArray(T[] a, int size) {
		return newArray(getComponentType(a), size);
	}
	
	public static void main(String... args) {
		Integer[] ints = newArray(Integer.class, 9);
		String[] strs = newArray(String.class, 9);
		
		System.out.println(ints.length);
		System.out.println(strs.length);
		
		/* int[] ints = newArray(int.class, 9);
		 * 
		 * if the first argument is, say, int.class then its type is Class<Integer>, 
		 * but the new array will have type int[], which is not a subtype of Integer[].
		 */
	}
	
	public static <T, C extends Collection<T>> C copy(C coll) throws InstantiationException, 
																	IllegalAccessException, 
																	InvocationTargetException, 
																	NoSuchMethodException {
		C copy = GenericReflection.newInstance(coll);
		copy.addAll(coll); 
		return copy;
	}
	
	/* 
	 * rewritten [toArray() in reification.ArrayList] to replace its unchecked casts by a call to the generic reflection library.
	 */
	public static <T> T[] toArray(Collection<T> c, T[] a) {
		if (a.length < c.size())
			a = GenericReflection.newArray(a, c.size());
		int i=0; 
		for (T x : c) a[i++] = x;
		if (i < a.length) a[i] = null;
		return a;
	}
	
}
