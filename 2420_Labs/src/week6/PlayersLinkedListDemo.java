package week6;
/**
 * @ Garrett Knight
 * CSIS 2420
 * Week 6 Assignment
 * This is the main program class that displays the output from csv file
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class PlayersLinkedListDemo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// Instantiates the linked list
		PlayersLinkedList Pll = new PlayersLinkedList();
			//Allows user input
			Scanner input = new Scanner(System.in);
			Random rand = new Random();
		    //Commands for options menu 
            int choice;
            boolean quit = false;
            //Reads csv file
            File playerList = new File ("C:\\Data\\Players.csv");
    		BufferedReader br = null;
                String line = "";
                String splitBy = ",";
               
    	    br = new BufferedReader(new FileReader(playerList));
    		 
    	   while ((line = br.readLine()) != null) {
    		    
    		   String[] player = line.split(splitBy);
    		    int playerID = Integer.parseInt(player[0]);
    		    String firstName = player[1];
    		    String lastName = player[2];
    		    String playerName = player[3];
    		    String playerType = player[4];
    		    double lifePoints =Double.parseDouble(player[5]);
    		    int totalLifeScore = Integer.parseInt(player[6]);
    		    Pll.append(playerID, firstName, lastName, playerName, playerType, 
    		    		lifePoints, totalLifeScore);
    		    
    	   }
    	   
           
	    	Pll.printLine(100);
			System.out.println("OPTIONS MENU");
	    	do {
	    	
	    	//The options menu prompts the user to select what information they want to see from the list	
	    	optionMenu();
	    	choice = input.nextInt();
	    		switch (choice) {
	    		
	    			case 1:
	    				//Displays the full list of players in the game
	    				Pll.printPlayerList();
	    				
	    				break;
	    			case 2:
	    				//Prompts the user to add a new player in the game
	    				int max = 9999;
	    				int min = 1000;
	    				String fn;
	    				String ln;
	    				String pn;
	    				String pt;
	    				double lp = 0;
	    				int LS = 0;
	    				input.nextLine();
	    				Pll.printLine(35);
	    				System.out.println("a) Enter First Name: ");
	    				fn = input.nextLine();
	    				System.out.println("b) Enter Last Name: ");
	    				ln = input.nextLine();
	    				System.out.println("c) Create Player Name: ");
	    				pn = input.nextLine();
	    				System.out.println("d) Choose Class: ");
	    				pt = input.nextLine();
	    			    int plID = rand.nextInt((max - min) + 1) + min;
	    			    
	    			    Pll.prepend(plID, fn, ln, pn, pt, lp, LS);
	    			    System.out.println();
	    			    Pll.printLine(100);
	    			    System.out.printf("%s Enters the Quest!\n", pn);
	    			    playerAttributes();
	    				System.out.printf("%d\t%s%s%s%s%.2f\t\t%d\n", plID, 
	    						fn + (fn.length() > 7 ? "\t" : "\t\t"), 
	    						ln + (ln.length() > 7 ? "\t" : "\t\t"), 
	    						pn + (pn.length() > 7 ? "\t" : "\t\t"),
	    						pt + (pt.length() > 7 ? "\t" : "\t\t"), 
	    						lp, LS);
	    					
	    				break;
	    			case 3:	
	    				//Prompts user to remove a player from the game by entering playerID 
	    				int mx = 9999;
	    				int mn = 1000;
	    				int pID;
	    				
	    				Pll.printLine(35);
	    				System.out.println("Choose a player to remove: ");
	    				pID = input.nextInt();
	    				if (pID >= mn && pID <= mx) {
			
	    					Pll.delete(pID);
	    					Pll.printLine(62);
	    					System.out.println("Player " + pID + " leaves quest");
	    					Pll.printLine(62);
	    				}
	    				else {
	    					
	    					System.out.println("Error: Enter valid PlayerID number");
	    				}
	    			
	    				break;
	    			case 4:
	    				//Displays the current legnth of the list
	    				System.out.print("Number of Players: ");
	    				System.out.print(Pll.length());
	    				System.out.println("\s");
	    				
	    				break;
	    			case 5: 
	    				//Allows user to look up a player by searching their playerID
	    				int playerNum = 0;
	    				System.out.println("Enter PlayerID: ");
	    				playerNum = input.nextInt();
	    				playerAttributes();
	    				System.out.println(Pll.searchReturnString(playerNum));
	    				
	    				break;
	    			case 6:
	    				//Allows user to look up a player by entering their first and last name
	    				String f = null;
	    				String l = null;
	    				input.nextLine();
	    				System.out.println("Enter First Name: ");
	    				f = input.nextLine();
	    				System.out.println("Enter Last Name: ");
	    				l = input.nextLine();
	    				playerAttributes();
	    				System.out.println(Pll.searchReturnString(f, l));
	    				
	    				break;
	    			case 7:
	    				//Allows user to look up a player by searching their player name
	    				String gameName = null;
	    				input.nextLine();
	    				System.out.println("Enter Player Name: ");
	    				gameName = input.nextLine();
	    				playerAttributes();
	    				System.out.println(Pll.searchReturnString1(gameName));
	    				
	    				break;
	    			case 8:
	    				//Allows user to find player by their class
	    				String plType= null;
	    				 
	    				input.nextLine();
	    				System.out.println("Enter Class Name: ");
	    				plType = input.nextLine();
	    				playerAttributes();
	    				
	    				System.out.println(Pll.searchReturnString(plType));
	    				
	    				
	    				break;	
	    			case 9:
	    				//Displays the current high score
	    				LS =0;
	    			
	    				Pll.printLine(62);
	    				System.out.println("High Score: \t\t\t"	+ Pll.highScore(LS));
	    				Pll.printLine(62);
	    			//	highestScore();
	    				break;
	    			case 10:
	    				//Displays the current bottom score
	    				int lScore = 0;
	    				Pll.printLine(62);
	    				System.out.println("Low Score: \t\t\t"	+ Pll.lowScore(lScore));
	    				Pll.printLine(62);
	    				//lowestScore();
	    				break;
	    			case 0: 
	    				//Ends the loop
	    				quit = true;
	    				break;
	    			default:
	    				
	    				System.out.println("\nInvalid Entry\n");
	    			
	    	}
	    }
	    while(!quit);	
		br.close();
		System.out.println("\nBye Bye!");
		input.close();
	}
	//Prompts the user to enter commands from the  options menu
	private static void optionMenu() {
		
		PlayersLinkedList Pll = new PlayersLinkedList();
		
		Pll.printLine(35);
		System.out.println("1. Display Players List");
		System.out.println("2. Add Player");
		System.out.println("3. Delete Player");
		System.out.println("4. Number of Players");
		System.out.println("5. Search by PlayerID");
		System.out.println("6. Search by Player's Real Name");
		System.out.println("7. Search by Player's Game Name");
		System.out.println("8. Search by Class");
		System.out.println("9. High Score");
		System.out.println("10. Low Score");
		System.out.println("0. Exit");
		Pll.printLine(35);
		System.out.print("Select Options 1-10 or 0 to quit: ");
		System.out.println("\n");
	}
	//Displays player's attributes when a player is added or looked up from one of the search options
	private static void playerAttributes() {
		
		PlayersLinkedList Pll = new PlayersLinkedList();
		
		Pll.printLine(100);
		System.out.println("PlyrID\tFirst Name\tLast Name\tPlayer Name\tClass\t\tLP\t\tLife Score");
		Pll.printLine(100);
	}
}


