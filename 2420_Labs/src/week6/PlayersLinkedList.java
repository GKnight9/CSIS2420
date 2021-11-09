package week6;

/**
 * 
 * @author Garrett Knight
 * CSIS 2420
 * Week 6 Assignment
 * Here is the Linked List Class assigning the methods
 */
public class PlayersLinkedList {
	
	PlayerNode head;

	public void append (int playerID, String firstName, String lastName, String playerName,
			String playerType, double lifePoints, int totalLifeScore) {
		
		if (head == null) {
			head = new PlayerNode (playerID, firstName, lastName, playerName, playerType, lifePoints, 
					totalLifeScore);
			return;
		}
		PlayerNode current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new PlayerNode (playerID, firstName, lastName, playerName,  
				playerType, lifePoints, totalLifeScore);
	}
	public void delete(int playerID) {
		
		PlayerNode current = head;
		PlayerNode previous = null;
		if (head != null && current.playerID == playerID) {
			head = current.next;
			return;
		}
		while (current != null && current.playerID != playerID) {
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
		PlayerNode current = head;
		while (current != null) {
			
			len++;
			current = current.next;
		}
		return len;

	}
	public void prepend(int playerID, String firstName, String lastName, String playerName, 
			String playerType, double lifePoints, int totalLifeScore) {
		
		PlayerNode newHead = new PlayerNode(playerID, firstName, lastName, playerName,  playerType, 
				lifePoints, totalLifeScore);
		newHead.next = head;
		head = newHead;
	}
	public void printPlayerList() {
		PlayerNode current = head;
		System.out.println();
		printLine(100);
		System.out.print("P L A Y E R   L I S T\n");
		printLine(100);
		System.out.println("PlyrID\tFirst Name\tLast Name\tPlayer Name\tClass\t\tLP\t\tLife Score");
		printLine(100);
		while (current != null) {
			System.out.printf("%d\t%s%s%s%s%.2f\t\t%d\n", current.playerID , 
			current.firstName + (current.firstName.length() > 7 ? "\t" : "\t\t"), 
			current.lastName + (current.lastName.length() > 7 ? "\t" : "\t\t"), 
			current.playerName + (current.playerName.length() > 7 ? "\t" : "\t\t"),
			current.playerType + (current.playerType.length() > 7 ? "\t" : "\t\t"), 
			current.lifePoints, current.totalLifeScore);
			current = current.next;
		}
	}
	public String searchReturnString(int playerID) {
	    
		String result = "ID number not found";
		if (head == null) return "List Empty";
		PlayerNode current = head;
		if (head.playerID == playerID) {
				result = head.playerID
			            + "\t" + head.firstName + (head.firstName.length() > 7 ? "\t" : "\t\t")
			            + head.lastName + (head.lastName.length() > 7 ? "\t" : "\t\t")
			            + head.playerName + (head.playerName.length() > 7 ? "\t" : "\t\t")
			            + head.playerType + (head.playerType.length() > 7 ? "\t" : "\t\t")
			            + head.lifePoints + "\t\t" + head.totalLifeScore;
		}
		else {
			while (current.next != null) {
				if (current.next.playerID == playerID) {
					result = current.next.playerID
		               + "\t" + current.next.firstName + (current.next.firstName.length() > 7 ? "\t" : "\t\t")
		                    + current.next.lastName + (current.next.lastName.length() > 7 ? "\t" : "\t\t")
		                    + current.next.playerName + (current.next.playerName.length() > 7 ? "\t" : "\t\t")
		                    + current.next.playerType + (current.next.playerType.length() > 7 ? "\t" : "\t\t")
		                    + current.next.lifePoints + "\t\t" + current.next.totalLifeScore;
					break;
				}
				current = current.next;
			}
		}
		return result;
	}
	
	public String searchReturnString(String firstName, 
			String lastName) {
		
		String result = "Player not found";
	    if (head == null) return "List Empty";
	    PlayerNode current = head;
	    if (head.firstName.equalsIgnoreCase(firstName) && 
	    	head.lastName.equalsIgnoreCase(lastName)) {
	    	result = head.playerID
	            + "\t" + head.firstName + (head.firstName.length() > 7 ? "\t" : "\t\t")
	            + head.lastName + (head.lastName.length() > 7 ? "\t" : "\t\t")
	            + head.playerName + (head.playerName.length() > 7 ? "\t" : "\t\t")
	            + head.playerType + (head.playerType.length() > 7 ? "\t" : "\t\t")
	            + head.lifePoints + "\t\t" + head.totalLifeScore;
	    }
	    else {
	        while (current.next != null) {
	            if (current.next.firstName.equalsIgnoreCase(firstName) && 
	            	current.next.lastName.equalsIgnoreCase(lastName)) {
	                result = current.next.playerID
	                    + "\t" + current.next.firstName + (current.next.firstName.length() > 7 ? "\t" : "\t\t")
	                    + current.next.lastName + (current.next.lastName.length() > 7 ? "\t" : "\t\t")
	                    + current.next.playerName + (current.next.playerName.length() > 7 ? "\t" : "\t\t")
	                    + current.next.playerType + (current.next.playerType.length() > 7 ? "\t" : "\t\t")
	                    + current.next.lifePoints + "\t\t" + current.next.totalLifeScore;
	                break;
	            }
	            current = current.next;
	        }
	    }
	    return result;
	}
	public String searchReturnString1(String playerName) {
	    
		String result = "Player not found";
	    if (head == null) return "List Empty";
	    PlayerNode current = head;
	    if (head.playerName.equalsIgnoreCase(playerName)) {
	    	result = head.playerID
	            + "\t" + head.firstName + (head.firstName.length() > 7 ? "\t" : "\t\t")
	            + head.lastName + (head.lastName.length() > 7 ? "\t" : "\t\t")
	            + head.playerName + (head.playerName.length() > 7 ? "\t" : "\t\t")
	            + head.playerType + (head.playerType.length() > 7 ? "\t" : "\t\t")
	            + head.lifePoints + "\t\t" + head.totalLifeScore;
	    }
	    else {
	        while (current.next != null) {
	            if (current.next.playerName.equalsIgnoreCase(playerName)) {
	                result = current.next.playerID
	                    + "\t" + current.next.firstName + (current.next.firstName.length() > 7 ? "\t" : "\t\t")
	                    + current.next.lastName + (current.next.lastName.length() > 7 ? "\t" : "\t\t")
	                    + current.next.playerName + (current.next.playerName.length() > 7 ? "\t" : "\t\t")
	                    + current.next.playerType + (current.next.playerType.length() > 7 ? "\t" : "\t\t")
	                    + current.next.lifePoints + "\t\t" + current.next.totalLifeScore;
	                break;
	            }
	            current = current.next;
	        }
	    }
	    return result;
	}
	public String searchReturnString(String playerType) {
		
		String result = "Class not found";
	    if (head == null) return "List Empty";
	    PlayerNode current = head;
	   if (head.playerType.equalsIgnoreCase(playerType)) {
	    	result = head.playerID
	            + "\t" + head.firstName + (head.firstName.length() > 7 ? "\t" : "\t\t")
	            + head.lastName + (head.lastName.length() > 7 ? "\t" : "\t\t")
	            + head.playerName + (head.playerName.length() > 7 ? "\t" : "\t\t")
	            + head.playerType + (head.playerType.length() > 7 ? "\t" : "\t\t")
	            + head.lifePoints + "\t\t" + head.totalLifeScore;
	    }
	    else {
	        while (current.next != null) {
	            if (current.next.playerType.equalsIgnoreCase(playerType)) {
	                result = current.next.playerID
	                    + "\t" + current.next.firstName + (current.next.firstName.length() > 7 ? "\t" : "\t\t")
	                    + current.next.lastName + (current.next.lastName.length() > 7 ? "\t" : "\t\t")
	                    + current.next.playerName + (current.next.playerName.length() > 7 ? "\t" : "\t\t")
	                    + current.next.playerType + (current.next.playerType.length() > 7 ? "\t" : "\t\t")
	                    + current.next.lifePoints + "\t\t" + current.next.totalLifeScore;
	                break;
	            }
	             
	            current = current.next; 
	        }
	    }
	    return result;
	}
	//High Score method resets the Player's list for some reason
	public int highScore(int totalLifeScore) {
		
		int highScore = Integer.MIN_VALUE;
		while (head != null) {
		
			if (highScore < head.totalLifeScore) 
				highScore = head.totalLifeScore;
				head = head.next;
			
			}
			return highScore;
	}
	//Low Score method resets the Player's list for some reason
	public int lowScore(int totalLifeScore) {
		
		int lowScore = Integer.MAX_VALUE;
		while (head != null) {
		if (lowScore > head.totalLifeScore) 
			lowScore = head.totalLifeScore;
			head = head.next;
		}
		return lowScore;
		
	}
	public void printLine(int n) {
		
		for (int i = 1; i <= n; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
}
