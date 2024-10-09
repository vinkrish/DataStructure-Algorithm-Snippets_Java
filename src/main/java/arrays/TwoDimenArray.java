package arrays;

import java.util.Arrays;

public class TwoDimenArray {
	public static void main(String args[]) {
        int arr[][] = new int[4][];
        arr[0] = new int[1];
        arr[1] = new int[2];
        arr[2] = new int[3];
        arr[3] = new int[4];
  
        int i, j, k = 0;
        for (i = 0; i < 4; i++) {
            for (j = 0; j < i + 1; j++) {
                arr[i][j] = k;
                k++;
            }
        }
        for (i = 0; i < 4; i++) {
            for (j = 0; j < i + 1; j++) {
                System.out.print(" " + arr[i][j]);
                k++;
            }
            System.out.println();
        }
        // another way to print 2-dimensional array
        System.out.println(Arrays.deepToString(arr));
        
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int rows = directions.length;
        int cols = directions[0].length;
        System.out.println(rows);
        System.out.println(cols);
        for (int[] d : directions) {
        	for(Integer ints: d) {
        		System.out.println(ints);
        	}
        }
    }
}
