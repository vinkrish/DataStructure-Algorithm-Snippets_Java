package stack;

class Node {
    int data;
    int minData;
    Node next;
}

public class MinStack {
    private Node top;
 
    public MinStack() {
        this.top = null;
    }
 
    // Utility function to add an element `x` to the stack
    public void push(int x) {
    	
        // allocate a new node in a heap
        Node node = new Node();
 
        System.out.println("Inserting " + x);
 
        // set data in the allocated node
        node.data = x;
        
        // update minData if new data being pushed is smaller than existing smallest data
    	if(top != null) {
    		if (x < this.top.minData) node.minData = x;
    		else node.minData = this.top.minData;
    	} else node.minData = x;
 
        // set the `.next` pointer of the new node to point to the current
        // top node of the list
        node.next = top;
 
        // update top pointer
        top = node;
    }
 
    // Utility function to check if the stack is empty or not
    public boolean isEmpty() {
        return top == null;
    }
 
    // Utility function to return the top element of the stack
    public int peek() {
        // check for an empty stack
        if (!isEmpty()) {
            return top.data;
        } else {
            System.out.println("The stack is empty");
            return -1;
        }
    }
 
    // Utility function to pop a top element from the stack
    public void pop() {
        // check for stack underflow
        if (top == null) {
            System.out.print("\nStack Underflow");
            return;
        }
 
        System.out.println("Removing " + peek());
 
        // update the top pointer to point to the next node
        top = top.next;
    }
    
    // Utility function to get minimum element in the stack
    public int getMin() {
    	return top.minData;
    }
    
    public static void main(String[] args) {
        MinStack stack = new MinStack();
 
        stack.push(3);
        stack.push(-2);
        stack.push(1);
        stack.push(-3);
        stack.push(2);
 
        System.out.println("The top element is " + stack.peek());
        System.out.println("Min Element is " + stack.getMin());
 
        stack.pop();
        stack.pop();
        stack.pop();
        
        System.out.println("Min Element is " + stack.getMin());
        
        stack.pop();
        stack.pop();
 
        if (stack.isEmpty()) {
            System.out.print("The stack is empty");
        } else {
            System.out.print("The stack is not empty");
        }
    }
}