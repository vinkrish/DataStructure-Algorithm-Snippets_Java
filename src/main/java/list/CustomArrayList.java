package list;

import java.util.Arrays;

class ArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10; 
    private Object[] elements;  // Internal array to store the elements
    private int size = 0;       // Number of elements in the list

    public ArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elements = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elements = new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public void add(T data) {
        ensureCapacity();  // Ensure there's enough space before adding
        elements[size++] = data;  // Add the new element and increment size
    }

    public boolean remove(T data) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(data)) {
                removeAt(i);
                return true;
            }
        }
        return false; // Element not found
    }

    private void removeAt(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1]; // Shift elements to the left
        }
        elements[--size] = null;  // Nullify the last element and decrement size
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) elements[index];  // Return the element
    }

    public boolean contains(T data) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    // Helper method to ensure enough capacity before adding new elements
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;  // Double the capacity
            elements = Arrays.copyOf(elements, newCapacity);  // Resize array
        }
    }

    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i] + " -> ");
        }
        System.out.println("null");
    }
}

public class CustomArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);

        arrayList.printList();  // Output: 10 -> 20 -> 30 -> 40 -> null

        System.out.println(arrayList.contains(20));  // Output: true
        System.out.println(arrayList.contains(50));  // Output: false

        System.out.println(arrayList.size());  // Output: 4

        arrayList.remove(30);
        arrayList.printList();  // Output: 10 -> 20 -> 40 -> null

        System.out.println(arrayList.get(1));  // Output: 20

        System.out.println(arrayList.size());  // Output: 3
    }
}
