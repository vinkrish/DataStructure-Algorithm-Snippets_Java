package codility.timeComplexity;

import java.util.HashMap;

public class PermMissingElem {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {2,3,1,5}));
	}
	
	static public int solution(int[] A) {
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
            hmap.put(A[i], 1);
        }
		
		for (int i = 1; i <= A.length + 1; i++) {
			if (hmap.get(i) == null) {
				return i;
			}
		}
		return 0;
    }
}

/*
An array A consisting of N different integers is given. 
The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function: that, given an array A, returns the value of the missing element.

For example, given array A such that:
  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Write an efficient algorithm for the following assumptions:
- N is an integer within the range [0..100,000];
- the elements of A are all distinct;
- each element of array A is an integer within the range [1..(N + 1)].
*/