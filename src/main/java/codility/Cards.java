package codility;

import java.util.HashMap;

public class Cards {

	public static void main(String[] args) {
		System.out.println(solution("K586K","AJ65K"));
	}
	public static int solution(String A, String B) {
        int count = 0;
        char arr[] = {'0','1','2','3','4','5','6','7','8','9','T','J','Q','K','A'};
         HashMap<Character, Integer> hmap = 
                     new HashMap<Character, Integer>();
        int arrSize = arr.length;
        for (int i = 2; i < arrSize; i++)
        {
            hmap.put(arr[i], i);
        }
        
        int deckSize = A.length();
        for (int i = 0; i < deckSize; i++){
            int alecCardValue = hmap.get(A.charAt(i));
            int bobCardValue = hmap.get(B.charAt(i));
            if(alecCardValue > bobCardValue) {
                count += 1;
            }
        }
        return count;
    }

}
