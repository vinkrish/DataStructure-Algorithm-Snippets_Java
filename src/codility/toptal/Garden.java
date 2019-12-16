package codility.toptal;

public class Garden {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {5,4,3,2,6}));
	}
	
	public static int solution(int[] A) {
		int incDecOrder = 0;
		int decIncOrder = 0;
		for (int i=0; i<A.length-1; i++) {
			if (A[i] - A[i+1] > 0) incDecOrder += 1;
		}
		return 0;
    }

}
