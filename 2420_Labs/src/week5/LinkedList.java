package week5;

public class LinkedList {
	
	Node head;
	
	public void append(int data) {
		
		if (head == null) {
			head = new Node(data);
			return;
		}
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node(data);
	}
	
	public void prepend(int data) {
		
		Node newHead = new Node(data);
		newHead.next = head;
		head = newHead;
	}
	
	public void delete(int data) {
		
		Node current = head;
		Node previous = null;
		if (head != null && current.data == data) {
			head = current.next;
			return;
		}
		while (current != null && current.data != data) {
			previous = current;
			current = current.next;
		}
		if (current == null) {
			return;
		}
		previous.next = current.next;
	}
	
	public String searchReturnString(int data) {
		
	    String result = "Not found";
	    if (head == null) return "Empty List";
	    Node current = head;
	    if (head.data == data) {
	        result = "Data: " + head.data;
	    }
	    else {
	    	
	        while (current.next != null) {
	        	
	            if (current.next.data == data) {
	            	
	                result = "Data: " + current.next.data;
	            }
	            current = current.next;
	         }
	    }
	    return result;
	}
	
	public int length() {
		
		int len = 0;
		Node current = head;
		while (current != null) {
			
			len++;
			current = current.next;
		}
		return len;

	}
	
	public void printList() {
		
		Node current = head;
		System.out.print("List Contents: ");
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
			
		}
		System.out.print("Length: ");
		System.out.print(length());
		System.out.println("\s");
		
	}
}
