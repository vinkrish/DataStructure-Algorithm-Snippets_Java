package design.autocomplete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#').
 * 
 * You are given a string array sentences and an integer array times both of length n 
 * where sentences[i] is a previously typed sentence and times[i] is the corresponding number of times the sentence was typed. 
 * For each input character return the top 3 historical hot sentences that have the same prefix as the part of the sentence already typed.
 */
public class AutocompleteLinear {

	public static void main(String[] args) {
		AutocompleteLinear obj = new AutocompleteLinear(
				new String[]{"i love you", "island", "ironman", "i love design"}, 
				new int[]{5,2,3,2});
		
		System.out.println("Enter number of searches you wish to perform:");
		Scanner input = new Scanner(System.in);
		int searchCount = input.nextInt();
		input.nextLine();
		
		for(int i=0; i<searchCount; i++) {
			searchLoop(obj, input);
		}
		input.close();
	}
	
	public static void searchLoop(AutocompleteLinear obj, Scanner input) {
		System.out.println("Enter the search characters:");

		List<String> results = new ArrayList<>();
		do {
			System.out.println();
			char searchChar = input.nextLine().charAt(0);
			if (searchChar == '#') break;
			results = obj.input(searchChar);
			for(String result: results) System.out.println(result);
		} while(true);
		if (results.size() == 0) obj.appendNewAutocomplete(obj.getNewAutocomplete(obj.searchQuery.toString()));
		obj.searchQuery = new StringBuilder();
	}
	
	List<Autocomplete> autocompleteList = new ArrayList<>();
	
	StringBuilder searchQuery = new StringBuilder();

    public AutocompleteLinear(String[] sentences, int[] times) {
    	for (int i=0; i<sentences.length; i++) {
    		Autocomplete autocomplete = new Autocomplete(times[i], sentences[i]);
    		autocompleteList.add(autocomplete);
    	}
    }
    
    public List<String> input(char c) {
    	searchQuery = searchQuery.append(c);
    	List<Autocomplete> searchResults = new ArrayList<>();
    	for(int i=0; i<this.autocompleteList.size(); i++) {
    		if (autocompleteList.get(i).getSentence().startsWith(searchQuery.toString())) {
    			searchResults.add(autocompleteList.get(i));
    		}
    	}
    	
    	Collections.sort(searchResults);
    	
    	List<String> results = new ArrayList<>();
    	
    	for (int i=0; i < (searchResults.size()>3 ?  3 : searchResults.size()); i++) {
    		results.add(searchResults.get(i).getSentence());
    	}
    	
    	return results;
    }
    
    public Autocomplete getNewAutocomplete(String sentence) {
    	return new Autocomplete(1, sentence);
    }
    
    public void appendNewAutocomplete(Autocomplete autocomplete) {
    	this.autocompleteList.add(autocomplete);
    }

    class Autocomplete implements Comparable<Autocomplete> {

    	Integer weight = 0;
    	String sentence = "";
    	
    	public Autocomplete(Integer weight, String sentence) {
    		this.weight = weight;
    		this.sentence = sentence;
    	}
    	
    	@Override
    	public int compareTo(Autocomplete o) {
    		if (this.weight == o.weight) return 0; 
    		else if (this.weight > o.weight) return -1;
    		else if (this.weight < o.weight) return 1;
    		return this.sentence.compareTo(o.sentence);
    	}
    	
    	public Integer getWeight() {
    		return weight;
    	}

    	public void setWeight(Integer weight) {
    		this.weight = weight;
    	}

    	public String getSentence() {
    		return sentence;
    	}

    	public void setSentence(String sentence) {
    		this.sentence = sentence;
    	}
    	
    }

}
