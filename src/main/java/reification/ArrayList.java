package reification;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.RandomAccess;

/*
 * It is essential that the field containing the array is private; 
 * otherwise, it would violate both the Principle of Truth in Advertising and the Principle of Indecent Exposure. 
 * It would violate the Principle of Truth in Advertising because E might be bound to a type (such as String) other than Object. 
 * It would violate the Principle of Indecent Exposure because E might be bound to a type (such as List<Integer>) that is not a reifiable type. 
 * However, neither of these principles is violated because the array is not public: 
 * it is stored in a private field, and no pointer to the array escapes from the class.
 * We might call this the Principle of Anything Goes Behind Closed Doors.
 */
public class ArrayList<E> extends AbstractList<E> implements RandomAccess {
	private E[] arr;
	private int size = 0;
	
	/* Why can't you create generic array type?
	 * 
	 * Java's arrays (unlike generics) contain, at runtime, information about its component type. 
	 * So you must know the component type when you create the array.
	 */
	public ArrayList(int cap) {
		if (cap < 0)
			throw new IllegalArgumentException("Illegal Capacity: "+cap);
		arr = (E[])new Object[cap]; // unchecked cast
	}
	
	public ArrayList() { this(10); }
	
	public ArrayList(Collection<? extends E> c) { this(c.size()); addAll(c); }
	
	public void ensureCapacity(int mincap) {
		int oldcap = arr.length;
		if (mincap > oldcap) {
			int newcap = Math.max(mincap, (oldcap*3)/2+1);
			E[] oldarr = arr;
			arr = (E[])new Object[newcap]; // unchecked cast
			System.arraycopy(oldarr,0,arr,0,size);
		}
	}
	
	public int size() { return size; }
	
	private void checkBounds(int i, int size) {
		if (i < 0 || i >= size)
			throw new IndexOutOfBoundsException("Index: "+i+", Size: "+size);
	}
	
	public E get(int i) { 
		checkBounds(i,size); 
		return arr[i];
	}
	
	public E set(int i, E elt) {
		checkBounds(i,size);
		E old = arr[i]; 
		arr[i] = elt; 
		return old;
	}
	
	public void add(int i, E elt) {
		checkBounds(i,size+1);
		ensureCapacity(size+1);
		System.arraycopy(arr,i,arr,i+1,size-i); arr[i] = elt; size++;
	}
	
	public E remove(int i) {
		checkBounds(i,size); 
		E old = arr[i]; 
		arr[i] = null; 
		size--;
		System.arraycopy(arr,i+1,arr,i,size-i); return old;
	}
	
	public <T> T[] toArray(T[] a) {
		if (a.length < size)
			a = (T[])Array.newInstance(a.getClass().getComponentType(), size); // unchecked cast
		System.arraycopy(arr,0,a,0,size);
		if (size < a.length) a[size] = null;
		return a;
	}
	
	public Object[] toArray() { 
		return toArray(new Object[0]); 
	}

}

/*
 * It would have been better to declare the private array to have type Object[] 
 * and use casts to type (E) when retrieving elements from the array.
 * 
 * There is also something to be said for the style we have used here, which minimizes the need for unchecked casts
 */
