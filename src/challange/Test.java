package challange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {
	
	static List<Integer> testCaseList = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		Test test = new Test();
		test.start();
		
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
	
	static void findAnswer() {
        for(int i=0;i<testCaseList.size();i++){
        	int testCase = testCaseList.get(i);
        	for(int j = 1; j<testCase; j++) {
        		if(j%3==0 && j%5==0) printString("FizzBuzz");
                else if(j%3==0) printString("Fizz");
                else if(j%5==0) printString("Buzz");
                else printNumber(j);
        	}
        }
    }
    
    static void printString(String s){
        System.out.println(s);
    }
    
    static void printNumber(int n) {
        System.out.println(n);
    }
    
    void start() {
        String stra = "do";
        String strb = end(stra);
        System.out.print(stra);
        System.out.print(": "+stra + strb);
    }
    String end(String stra) {
        stra = stra + "good";
        System.out.print(stra);
        return "good";
    }

}
