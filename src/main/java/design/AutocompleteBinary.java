package design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * Binary Search Approach is suitable for moderate number of Search Phrases but as the complexity of the Search Phrases increase, 
 * it gets inefficient with lack of Typo-Tolerance.
 */
public class AutocompleteBinary {

	public static void main(String[] args) {
		AutocompleteBinary obj = new AutocompleteBinary(
				new String[]{"i love you", "island", "ironman", "i love design"}, 
				new int[]{5,2,3,2});
		
		System.out.println("Enter number of searches you wish to perform:");
		Scanner input = new Scanner(System.in);
		int searchCount = input.nextInt();
		input.nextLine();
		
		for(int i=0; i<searchCount; i++) {
			obj.sortAutocompleteList();
			searchLoop(obj, input);
		}
		input.close();
	}
	
	public void printAutocomplete() {
		for(Autocomplete au: autocompleteList) System.out.println(au.sentence);
	}
	
	public static void searchLoop(AutocompleteBinary obj, Scanner input) {
		System.out.println("Enter the search characters:");
		
		List<String> results = new ArrayList<>();
		do {
//			obj.printAutocomplete();
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

    public AutocompleteBinary(String[] sentences, int[] times) {
    	for (int i=0; i<sentences.length; i++) {
    		Autocomplete autocomplete = new Autocomplete(times[i], sentences[i]);
    		autocompleteList.add(autocomplete);
    	}
    }
    
    public void sortAutocompleteList() {
    	Collections.sort(autocompleteList);
    }
    
    public List<String> input(char c) {
    	searchQuery = searchQuery.append(c);
    	List<Autocomplete> searchResults = searchAutocomplete(searchQuery.toString());
    	
    	Collections.sort(searchResults, new Comparator<Autocomplete>() {
			@Override
			public int compare(Autocomplete o1, Autocomplete o2) {
				if (o1.weight == o2.weight) return 0; 
	    		else if (o1.weight > o2.weight) return -1;
	    		else if (o1.weight < o2.weight) return 1;
	    		return o1.sentence.compareTo(o2.sentence);
			}
    		
    	});
    	
    	List<String> results = new ArrayList<>();
    	
    	for (int i=0; i < (searchResults.size()>3 ?  3 : searchResults.size()); i++) {
    		results.add(searchResults.get(i).getSentence());
    	}
    	
    	return results;
    }
    
    public List<Autocomplete> searchAutocomplete(String searchString) {
    	List<Autocomplete> searchResults = new ArrayList<>();
    	int index = -1;
    	int first = 0;
    	int last = autocompleteList.size() - 1;
    	while (first <= last) {
    		int mid = (first + last) / 2;
    		if(autocompleteList.get(mid).sentence.startsWith(searchString)) {
    			index = mid;
    			break;
    		}
    		else {
    			if(searchString.compareTo(autocompleteList.get(mid).sentence) < 0) last = mid - 1;
    			else first = mid + 1;
    		}
    	}
    	if (index == -1) return searchResults;
    	
    	for(int i=index-1; i>=0; i--) {
    		if (autocompleteList.get(i).sentence.startsWith(searchString)) {
    			searchResults.add(autocompleteList.get(i));
    		} else break;
    	}
    	for(int i=index; i<=last; i++) {
    		if (autocompleteList.get(i).sentence.startsWith(searchString)) {
    			searchResults.add(autocompleteList.get(i));
    		} else break;
    	}
    	return searchResults;
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

