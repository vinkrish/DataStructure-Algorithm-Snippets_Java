package challange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Test {
	
	static List<Integer> testCaseList = new ArrayList<>();
	

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
		
		/*
		int x,y,z;
		x=9;
		y=10;
		z=++x+y++;
		
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		*/
		
		/*
		List<String> list1 = new ArrayList<>();
		list1.add("hi");
		
		List<String> list2 = list1;
		list2.add("hey");
		
		System.out.println(list1);
		list1.clear();
		System.out.println(list2);
		*/
		
		/*
		String email = "vinay.krishna@gmail.com";
		String[] splitValues = "vin.kin".split("\\.");
		for(String value: splitValues) {
			System.out.println(value);
		}
		System.out.println(String.join("", email.split("@")[0].split("\\.")));
		
		String emailplus = "vinay.krishna+1989@leetcode.com";
		if(emailplus.split("@")[0].split("\\+").length > 0) {
			String uniqueEmail = String.join("", emailplus.split("@")[0].split("\\+")[0].split("\\."));
			System.out.println(uniqueEmail);
		}
		*/
		
		/*
		String[] emails = {"test.email+alex@gmail.com","test.e.mail+bob.cathy@gmail.com","testemail+david@g.mail.com"};
		System.out.println(numUniqueEmails(emails));
		*/
		
		/*
		int[] numbers = {10,13,12,14,15};
		System.out.println(oddEvenJumps(numbers));
		*/
		
		// System.out.println(licenseKeyFormatting("----", 4));
		
		// System.out.println(totalFruitOwn(new int[]{2,1,2,2,3,3,3,4}));
		
		// System.out.println(lengthOfLongestSubstring("abcabcbb"));
		
		System.out.println(maxArea(new int[]{1,1}));
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
	
	public static int oddEvenJumps(int[] A) {
		int N = A.length;
        if (N <= 1) return N;
        boolean[] odd = new boolean[N];
        boolean[] even = new boolean[N];
        odd[N-1] = even[N-1] = true;

        TreeMap<Integer, Integer> vals = new TreeMap();
        vals.put(A[N-1], N-1);
        for (int i = N-2; i >= 0; --i) {
            int v = A[i];
            if (vals.containsKey(v)) {
                odd[i] = even[vals.get(v)];
                even[i] = odd[vals.get(v)];
            } else {
                Integer lower = vals.lowerKey(v);
                Integer higher = vals.higherKey(v);

                if (lower != null)
                    even[i] = odd[vals.get(lower)];
                if (higher != null) {
                    odd[i] = even[vals.get(higher)];
                }
            }
            vals.put(v, i);
        }

        int ans = 0;
        for (boolean b: odd)
            if (b) ans++;
        return ans;
    }
	
	public static String licenseKeyFormatting(String S, int K) {
		StringBuilder originalString = new StringBuilder(String.join("", S.split("-")));
		if(originalString.length() > 0) {
			String reversedString = originalString.reverse().toString();
			StringBuilder sb = new StringBuilder();
	        for(int i=1, j=0; j<reversedString.length(); i++) {
	        	if(j+K <= reversedString.length()) sb.append(reversedString.substring(j, j+K)).append("-");
	        	else sb.append(reversedString.substring(j, reversedString.length())).append("-");
	        	j = i*K;
	        }       
	        return sb.reverse().substring(1).toUpperCase();
		} else {
			return originalString.toString();
		}
    }
	
	private static final int MAX = 2; 
	
	public static int totalFruitOwn(int[] tree) {
		LinkedHashMap<Integer, Integer> li_hash_map =  new LinkedHashMap<Integer, Integer>() {		
			private static final long serialVersionUID = 1L;

			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
	            return size() > MAX; 
	        } 
	    };
	    
	    int finalFruitCount = 0;
	    int i = 0;
	    loopAgain: while(true) {
	    	int localFruitCount = 0;
	    	for(int j=i; j<tree.length; j++) {
		    	if(li_hash_map.size() != 2 && !li_hash_map.containsKey(tree[j])) {
		    		li_hash_map.put(tree[j], j);
		    	} else if(li_hash_map.size() == 2 && !li_hash_map.containsKey(tree[j])) {  		
		    		li_hash_map.put(tree[j], j);
		    		// get first key and then value
		    		Object key = li_hash_map.keySet().iterator().next();
		    		i = li_hash_map.get(key);
		    		li_hash_map.clear();
		    		continue loopAgain;
		    	}
		    	localFruitCount += 1;
		    	finalFruitCount = Math.max(finalFruitCount, localFruitCount);
		    }
	    	break;
	    }
	    
	    return finalFruitCount;
	}
	
	public static int totalFruit(int[] tree) {
        // We'll make a list of indexes for which a block starts.
        List<Integer> blockLefts = new ArrayList();

        // Add the left boundary of each block
        for (int i = 0; i < tree.length; ++i)
            if (i == 0 || tree[i-1] != tree[i])
                blockLefts.add(i);

        // Add tree.length as a sentinel for convenience
        blockLefts.add(tree.length);

        int ans = 0, i = 0;
        search: while (true) {
            // We'll start our scan at block[i].
            // types : the different values of tree[i] seen
            // weight : the total number of trees represented
            //          by blocks under consideration
            Set<Integer> types = new HashSet();
            int weight = 0;

            // For each block from the i-th and going forward,
            for (int j = i; j < blockLefts.size() - 1; ++j) {
                // Add each block to consideration
                types.add(tree[blockLefts.get(j)]);
                weight += blockLefts.get(j+1) - blockLefts.get(j);

                // If we have 3+ types, this is an illegal subarray
                if (types.size() >= 3) {
                    i = j - 1;
                    continue search;
                }

                // If it is a legal subarray, record the answer
                ans = Math.max(ans, weight);
            }
            break;
        }
        return ans;
    }
	
	public static int lengthOfLongestSubstring(String s) {
        int longestSubstringLength = 0;
        int i = 0;
        recurse: while(true) {
            
            int localSubtringLength = 0;
            HashMap<Character, Integer> seenCharacters = new HashMap<>();
            for(int j = i; j < s.length(); j++) {
                if(seenCharacters.containsKey(s.charAt(j))) {
                    int lastSeenIndex = seenCharacters.get(s.charAt(i+1));
                    if(lastSeenIndex == i) {
                    	i += 1;
                    } else {
                    	i = lastSeenIndex;
                    }
                    continue recurse;   
                } else {
                    localSubtringLength += 1;
                    seenCharacters.put(s.charAt(j), j);
                }                
                longestSubstringLength = Math.max(longestSubstringLength, localSubtringLength);
            }
            break;
        }
        return longestSubstringLength;
    }
	
	public static int maxArea(int[] height) {
        int maximumArea = 0;
        int len = height.length;
        for(int i=0; i<=len-1; i++) {
            for(int j=i+1; j<len; j++) {
                int sharedHeight = Math.min(height[i], height[j]);
                maximumArea = Math.max(maximumArea, sharedHeight * (j-i));
            }
        }
        return maximumArea;
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
   

}
