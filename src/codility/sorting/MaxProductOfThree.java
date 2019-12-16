package codility.sorting;

import java.util.Arrays;

public class MaxProductOfThree {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {-3,1,2,-2,5,6}));
	}
	
	public static int solution(int[] A) {
		Arrays.parallelSort(A);
		
		int sum = 0;
		int negativeSum = 0;
		int positiveSum = 0;
		
		if (A[0] < 0 && A[1] < 0) {
			negativeSum = A[0] * A[1] * A[A.length-1];
		}
		
		positiveSum = A[A.length-3] * A[A.length-2] * A[A.length-1];
		
		if (negativeSum > positiveSum) sum = negativeSum;
		else sum = positiveSum;
		
        return sum;
    }
	
	/*
	 * 
	 * public static int solution(int[] A) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for (int i=0; i<A.length; i++) {
			map.put(i, A[i]);
		}
		
		TreeMap<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
		    sortedMap.put((Integer) entry.getValue(), (Integer)entry.getKey());
		}
		System.out.println(sortedMap.toString());
        return 0;
    }
	 * 
	 */

}
/*
A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

For example, array A such that:
  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
  
contains the following example triplets:
- (0, 1, 2), product is −3 * 1 * 2 = −6
- (1, 2, 4), product is 1 * 2 * 5 = 10
- (2, 4, 5), product is 2 * 5 * 6 = 60

Your goal is to find the maximal product of any triplet.

Write a function: that, given a non-empty array A, returns the value of the maximal product of any triplet.

For example, given array A such that:
  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
the function should return 60, as the product of triplet (2, 4, 5) is maximal.

Write an efficient algorithm for the following assumptions:
- N is an integer within the range [3..100,000];
- each element of array A is an integer within the range [−1,000..1,000].
*/