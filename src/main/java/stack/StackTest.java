package stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(42);
		st.push(66);
		st.push(99);
		System.out.println("stack: " + st);
		st.pop();
		st.pop();
		System.out.println(st.peek());
		st.pop();
		try {
			st.pop();
		} catch (EmptyStackException e) {
			System.out.println("empty stack");
		}
	}

}
