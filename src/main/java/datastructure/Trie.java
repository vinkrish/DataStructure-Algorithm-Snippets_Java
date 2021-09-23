package datastructure;

/*
 * https://www.geeksforgeeks.org/trie-insert-and-search/
 */
public class Trie {
	
	// Alphabet size (# of symbols)
	static final int ALPHABET_SIZE = 26;
	
	// trie node
	static class TrieNode {
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
	
		// isEndOfWord is true if the node represents
		// end of a word
		boolean isEndOfWord;
		
		TrieNode(){
			isEndOfWord = false;
			for (int i = 0; i < ALPHABET_SIZE; i++)
				children[i] = null;
		}
	};
	
	static TrieNode root;
	
	/*
	 * If not present, inserts key into trie.
	 * If the key is prefix of trie node, just marks leaf node.
	 */
	static void insert(String key) {
		TrieNode pCrawl = root;
	
		for (int level = 0; level < key.length(); level++)
		{
			int index = key.charAt(level) - 'a';
			if (pCrawl.children[index] == null)
				pCrawl.children[index] = new TrieNode();
	
			pCrawl = pCrawl.children[index];
		}
	
		// mark last node as leaf
		pCrawl.isEndOfWord = true;
	}
	
	// Returns true if key presents in trie, else false
	static boolean search(String key) {
		TrieNode pCrawl = root;
	
		for (int level = 0; level < key.length(); level++) {
			int index = key.charAt(level) - 'a';
			pCrawl = pCrawl.children[index];
			if (pCrawl == null)  return false;
		}
		return (pCrawl.isEndOfWord);
	}
	
	// Returns true if root has no children, else false
    static boolean isEmpty(TrieNode root) {
        for (int i = 0; i < ALPHABET_SIZE; i++)
            if (root.children[i] != null)
                return false;
        return true;
    }
    
    // Recursive function to delete a key from given Trie
    static TrieNode remove(TrieNode root, String key, int depth) {
        // If tree is empty
        if (root == null)
            return null;
 
        // If last character of key is being processed
        if (depth == key.length()) {
 
            // This node is no more end of word after
            // removal of given key
            if (root.isEndOfWord)
                root.isEndOfWord = false;
 
            // If given is not prefix of any other word
            if (isEmpty(root)) {
                root = null;
            }
 
            return root;
        }
 
        // If not last character, recur for the child
        // obtained using ASCII value
        int index = key.charAt(depth) - 'a';
        root.children[index] =
            remove(root.children[index], key, depth + 1);
 
        // If root does not have any child (its only child got
        // deleted), and it is not end of another word.
        if (isEmpty(root) && root.isEndOfWord == false){
            root = null;
        }
 
        return root;
    }
	
	public static void main(String args[]) {
		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = {"the", "a", "there", "answer", "any",
						"by", "bye", "their"};
	
		String output[] = {"Not present in trie", "Present in trie"};
	
	
		root = new TrieNode();
	
		// Construct trie
		int i;
		for (i = 0; i < keys.length ; i++)
			insert(keys[i]);
	
		// Search for different keys
		if(search("the"))
			System.out.println("the --- " + output[1]);
		else System.out.println("the --- " + output[0]);
		
		if(search("these"))
			System.out.println("these --- " + output[1]);
		else System.out.println("these --- " + output[0]);
		
		if(search("their"))
			System.out.println("their --- " + output[1]);
		else System.out.println("their --- " + output[0]);
		
		System.out.println("Removing 'their'");
		remove(root, "their", 0);
		
		if(search("their"))
			System.out.println("their --- " + output[1]);
		else System.out.println("their --- " + output[0]);
		
	}
}
