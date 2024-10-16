package list;

class LinkedList<T> {

 // Node class representing each element in the LinkedList
 private static class Node<T> {
     T data;
     Node<T> next;
     Node<T> prev;

     Node(T data) {
         this.data = data;
         this.next = null;
         this.prev = null;
     }
     
     Node(Node<T> prev, T element, Node<T> next) {
         this.data = element;
         this.next = next;
         this.prev = prev;
     }
 }

 private Node<T> head;
 private Node<T> tail;

 public LinkedList() {
     this.head = null;
     this.tail = null;
 }

 // Method to add an element at the end of the LinkedList
 public void add(T data) {
     Node<T> newNode = new Node<>(data);

     if (head == null) {
         head = newNode;
         tail = newNode;
     } else {
    	 tail.next = newNode;
    	 newNode.prev = tail;
    	 tail = newNode;
     }
 }

 public boolean remove(T data) {
     if (head == null) {
         return false; // List is empty
     }

     if (head.data.equals(data)) {
         head = head.next; // Remove head
         if (head != null) {
             head.prev = null; // Update the new head's prev pointer
         } else {
             tail = null; // The list is now empty
         }
         return true;
     }

     Node<T> current = head;
     // Traverse to find the node to remove
     while (current != null && !current.data.equals(data)) {
         current = current.next;
     }

     if (current.next == null) {
         return false; // Element not found
     }

     // Unlink the node to remove it
     if (current.next != null) {
         current.next.prev = current.prev;
     } else {
         // If we're removing the tail
         tail = current.prev;
     }
     
     if (current.prev != null) {
         current.prev.next = current.next;
     }
     
     return true;
 }

 // Method to print all the elements in the LinkedList
 public void printList() {
     Node<T> current = head;

     while (current != null) {
         System.out.print(current.data + " -> ");
         current = current.next;
     }

     System.out.println("null");
 }

 // Method to get the size of the LinkedList
 public int size() {
     int count = 0;
     Node<T> current = head;

     while (current != null) {
         count++;
         current = current.next;
     }

     return count;
 }

 // Method to check if the list contains a specific element
 public boolean contains(T data) {
     Node<T> current = head;

     while (current != null) {
         if (current.data.equals(data)) {
             return true;
         }
         current = current.next;
     }

     return false;
 }

 // Method to get an element at a specific index
 public T get(int index) {
     if (index < 0 || head == null) {
         throw new IndexOutOfBoundsException("Invalid index");
     }

     Node<T> current = head;
     int count = 0;

     while (current != null) {
         if (count == index) {
             return current.data;
         }
         count++;
         current = current.next;
     }

     throw new IndexOutOfBoundsException("Index out of bounds");
 }
}

public class CustomLinkedList {
 public static void main(String[] args) {
     LinkedList<Integer> list = new LinkedList<>();

     list.add(1);
     list.add(2);
     list.add(3);
     list.add(4);

     list.printList();  // Output: 1 -> 2 -> 3 -> 4 -> null

     System.out.println(list.contains(3));  // Output: true
     System.out.println(list.contains(5));  // Output: false

     System.out.println(list.size());  // Output: 4

     list.remove(3);
     list.printList();  // Output: 1 -> 2 -> 4 -> null

     System.out.println(list.get(1));  // Output: 2
 }
}
