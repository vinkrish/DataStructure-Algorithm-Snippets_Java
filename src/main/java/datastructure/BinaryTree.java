package datastructure;

public class BinaryTree {
	// Root of Binary Tree
    public Node root;
 
    // Constructors
    BinaryTree(int key)
    {
        root = new Node(key);
    }
 
    public BinaryTree()
    {
        root = null;
    }
    
    public BinaryTree(Node node) {
    	root = node;
    }
 
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
 
        /*create root*/
        tree.root = new Node(1);
 
        /* following is the tree after above statement
 
              1
            /   \
          null  null     */
 
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
 
        /* 2 and 3 become left and right children of 1
               1
             /   \
            2      3
          /    \    /  \
        null null null null  */
 
 
        tree.root.left.left = new Node(4);
        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null
         */
        tree.root.left.right = new Node(5);
        /* 5 becomes right child of 2
		        1
		    /       \
		   2          3
		 /   \       /  \
		4     5    null  null
		/   \
		null null
		*/
        
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        
        tree.printPreorder();
        
        tree.printInorder();
        
        tree.printPostorder();
    }
    
	/*
	 * Given a binary tree, print its nodes in postorder traversal
	 */
	void printPostorder(Node node) {
		if (node == null)
			return;

		// first recur on left subtree
		printPostorder(node.left);

		// then recur on right subtree
		printPostorder(node.right);

		// now deal with the node
		System.out.print(node.key + " ");
	}

	/* 
	 * Given a binary tree, print its nodes in inorder traversal
	 */
	void printInorder(Node node) {
		if (node == null)
			return;

		/* first recur on left child */
		printInorder(node.left);

		/* then print the data of node */
		System.out.print(node.key + " ");

		/* now recur on right child */
		printInorder(node.right);
	}

	/* 
	 * Given a binary tree, print its nodes in preorder traversal 
	 */
	void printPreorder(Node node) {
		if (node == null)
			return;

		/* first print data of node */
		System.out.print(node.key + " ");

		/* then recur on left subtree */
		printPreorder(node.left);

		/* now recur on right subtree */
		printPreorder(node.right);
	}
	  
	// Wrappers over above recursive functions

	public void printPreorder() {
		System.out.println("Preorder traversal:");
		printPreorder(root);
		System.out.println();
	}
	
	public void printInorder() {
		System.out.println("Inorder traversal:");
		printInorder(root);
		System.out.println();
	}
	
	public void printPostorder() {
		System.out.println("postorder traversal:");
		printPostorder(root);
		System.out.println();
	}
}