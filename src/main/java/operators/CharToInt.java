package operators;

public class CharToInt {

	public static void main(String[] args) {
		String expression = "231*+9-";
		char c = expression.charAt(0);
		int i = c - '0';
		int j = (int) c;
		System.out.println("This works coz char are basically short: " + i);
		System.out.println("Casting doesn't work: " + j);
	}

}
