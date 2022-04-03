package commontests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		/*
		Scanner input = new Scanner(System.in);
		int testCaseCount = input.nextInt();
		input.nextLine();
		for(int i=0; i<testCaseCount; i++){
		    testCaseList.add(Integer.parseInt(input.nextLine().split(" ")[1]));
		}
		input.close();
		*/
		
		// ----------------------------------- //
		
		int x=9,y=10,z;
		z=++x+y++;
		
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		
		// ----------------------------------- //
		
		List<String> list1 = new ArrayList<>();
		list1.add("hi");
		
		List<String> list2 = list1;
		list2.add("hey");
		
		System.out.println(list1);
		list1.clear();
		System.out.println(list2);
		
		// ----------------------------------- //
		
		String[] emails = {"test.email+alex@gmail.com","test.e.mail+bob.cathy@gmail.com","testemail+david@g.mail.com"};
		System.out.println(numUniqueEmails(emails));
		
		// breakOuterLoop();
		
		// Given getMeChange(MoneyGiven, ActualPrice);
		int[] changeReceived = getMeChange(10, 3.17);
        for(int change: changeReceived) System.out.print(change);
		
		// Minimum no of filters required to cut pollution by half 
		int[] pollution = new int[]{100, 30, 20}; // new int[]{10, 10}; // new int[]{7, 0};
		System.out.println(numberOfFilters(pollution));
		
	}
	
	public static int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet();
        for(String email: emails) {
            String[] emailLocalNameAndDomanName = email.split("@");
            String emailWithoutPlus = emailLocalNameAndDomanName[0].split("\\+")[0];
            String strippedEmailLocalName = String.join("", emailWithoutPlus.split("\\."));
            if(!uniqueEmails.contains(String.format("%s@%s", strippedEmailLocalName, emailLocalNameAndDomanName[1]))) {
                uniqueEmails.add(String.format("%s@%s", strippedEmailLocalName, emailLocalNameAndDomanName[1]));
            }
        }
        return uniqueEmails.size();
    }
	
	public static void breakOuterLoop() {
        outerloop:
        for (int i=0; i < 5; i++) {
            for (int j=0; j < 5; j++) {
                if (i * j > 6) {
                    System.out.println("Breaking");
                    break outerloop;
                }
                System.out.println(i + " " + j);
            }
        }
        System.out.println("Done");
    }
	
	static int[] getMeChange(double M, double P){
        int[] change = new int[]{0,0,0,0,0,0};
        int[] coins = {100, 50, 25, 10, 5, 1};

        double returnChange = Math.floor((M - P) * 100);
        double calculatedChange = 0;
        double remainingChange = Math.floor(returnChange);

        for(int i=0; i<coins.length; i++) {
            if(calculatedChange != returnChange) {
                while(Math.floor(remainingChange) >= coins[i]) {
                    remainingChange = Math.floor(remainingChange-coins[i]);
                    calculatedChange += coins[i];
                    change[i] = change[i]+1;
                }
            }
        }

        return change;
    }
	
	static int numberOfFilters(int[] pollution) {
	    int noOfFilters = 0;
	    Arrays.sort(pollution);

	    int totalPollution = 0;
	    for(int p: pollution) totalPollution += p;

	    float halfPollution = totalPollution/2;

	    float reducedPollution = 0;
	    for(int i=pollution.length-1; i >= 0; i--) {
	        float currentPollution = pollution[i];
	        if(currentPollution > 0 && reducedPollution < halfPollution) {
	            noOfFilters += 1;
	            currentPollution = currentPollution / 2;
	            reducedPollution += currentPollution;
	        }

	        while(i>1 && currentPollution > pollution[i-1] && reducedPollution < halfPollution) {
	            noOfFilters += 1;
	            currentPollution = currentPollution / 2;
	            reducedPollution += currentPollution;
	        }
	    }
	    return noOfFilters;
	}

}
