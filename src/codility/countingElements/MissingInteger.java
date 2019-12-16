package codility.countingElements;

import java.util.Arrays;

public class MissingInteger {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {-1,1,-2,3,4,-10000}));
	}
	
	public static int removeDuplicateElements(int arr[], int n){  
        if (n==0 || n==1){  
            return n;  
        }  
        int[] temp = new int[n];  
        int j = 0;  
        for (int i=0; i<n-1; i++){  
            if (arr[i] != arr[i+1]){  
                temp[j++] = arr[i];  
            }  
         }  
        temp[j++] = arr[n-1];     
        // Changing original array  
        for (int i=0; i<j; i++){
            arr[i] = temp[i];  
        }  
        return j;  
    }
		
	static public int solution(int[] A) {
		int missingNumber = 0;
		Arrays.parallelSort(A);
		// removeDuplicateElements(A, A.length);
		System.out.println(Arrays.toString(A));
		if (A[0] > 1 || A[A.length-1] == -1 || (A.length == 1 && A[0] != 1)) {
			return 1;
		}
		// int[] arr = Arrays.stream(A).filter(s -> s >= 0).toArray();
		int previousNumber = A[0];
		for (int i=0; i<A.length; i++) {
			if (A[i] != previousNumber && A[i] == 1 && A[i] > previousNumber+1 && previousNumber < 0) {
				missingNumber = previousNumber+2;
				previousNumber = A[i];
			} else if (A[i] != previousNumber && A[i] > 1 && A[i] > previousNumber+1 && previousNumber < 0) {
				return 1;
			} else if (A[i] != previousNumber && A[i] > 0 && A[i] > previousNumber+1) {
				missingNumber = previousNumber+1;
				break;
			} else {
				previousNumber = A[i];
			}
		}		
		if (missingNumber < 1 && A[0] == 1 && A[A.length-1] == A.length) {
			missingNumber = A.length+1;
		}
		return missingNumber;
	}
}

/*
Write a function: that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:
- N is an integer within the range [1..100,000];
- each element of array A is an integer within the range [−1,000,000..1,000,000].
*/
