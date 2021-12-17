package pizzaMenu;

public class PizzaNode {
	
	PizzaNode next;
	
	 String firstName; // User's first name
	 int inches; // Size of the pizza
	 char crustType; // For type of crust
	 String crust; // Name of crust
	 double cost; // Cost of the pizza
	 final double TAX_RATE = .08; // Sales tax rate
	 double tax; // Amount of tax
	 char choice; // User's choice
	 String userInput; // User input
	 String toppings = "Cheese "; // List of toppings
	 int numTopps = 0; // Number of toppings
	 
	 public PizzaNode(String firstName, int inches, char crustType, String crust, 
			 double cost, final double TAX_RATE, double tax, char choice, String userInput, 
			 String toppings, int numTopps) {
		 
		 this.firstName = firstName; 
		 this.inches = inches;
		 this.crustType = crustType;
		 this.crust = crust = "Hand-tossed";
		 this.cost = cost = 12.99;
		// this.TAX_RATE = TAX_RATE;
		 this.tax = tax; 
		 this.choice = choice;
		 this.userInput = userInput;
		 this.toppings = toppings = "Cheese "; 
		 this.numTopps = numTopps = 0; 

	 }

}
