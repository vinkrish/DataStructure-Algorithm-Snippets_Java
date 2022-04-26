package commontests;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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
		System.out.println("Object reference:");
		
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
		System.out.println("Getting change:");
		int[] changeReceived = getMeChange(10, 3.17);
        for(int change: changeReceived) System.out.print(change);
        System.out.println();
		
		// Minimum no of filters required to cut pollution by half 
        System.out.println("Number of filters:");
		int[] pollution = new int[]{100, 30, 20}; // new int[]{10, 10}; // new int[]{7, 0};
		System.out.println(numberOfFilters(pollution));
		
		System.out.println("Forming word:");
		String[] words = {"U>N", "G>A", "R>Y", "H>U", "N>G", "A>R"};
        System.out.println(findWord(words)); 
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

    static String findWord(String [] words) { 
        Deque<String> deque = new ArrayDeque<>();
        Map<Integer, String> map = new HashMap<>();

        String[] currentStrSplit = words[0].split(">");
        deque.addFirst(currentStrSplit[0]);
        deque.addLast(currentStrSplit[1]);
        map.put(0, words[0]);

        while(map.size() < words.length) {
            for(int i=1; i<words.length; i++) {
                String s = words[i];
                currentStrSplit = s.split(">");
    
                if(!map.containsKey(i)){
                    if(deque.getFirst().equals(currentStrSplit[0])) {
                        String temp = deque.getFirst();
                        deque.removeFirst();
                        deque.addFirst(currentStrSplit[1]);
                        deque.addFirst(temp);
                        map.put(i, words[i]);
                    } else if(deque.getLast().equals(currentStrSplit[0])) {
                        deque.addLast(currentStrSplit[1]);
                        map.put(i, words[i]);
                    } else if(deque.getFirst().equals(currentStrSplit[1])) {
                        deque.addFirst(currentStrSplit[0]);
                        map.put(i, words[i]);
                    } else if(deque.getLast().equals(currentStrSplit[1])) {
                        String temp = deque.getLast();
                        deque.removeLast();
                        deque.addLast(currentStrSplit[0]);
                        deque.addLast(temp);
                        map.put(i, words[i]);
                    }
                }
    
            }
        }
        return deque.toString();
    }

}
