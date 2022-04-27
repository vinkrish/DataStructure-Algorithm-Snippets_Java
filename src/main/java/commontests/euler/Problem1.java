package commontests.euler;

/*
 * https://projecteuler.net/problem=1
 * https://www.xarg.org/puzzle/project-euler/problem-1/
 */
public class Problem1 {

	public static void main(String[] args) {
		int first = 3;
		int second = 5;
		
		// LCM of 3 and 5 = 15
		int LCM = 15;
		
        double r = Math.floor(999/first);
        double s = Math.floor(999/second);
        double t = Math.floor(999/(first * second));

        double sum = 0.5 * ((first * r * (r+1)) + (second * s * (s+1)) - (LCM * t * (t+1)));
        
        System.out.println(sum);

	}

}
