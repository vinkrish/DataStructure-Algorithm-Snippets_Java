package dynamicprog;

import java.util.Stack;

public class Parenthesis {

	public static void main(String[] args) {
		//String exp = "((x+y))";
		//String exp = "((a+b)+((c+d)))";
		//String exp = "(((a+(b)))+(c+d))";
		//String exp = "(((a+(b))+c+d))";
		
		//String exp = "((a+b)+(c+d))";
		String exp = "((a+(b))+(c+d))";
		
		if(checkParenthesis(exp)) {
			System.out.println("The expression has duplicate parenthesis");
		} else {
			System.out.println("The expression doesn't have duplicate parenthesis");
		}
	}
	
	public static boolean checkParenthesis(String exp) {
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < exp.length(); i++) {
			if(exp.charAt(i) != ')') {
				stack.push(exp.charAt(i));
			} else {
				if(stack.peek() == '(') {
					return true;
				}
				while(stack.peek() != '(') {
					stack.pop();
				}
				stack.pop();
			}
		}
		
		return false;
	}

}
