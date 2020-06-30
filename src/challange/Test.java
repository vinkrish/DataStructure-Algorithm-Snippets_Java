package challange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {
	
	static List<Integer> testCaseList = new ArrayList<>();
	
	public static class Box {
		private int height;
		private int length;
		private int width;
	}

	public static void main(String[] args) {
		/*
		Scanner input = new Scanner(System.in);
		int testCaseCount = input.nextInt();
		input.nextLine();
		*/
		
		/*
		for(int i=0; i<testCaseCount; i++){
		    testCaseList.add(Integer.parseInt(input.nextLine().split(" ")[1]));
		}
		input.close();
		
		printCycleLength();
		*/
		
		/*
		String[] stringCaseList = input.nextLine().split(" ");
		Integer[] intArray = new Integer[stringCaseList.length];
        for (int i = 0; i < stringCaseList.length; i++) {
            intArray[i] = Integer.parseInt(stringCaseList[i]);
        }
		input.close();
		
		testCaseList = Arrays.asList(intArray);
		
		findAnswer();
		
		*/
		
		int x,y,z;
		x=9;
		y=10;
		z=++x+y++;
		
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		
		List<String> list1 = new ArrayList<>();
		list1.add("hi");
		
		List<String> list2 = list1;
		list2.add("hey");
		
		System.out.println(list1);
		list1.clear();
		System.out.println(list2);
		
		Box obj1 = new Box();
		Box obj2 = new Box();
		obj1.height = 1;
		
		obj2 = obj1;
		System.out.println(obj2.height);
		
	}
	
	private static void printCycleLength(){
	    for(Integer i: testCaseList){
	        int maxCycleLength = 0;
	        int localCyleLength = 0;
	        for(int k=1; k<=i; k++){
	        	localCyleLength = 0;
	        	for(int j=k; j>1; localCyleLength += 1){
		            if(j%2==0) j = j/2;
		            else j = 3*j + 1;
		        }
	        	localCyleLength += 1;
	        	if (localCyleLength > maxCycleLength) maxCycleLength = localCyleLength;
	        }
	        System.out.println(maxCycleLength);
	    }
	}
   

}
