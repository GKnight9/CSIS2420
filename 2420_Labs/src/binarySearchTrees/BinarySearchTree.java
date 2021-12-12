package binarySearchTrees;
/**
 * 
 * @author Garrett Knight
 * CSIS 2420
 * Weeks 9 - 10 Assignment #1
 * This class contains the methods that construct our tree
 */
public class BinarySearchTree {
	
	public BSTNode root;
	public int BSTDepth = 0;	
	
	int nanoDivisor = 1000000000;
	
	public void insert(int data) {
		BSTNode newNode = new BSTNode(data);  
		if(root == null)
		{  
			root = newNode;  
			return;  
		}  
		else
		{  
			BSTNode current = root, parent = null;  
			while(true) 
			{  
				parent = current;  
				if(data < current.data)
				{  
					current = current.left;  
					if(current == null)
					{  
						parent.left = newNode;  
						return;  
					}  
				}  
				else
				{  
					current = current.right;  
					if(current == null)
					{  
						parent.right = newNode;  
						return;  
					}  
				}  
			}  
		}  
	}
	public void preOrderTraverse(BSTNode n) {  
		
		
			if(root == null) {
		  
				System.out.println("Tree is empty");  
				return;  
			}  
			else { 
		
			System.out.print(n.data + " ");  
				
	          if(n.left!= null) {
			
					preOrderTraverse(n.left);  
				}
				if(n.right!= null) {
					
					preOrderTraverse(n.right);  
				}
			
			}
	}  
	public void inOrderTraverse(BSTNode n) {
	
		if(root == null) {
			
			System.out.println("Tree is empty");  
			return;  
		}  
		else { 
					
			if(n.left!= null) {
				
				inOrderTraverse(n.left);  
			}
			System.out.print(n.data + " ");
			
			if(n.right!= null) {
				
				inOrderTraverse(n.right);  
			}
			
		}  
	}  
	public void postOrderTraverse(BSTNode n) {
		
		if(root == null) {
			
			System.out.println("Tree is empty");  
			return;  
		}   
		else {
			
		   if(n.left!= null) {
				
				postOrderTraverse(n.left);  
			}
			if(n.right!= null) {
				
				postOrderTraverse(n.right);  
			}
			System.out.print(n.data + " "); 
		}
	}
	public BSTNode searchRecursive(BSTNode n, int data) {
	    
		if (n == null || n.data == data) {
	    	return n;
	    }
	    
		if (n.data < data) {
	       return searchRecursive(n.right, data);
	    }
	    return searchRecursive(n.left, data);
	}
	public void treeDepth(BSTNode n, int counter) {
		
		if (n == null) {
			return;
		}
		if (n.left == null && n.right == null) {
			
			this.BSTDepth = Math.max(BSTDepth, counter);
		}
		treeDepth(n.left, counter + 1);
		treeDepth(n.right, counter + 1);
	}
	public static BSTNode deleteNode(BSTNode n, int data) {
	
        if(n == null) return n;
        if(data > n.data) {
        
        	// Traverse right
            n.right = deleteNode(n.right, data);
        }
        else if(data < n.data) {
        
        	// Traverse left
            n.left = deleteNode(n.left, data);
        }
        else {
        
        	// Found the node
            if(n.left == null && n.right == null) {
            
            	// It is a leaf, set it to null (delete it)
                n = null;
            }
            else if (n.right != null)  {
            	// Has a right-child, gets successor 
             //   n.data = getSuccessor(n);
                n.right = deleteNode(n.right, n.data);
            }
            else {
            // No successor so go back
            //    n.data = getPredecessor(n);
                n.left = deleteNode(n.left, n.data);
            }
        }
        return n;
    }
	//Used for timing the preOrderTraverse Method by nanoseconds
	public void preOrdertraverseTiming() {
			
		long start = System.nanoTime();
			preOrderTraverse(root);
			long end = System.nanoTime();	
			long duration = end - start;
			double seconds = (double)duration/nanoDivisor;
			System.out.printf("\nDuration: %,d nanoseconds [%.10f seconds]%n", duration, seconds);
	}
	//Used for timing the inOrderTraverse Method by nanoseconds
	public void inOrdertraverseTiming() {
		
		long start = System.nanoTime();
		inOrderTraverse(root);
		long end = System.nanoTime();	
		long duration = end - start;
		double seconds = (double)duration/nanoDivisor;
		System.out.printf("\nDuration: %,d nanoseconds [%.10f seconds]%n", duration, seconds);
	}
	//Used for timing the postOrderTraverse Method by nanoseconds
	public void postOrdertraverseTiming() {
		
		long start = System.nanoTime();
		postOrderTraverse(root);
		long end = System.nanoTime();	
		long duration = end - start;
		double seconds = (double)duration/nanoDivisor;
		System.out.printf("\nDuration: %,d nanoseconds [%.10f seconds]%n", duration, seconds);
	}
}
