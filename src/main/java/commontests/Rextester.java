package commontests;

import java.util.Scanner;

/*
 * You are the owner of a coworking space like WeWork and your office building is rectangular. 
 * Your team just built wall partitions to create mini offices for startups. 
 * This office campus is represented by a 2D array of 1s (floor spaces) and 0s (walls). 
 * Each point on this array is a one foot by one foot square. 
 * You need to calculate the number of offices. 
 * A single office is bordered by walls and is constructed by placing floors next to each other, horizontally and/or vertically. 
 * Two 1s adjacent to each other horizontally or vertically are always part of the same office.
 */

public class Rextester {
	
	public static String[][] getMatrix() {
        Scanner sc = new Scanner(System.in);
        int rowsLen = sc.nextInt();
        int colsLen = sc.nextInt();
        String matrix[][] = new String[rowsLen][colsLen];
        int i;
        for(i=0;i<rowsLen;i++){
            String line = sc.next();
            for(int j=0;j<line.length();j++) {
               matrix[i][j] = String.valueOf(line.charAt(j));  
            }
        }
        return matrix;
    }
    
    public static void main(String args[])
    {
        int result = Solution.numOffices(getMatrix()); 
        System.out.println(result);
    }

}

class Solution
{
    public static int numOffices(String[][] grid) {
        int result = 1;
        //Put your code here.

        return result;
    }
}

/*
Input 1:

4
5
11000
11000
00100
00011

Input 2:

4
5
11111
10001
10000
11101 
*/