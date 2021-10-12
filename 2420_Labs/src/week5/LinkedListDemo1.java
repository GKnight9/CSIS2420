package week5;

public class LinkedListDemo1 {
	
	public static void main(String[] args) {
		
		// Instantiates the linked list
		LinkedList ll = new LinkedList();
		
		// Appends the nodes
		ll.append(2);
		ll.append(4);
		ll.append(6);
		ll.append(8);
		ll.append(10);
		ll.printList();
		
		// Prepends a node (replacing the head)
		ll.prepend(0);
		ll.printList();
		
		 // Delete the following nodes
        ll.delete(8);
        ll.delete(6);
        ll.printList();
        
        // Demonstrates search options
        System.out.print("\n");
        System.out.print("\t\tSearch Examples\n");
        
        // Search by data number & return compound string
        System.out.println("\nSearch by data number & return compound string:");
        System.out.println(ll.searchReturnString(7));
        System.out.println(ll.searchReturnString(2));
	}
}

