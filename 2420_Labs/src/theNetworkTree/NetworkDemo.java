package theNetworkTree;
/**
 * 
 * @author Garrett Knight
 * CSIS 2420
 * Weeks 9 - 10 Assignment #2
 * The main class that prompts the user to input the number of nodes on a tree
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class NetworkDemo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		NetworkSearchTree nst = new NetworkSearchTree();
		//Allows user input
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		int choice;
        boolean quit = false;
        
      
	    do {
	    	//The options menu prompts the user to select what information they want to see from the list	
	    	optionMenu();
	    	choice = input.nextInt();
	    		switch (choice) {
	    		
	    		case 1:
	    			
	    			createUserTree();
	    			break;
	    		case 2:
	    			
	    			findIPAddress();
	    			break;
	    		case 3: 
	    			
	    			findUsername();
	    			break;
	    		case 4:
	    			
	    			findLength();
	    			break;
	    		case 5:
	    			
	    			printTree();
	    			break;
	    		case 6: 
    				//Ends the loop
    				quit = true;
    				break;
    			default:
    				
    				System.out.println("\nInvalid Entry\n");
    			
	    		}
	    	}
	    while(!quit);	
	   
	    System.out.println("\nGoodbye!");
	    input.close();
		}
	//Prompts the user to enter commands from the  options menu
		private static void optionMenu() {
			
			NetworkSearchTree nst = new NetworkSearchTree();
			
			nst.printLine(35);
			System.out.println("1. Build Users Tree");
			System.out.println("2. Find by IP Address");
			System.out.println("3. Find by Username");
			System.out.println("4. Report Number of Nodes");
			System.out.println("5. Print Entire Tree");
			System.out.println("6. Exit");
			nst.printLine(35);
			System.out.print("Enter 1, 2, 3, 4, 5 or 6: ");
			System.out.println("\n");
		}  
		private static void createUserTree() throws IOException {
			
			NetworkSearchTree nst = new NetworkSearchTree();
        	File userList = new File ("C:\\Data\\users.txt");
        	BufferedReader br = null;
            String line = "";
            String splitBy = ",";
           
            br = new BufferedReader(new FileReader(userList));
	    
            while ((line = br.readLine()) != null) {
		    
            	String[] user = line.split(splitBy);
            	int ip = Integer.parseInt(user[0]);
            	String userName = user[1]; 
            	nst.insert(ip, userName);
            } 
            br.close();
           
            System.out.println("Users Tree Created");
        }
		private static void findIPAddress() {
			
			NetworkSearchTree nst = new NetworkSearchTree();
			Scanner input = new Scanner(System.in);
			int ip;
			int min = 1;
			int max = 255;
			String user = null;NetworkNode n = null;
		/*	NetworkNode n = null;
			nst.searchRecursiveUser(n, user);*/
			System.out.println("Enter last 3 digits of IP: ");
			ip = input.nextInt();
			if (ip >= min && ip <= max) {
				
				
				nst.searchRecursive(n, ip, user);
				
				System.out.println("Found: 10.0.0." + ip + " " + user);
			}
			else {
				
				System.out.println("IP 10.0.0." + ip + " not found.");
			}
		}
		private static void findUsername() {
			
			NetworkSearchTree nst = new NetworkSearchTree();
			Scanner input = new Scanner(System.in);
			String userName;
			int ip = 0;
			
			System.out.println("Enter Username: ");
			userName = input.nextLine();
			if (userName != null) {
				NetworkNode n = null;
				nst.searchRecursive(n, ip, userName);
				System.out.println("Found: 10.0.0." + ip + "  " + userName);
			}
			else {
				
				System.out.println("Username " + userName);
			}
		}
		private static void findLength() {
			
			NetworkSearchTree nst = new NetworkSearchTree();
			
			System.out.print("Number of Users: ");
			System.out.print(nst.length());
			System.out.println("\s");
		}
		private static void printTree() {
			
			NetworkSearchTree nst = new NetworkSearchTree();
			
			//Displays the output using the timing methods from bst
			System.out.print("PreOrder Traverse:\t");
			nst.preOrdertraverseTiming();
			System.out.println();
			System.out.print("InOrder Traverse:\t");
			nst.inOrdertraverseTiming();
			System.out.println();
			System.out.print("PostOrder Traverse:\t");
			nst.postOrdertraverseTiming();
			System.out.println(); 
		}
}
