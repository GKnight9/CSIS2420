package theNetworkTree;
/**
 * 
 * @author Garrett Knight
 * CSIS 2420
 * Weeks 9 - 10 Assignment #2
 * This class contains the methods that construct the tree
 */
public class NetworkSearchTree {
	
	public NetworkNode root;
	public int BSTDepth = 0;	
	
	int nanoDivisor = 1000000000;
	
	public void insert(int ip, String user) {
		NetworkNode newNode = new NetworkNode(ip, user);  
		if(root == null)
		{  
			root = newNode;  
			return;  
		}  
		else
		{  
			NetworkNode current = root, parent = null;  
			while(true) 
			{  
				parent = current;  
				if(ip < current.ip)
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
	public void preOrderTraverse(NetworkNode n) {  
		
		
			if(root == null) {
		  
				System.out.println("Tree is empty");  
				return;  
			}  
			else { 
		
			System.out.print(n.user + " ");  
				
	          if(n.left!= null) {
			
					preOrderTraverse(n.left);  
				}
				if(n.right!= null) {
					
					preOrderTraverse(n.right);  
				}
			
			}
	}  
	public void inOrderTraverse(NetworkNode n) {
	
		if(root == null) {
			
			System.out.println("Tree is empty");  
			return;  
		}  
		else { 
					
			if(n.left!= null) {
				
				inOrderTraverse(n.left);  
			}
			System.out.print(n.user + " ");
			
			if(n.right!= null) {
				
				inOrderTraverse(n.right);  
			}
			
		}  
	}  
	public void postOrderTraverse(NetworkNode n) {
		
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
			System.out.print(n.user + " "); 
		}
	}
	public NetworkNode searchRecursive(NetworkNode n, int ip, String user) {
	    
		if (n == null || n.ip == ip) {
	    	return n;
	    }
	    
		if (n.ip < ip) {
	       return searchRecursive(n.right, ip, user);
	    }
	    return searchRecursive(n.left, ip, user);
	} 
	public void treeDepth(NetworkNode n, int counter) {
		
		if (n == null) {
			return;
		}
		if (n.left == null && n.right == null) {
			
			this.BSTDepth = Math.max(BSTDepth, counter);
		}
		treeDepth(n.left, counter + 1);
		treeDepth(n.right, counter + 1);
	}
    public static NetworkNode deleteNode(NetworkNode n, int ip) {
	
        if(n == null) return n;
        if(ip > n.ip) {
        
        	// Traverse right
            n.right = deleteNode(n.right, ip);
        }
        else if(ip < n.ip) {
        
        	// Traverse left
            n.left = deleteNode(n.left, ip);
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
                n.right = deleteNode(n.right, n.ip);
            }
            else {
            // No successor so go back
            //    n.data = getPredecessor(n);
                n.left = deleteNode(n.left, n.ip);
            }
        }
        return n;
    }
    public int length() {
		
		int len = 0;
		NetworkNode current = root;
		while (current != null) {
			
			len++;
			current = current.left;
			current = current.right;
		}
		return len;

	}
	public void printLine(int n) {
		
		for (int i = 1; i <= n; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	/*
	 * Used for timing the preOrderTraverse Method by nanoseconds
	 * Duration: 74,600 nanoseconds [0.0000746000 seconds]
	 */
	public void preOrdertraverseTiming() {
			
		long start = System.nanoTime();
			preOrderTraverse(root);
			long end = System.nanoTime();	
			long duration = end - start;
			double seconds = (double)duration/nanoDivisor;
			System.out.printf("\nDuration: %,d nanoseconds [%.10f seconds]%n", duration, seconds);
	}
	/*
	 * Used for timing the inOrderTraverse Method by nanoseconds
	 * Duration: 51,700 nanoseconds [0.0000517000 seconds]
	 */
	public void inOrdertraverseTiming() {
		
		long start = System.nanoTime();
		inOrderTraverse(root);
		long end = System.nanoTime();	
		long duration = end - start;
		double seconds = (double)duration/nanoDivisor;
		System.out.printf("\nDuration: %,d nanoseconds [%.10f seconds]%n", duration, seconds);
	}
	/*
	 * Used for timing the postOrderTraverse Method by nanoseconds
	 * Duration: 17,100 nanoseconds [0.0000171000 seconds]
	 */
	public void postOrdertraverseTiming() {
		
		long start = System.nanoTime();
		postOrderTraverse(root);
		long end = System.nanoTime();	
		long duration = end - start;
		double seconds = (double)duration/nanoDivisor;
		System.out.printf("\nDuration: %,d nanoseconds [%.10f seconds]%n", duration, seconds);
	}
}
