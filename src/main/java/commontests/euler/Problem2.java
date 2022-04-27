package commontests.euler;

/*
 * https://projecteuler.net/problem=2
 * https://www.xarg.org/puzzle/project-euler/problem-2/
 */
public class Problem2 {
	static int MAX = 4000000;
	static int n1 = 1, n2 = 2, n3 = 0;
	static double sum = 2;

	public static void main(String[] args) {
		while (n1 <= MAX) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			if(n3 % 2 == 0) sum += n3;
		}
		System.out.println(sum);
	}

}
