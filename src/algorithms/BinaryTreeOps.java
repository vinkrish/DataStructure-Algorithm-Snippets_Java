package algorithms;

import datastructure.BinaryTree;
import datastructure.Node;

public class BinaryTreeOps extends BinaryTree {
	
	public BinaryTreeOps() {
    	
    }
	
	public BinaryTreeOps(Node node) {
    	super(node);
    }
	
	// This method mainly calls insertRec()
    public void insert(int key) {
       root = insertRecursive(root, key);
    }
     
    /* A recursive function to insert a new key in BST */
    Node insertRecursive(Node root, int key) {
 
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRecursive(root.left, key);
        else if (key > root.key)
            root.right = insertRecursive(root.right, key);
 
        /* return the (unchanged) node pointer */
        return root;
    }
	
	/*
	 One step right and then always left
	*/
	 public int successor(Node root) {
	    root = root.right;
	    while (root.left != null) root = root.left;
	    return root.key;
	 }

	/*
	 One step left and then always right
	*/
	public int predecessor(Node root) {
	    root = root.left;
	    while (root.right != null) root = root.right;
	    return root.key;
	}
	
	public Node deleteNode(Node root, int key) {
	    if (root == null) return null;

	    // delete from the right subtree
	    if (key > root.key) root.right = deleteNode(root.right, key);
	    // delete from the left subtree
	    else if (key < root.key) root.left = deleteNode(root.left, key);
	    // delete the current node
	    else {
	      // the node is a leaf
	      if (root.left == null && root.right == null) root = null;
	      // the node is not a leaf and has a right child
	      else if (root.right != null) {
		root.key = successor(root);
		root.right = deleteNode(root.right, root.key);
	      }
	      // the node is not a leaf, has no right child, and has a left child    
	      else {
		root.val = predecessor(root);
		root.left = deleteNode(root.left, root.val);
	      }
	    }
	    return root;
	}
 
	public static void main(String[] args) {
		BinaryTreeOps tree = new BinaryTreeOps();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(8);
 
        System.out.println("Preorder traversal of binary tree is :");
        tree.printPreorder();
 
        System.out.println("\nInorder traversal of binary tree is :");
        tree.printInorder();
 
        System.out.println("\nPostorder traversal of binary tree is :");
        tree.printPostorder();
        
        System.out.println("\n");
        
        if(tree.isBalanced(tree.root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
        
        System.out.println("\n");
        
        BinaryTreeOps treeInsert = new BinaryTreeOps();
        
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        treeInsert.insert(50);
        treeInsert.insert(30);
        treeInsert.insert(20);
        treeInsert.insert(40);
        treeInsert.insert(80);
        treeInsert.insert(70);
        treeInsert.insert(60);        
 
        // print inorder traversal of the BST
        //treeInsert.inorder();
        treeInsert.printPostorder();
        System.out.println();
        treeInsert.printInorder();
        System.out.println();
        treeInsert.printPreorder();
        
        System.out.println("\n");
        Node n = search(treeInsert.root, 70);
        System.out.println(n.key);
        
        System.out.println("\n");
        BinaryTreeOps invertedTree = new BinaryTreeOps(invertTree(treeInsert.root));
        invertedTree.printInorder();
	}
	
	// A utility function to search a given key in BST
	public static Node search(Node root, int key)
	{
	    // Base Cases: root is null or key is present at root
	    if (root==null || root.key==key)
	        return root;
	 
	    // val is greater than root's key
	    if (root.key > key)
	        return search(root.left, key);
	 
	    // val is less than root's key
	    return search(root.right, key);
	}
	
	/* Returns true if binary tree with root as root is height-balanced */
    boolean isBalanced(Node node) 
    {
        int lh; /* for height of left subtree */
  
        int rh; /* for height of right subtree */
  
        /* If tree is empty then return true */
        if (node == null)
            return true;
  
        /* Get the height of left and right sub trees */
        lh = height(node.left);
        rh = height(node.right);
  
        if (Math.abs(lh - rh) <= 1
                && isBalanced(node.left)
                && isBalanced(node.right)) 
            return true;
  
        /* If we reach here then tree is not height-balanced */
        return false;
    }
  
    /* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
    /*  The function Compute the "height" of a tree. Height is the
        number of nodes along the longest path from the root node
        down to the farthest leaf node.*/
    int height(Node node) 
    {
        /* base case tree is empty */
        if (node == null)
            return 0;
  
        /* If tree is not empty then height = 1 + max of left
         height and right heights */
        return 1 + Math.max(height(node.left), height(node.right));
    }
    
    public static Node invertTree(Node root) {
        if(root == null) {
            return null;
        }
        
        Node right = invertTree(root.right);
        Node left = invertTree(root.left);
        
        root.left = right;
        root.right = left;
        
        return root;
    }

}
