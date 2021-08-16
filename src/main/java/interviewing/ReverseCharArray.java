package interviewing;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseCharArray {

	public static void main(String[] args) {
		
		char[] sentence = {'a','w','e','s','o','m','e',' ','h','m','m',' ','i','s',' ','t','h','i','s'};
		System.out.println(Arrays.toString(solution(sentence)));
		
	}
	
	public static char[] solution(char[] sentence) {
		ArrayList<Integer> spaces = new ArrayList<>();
		for (int i=0, j=sentence.length-1; i<sentence.length/2; i++, j--) {			
			char temp = sentence[j];
			sentence[j] = sentence[i];
			sentence[i] = temp;
		}
		
		spaces.add(-1);
		for (int i=0; i<sentence.length; i++) {
			if (sentence[i] == ' ') spaces.add(i);
		}
		spaces.add(sentence.length);
		
		for (int i=0; i<spaces.size()-1; i++) {
			int l=spaces.get(i)+1;
			int m=spaces.get(i+1)-1;
			for (int j=spaces.get(i)+1, k=spaces.get(i+1)-1; j<m-(m-l)/2; j++, k--) {
				char temp = sentence[k];
				sentence[k] = sentence[j];
				sentence[j] = temp;
			}
		}
		return sentence;
	}

}
