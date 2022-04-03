package commontests;

import java.util.HashMap;

public class LongestSubString {

	public static void main(String[] args) {
		// find the length of the longest substring without repeating characters
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
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

}
