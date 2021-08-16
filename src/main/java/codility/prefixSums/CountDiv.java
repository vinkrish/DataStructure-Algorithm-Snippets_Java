package codility.prefixSums;

public class CountDiv {

	public static void main(String[] args) {
		System.out.println(solution(10,10,5));
	}
	
	public static int solution(int A, int B, int K) {
		if (A == 0 && B == 0) return 1;
		
		int a = A / K;
		int b = B / K;
		
		int l = 0;
		if (A == 0 && b != 0) l = b - a + 1;
		else if (a == 0 && b != 0) l = b - a;
		else l = b - a + 1;
		
		if (a == 0 && b == 0) return 0;
        return l;
    }
	
	public static int solution2(int A, int B, int K) {
		int lowestMultipleOfK;
	      if ( A % K == 0 ) {
	        lowestMultipleOfK = A;
	      } else {
	        lowestMultipleOfK = A + ( K - ( A % K ) );
	      }
	
	      if ( lowestMultipleOfK <= B ) {
	        return 1 + ( B - lowestMultipleOfK ) / K;
	      } else {
	        return 0;
	      }
	}
}

/*
Write a function: that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

{ i : A ≤ i ≤ B, i mod K = 0 }

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

Write an efficient algorithm for the following assumptions:
- A and B are integers within the range [0..2,000,000,000];
- K is an integer within the range [1..2,000,000,000];
- A ≤ B.
*/