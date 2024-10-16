package queue;

import java.util.*;

/*
 * https://www.geeksforgeeks.org/arraydeque-in-java/
 */
public class ArrayDequeTest {

	public static void main(String[] args) {

        Deque<Integer> de_que = new ArrayDeque<Integer>(10);
 
        // Operations 1 - add() method
        de_que.add(10);
        de_que.add(20);
        de_que.add(30);
 
        // Iterating using for each loop
        for (Integer element : de_que) {
            System.out.println("Element : " + element);
        }
 
        // Operation 2 - clear() method
        de_que.clear();
        
        System.out.println("Using clear() - Above elements are removed now");
 
        // Operations 3 - addFirst() method
        // Inserting at the start
        de_que.addFirst(1);
        de_que.addFirst(2);
        de_que.offerFirst(3);
 
        // Operation 4 - addLast() method
        // Inserting at end
        de_que.addLast(7);
        de_que.addLast(8);
        de_que.offerLast(9);
 
        // Iterators
        System.out.println("Elements of deque using Iterator :");
 
        for (Iterator itr = de_que.iterator(); itr.hasNext();) {
            System.out.println(itr.next());
        }
 
        // To reverse the deque order
        System.out.println("Elements of deque in reverse order :");
 
        for (Iterator dItr = de_que.descendingIterator(); dItr.hasNext();) {
            System.out.println(dItr.next());
        }
 
        // Operation 5 - element() method : to get Head element
        System.out.println(
            "\nHead Element using element(): "
            + de_que.element());
 
        // Operation 6 - getFirst() method : to get Head element
        System.out.println("Head Element using getFirst(): " + de_que.getFirst());
 
        // Operation 7 - getLast() method : to get last element
        System.out.println("Last Element using getLast(): " + de_que.getLast());
 
        // Operation 8 - toArray() method :
        Object[] arr = de_que.toArray();
        System.out.println("\nArray Size : " + arr.length);
 
        System.out.print("Array elements : ");
 
        for (int i = 0; i < arr.length; i++)
            System.out.print(" " + arr[i]);
 
        // Operation 9 - peek() method : to get head
        System.out.println("\nHead element : " + de_que.peek());
        System.out.println("Peak First : " + de_que.peekFirst());
        System.out.println("Peak Last : " + de_que.peekLast());
 
        // Operation 10 - poll() method : to get head
        System.out.println("Head element poll : " + de_que.poll());
        System.out.println("Remove First : " + de_que.removeFirst());
        System.out.println("Remove Last : " + de_que.removeLast());
        System.out.println("Poll First : " + de_que.pollFirst()); // returns null if empty
        System.out.println("Poll Last : " + de_que.pollLast()); // returns null if empty
 
        // Operation 11 - push() method
        de_que.push(10);
        de_que.push(100);
        de_que.push(1000);
 
        // Operation 12 - remove() method : to get head
        System.out.println("Head element remove : " + de_que.remove());
 
        System.out.println("The final array is: " + de_que);
    }

}
