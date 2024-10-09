package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackDeque {

	public static void main(String[] args) {
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(1);
		stack.push(2);
		
		System.out.println(stack.pop()); // Outputs 2
		
		stack.push(3);
		
		System.out.println(stack.peek());
		System.out.println("The final array is: " + stack);
	}

}
