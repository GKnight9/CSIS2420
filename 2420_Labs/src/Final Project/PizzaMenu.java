package pizzaMenu;
/**
 * 
 * @author Garrett Knight
 * CSIS 2420
 * Final Project - Pizza Menu
 * This class is intended to record pizza orders
 */
public class PizzaMenu {
	
	PizzaNode head;
	
	public void append (String firstName, int inches, char crustType, String crust, 
			 double cost, final double TAX_RATE, double tax, char choice, String userInput, 
			 String toppings, int numTopps) {
		
		if (head == null) {
			head = new PizzaNode (firstName, inches, crustType, crust, cost, TAX_RATE, tax, choice, userInput, 
					 toppings, numTopps);
			return;
		}
		PizzaNode current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new PizzaNode (firstName, inches, crustType, crust, cost, TAX_RATE, tax, choice, 
				userInput, toppings, numTopps);
	}
	public void delete(String firstName) {
		
		PizzaNode current = head;
		PizzaNode previous = null;
		if (head != null && current.firstName == firstName) {
			head = current.next;
			return;
		}
		while (current != null && current.firstName != firstName) {
			previous = current;
			current = current.next;
		}
		if (current == null) {
			return;
		}
		previous.next = current.next;
	}
	public int length() {
		
		int len = 0;
		PizzaNode current = head;
		while (current != null) {
			
			len++;
			current = current.next;
		}
		return len;

	}
	public void prepend(String firstName, int inches, char crustType, String crust, 
			 double cost, final double TAX_RATE, double tax, char choice, String userInput, 
			 String toppings, int numTopps) {
		
		PizzaNode newHead = new PizzaNode(firstName, inches, crustType, crust, cost, TAX_RATE, tax, choice, 
				userInput, toppings, numTopps);
		newHead.next = head;
		head = newHead;
	}
	public String searchCustomerOrder(String firstName) {
	    
		String result = "ID number not found";
		if (head == null) return "List Empty";
		PizzaNode current = head;
		if (head.firstName == firstName) {
				result = head.firstName
			            + "\t" + head.inches 
			            + head.crustType 
			            + head.crust 
			            + head.cost;
		}
		else {
			while (current.next != null) {
				if (current.next.firstName == firstName) {
					result = current.next.firstName
		               + "\t" + current.next.inches 
		                    + current.next.crustType
		                    + current.next.crust
		                    + current.next.cost;
					break;
				}
				current = current.next;
			}
		}
		return result;
	}
}
