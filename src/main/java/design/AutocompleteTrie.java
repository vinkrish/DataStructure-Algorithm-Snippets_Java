package design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AutocompleteTrie {
	TrieNode root;
	StringBuilder searchQuery = new StringBuilder();

	public static void main(String[] args) {
		AutocompleteTrie obj = new AutocompleteTrie(
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
	
	public AutocompleteTrie(String[] sentences, int[] times) {
		root = new TrieNode();
    	for (int i=0; i<sentences.length; i++) {
    		root.insert(sentences[i], times[i]);
    	}
    }
	
	public static void searchLoop(AutocompleteTrie obj, Scanner input) {
		System.out.println("Enter the search characters:");
		
		List<String> results = new ArrayList<>();
		do {
			System.out.println();
			char searchChar = input.nextLine().charAt(0);
			if (searchChar == '#') break;
			results = obj.input(searchChar);
			for(String result: results) System.out.println(result);
		} while(true);
		if (results.size() == 0) {
			obj.root.insert(obj.searchQuery.toString(), 1);
		};
		obj.searchQuery = new StringBuilder();
	}
	
	public List<String> input(char c) {
    	searchQuery = searchQuery.append(c);
    	List<Autocomplete> searchResults = suggest(searchQuery.toString());
    	
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
	
	public void suggestHelper(TrieNode root, List<Autocomplete> list, StringBuilder curr) {
        if (root.isWord) {
            list.add(new Autocomplete(root.weight, curr.toString()));
        }
 
        if (root.children == null || root.children.isEmpty())
            return;
 
        for (TrieNode child : root.children.values()) {
            suggestHelper(child, list, curr.append(child.c));
            curr.setLength(curr.length() - 1);
        }
    }
 
    public List<Autocomplete> suggest(String prefix) {
        List<Autocomplete> list = new ArrayList<>();
        TrieNode lastNode = root;
        StringBuilder curr = new StringBuilder();
        for (char c : prefix.toCharArray()) {
            lastNode = lastNode.children.get(c);
            if (lastNode == null)
                return list;
            curr.append(c);
        }
        suggestHelper(lastNode, list, curr);
        return list;
    }
	
	class TrieNode {
        Map<Character, TrieNode> children;
        char c;
        boolean isWord;
        int weight;
 
        public TrieNode(char c) {
            this.c = c;
            this.children = new HashMap<>();
            this.weight = 1;
        }
 
        public TrieNode() {
            this.children = new HashMap<>();
            this.weight = 0;
        }
 
        public void insert(String word, int weight) {
            if (word == null || word.isEmpty())
                return;
            char firstChar = word.charAt(0);
            TrieNode child = children.get(firstChar);
            if (child == null) {
                child = new TrieNode(firstChar);
                children.put(firstChar, child);
            }
 
            if (word.length() > 1)
                child.insert(word.substring(1), weight);
            else {
            	child.isWord = true;
            	child.weight = weight;
            }
        }
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
