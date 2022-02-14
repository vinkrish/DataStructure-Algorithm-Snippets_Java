package reification;

import java.util.*;

/*
 * Instance tests and casts depend on examining types at run time, and hence depend on reification. 
 * For this reason, an instance test against a type that is not reifiable reports an error, 
 * and a cast to a type that is not reifiable usually issues a warning.
 */
public class AbstractList<E> extends AbstractCollection<E> implements List<E> {
	
	public boolean equals(Object o) {
//		if (o instanceof List<E>) { // compile-time error
		if (o instanceof List<?>) {
			Iterator<E> it1 = iterator();
//			Iterator<E> it2 = ((List<E>)o).iterator(); // unchecked cast
			Iterator<?> it2 = ((List<?>)o).iterator();
			while (it1.hasNext() && it2.hasNext()) {
				E e1 = it1.next();
//				E e2 = it2.next();
				Object e2 = it2.next();
				if (!(e1 == null ? e2 == null : e1.equals(e2)))
				return false;
			}
			return !it1.hasNext() && !it2.hasNext();
		} else return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return false;
	}

	@Override
	public E get(int index) {
		return null;
	}

	@Override
	public E set(int index, E element) {
		return null;
	}

	@Override
	public void add(int index, E element) {
		
	}

	@Override
	public E remove(int index) {
		return null;
	}

	@Override
	public int indexOf(Object o) {
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

}
