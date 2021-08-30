package generics;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class NestedClasses {
	
	public static void main(String[] args) {
		
	}

}

/* 
 * If the outer class has type parameters and the inner class is not static, 
 * then type parameters of the outer class are visible within the inner class.
 */

// Type parameters are in scope for nested, nonstatic classes
class LinkedCollectionNS<E> extends AbstractCollection<E> {
	
	private class Node {
		private E element;
		private Node next = null;
		private Node(E elt) { element = elt; }
	}
	
	private Node first = new Node(null);
	private Node last = first;
	private int size = 0;
	public LinkedCollectionNS() {}
	public LinkedCollectionNS(Collection<? extends E> c) { addAll(c); }
	
	public int size() { return size; }
	
	public boolean add(E elt) {
		last.next = new Node(elt); 
		last = last.next; 
		size++;
		return true;
	}
	// anonymous iterator class
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private Node current = first;
			
			public boolean hasNext() {
				return current.next != null;
			}
			
			public E next() {
				if (current.next != null) {
					current = current.next;
					return current.element;
				} else throw new NoSuchElementException();
			}
			
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
}

// Type parameters are not in scope for nested, static classes
class LinkedCollection<E> extends AbstractCollection<E> {
	
	private static class Node<T> {
		private T element;
		private Node<T> next = null;
		private Node(T elt) { element = elt; }
	}
	
	private Node<E> first = new Node<E>(null);
	private Node<E> last = first;
	private int size = 0;
	public LinkedCollection() {}
	public LinkedCollection(Collection<? extends E> c) { addAll(c); }
	
	public int size() { return size; }
	
	public boolean add(E elt) {
		last.next = new Node<E>(elt); 
		last = last.next; 
		size++;
		return true;
	}
	
	private static class LinkedIterator<T> implements Iterator<T> {
		private Node<T> current;
		public LinkedIterator(Node<T> first) { current = first; }
		
		public boolean hasNext() {
			return current.next != null;
		}
		
		public T next() {
			if (current.next != null) {
				current = current.next;
				return current.element;
			} else throw new NoSuchElementException();
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	public Iterator<E> iterator() {
		return new LinkedIterator<E>(first);
	}
}


/*
 * If the node classes had been made public rather than private, 
 * you would refer to the node class in the first example as LinkedCollection<E>.Node,
 *  whereas you would refer to the node class in the second example as LinkedCollection.Node<E>.
 */