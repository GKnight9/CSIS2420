package week6;
/**
 * 
 * @author Garrett Knight
 * CSIS 2420
 * Week 6 Assignment
 * This is the Node Class that supports the attributes from the csv file
 */
public class PlayerNode {
	
	PlayerNode next;
	
	int playerID;
	String firstName;
	String lastName;
	String playerName;
	String playerType;
	double lifePoints;
	int totalLifeScore;

    public PlayerNode(int playerID, String firstName, String lastName, String playerName, 
			String playerType, double lifePoints, int totalLifeScore) {
		
		this.playerID = playerID;
        this.firstName = firstName;
		this.lastName = lastName;
		this.playerName = playerName;
		this.playerType = playerType;
		this.lifePoints = lifePoints;
		this.totalLifeScore = totalLifeScore;
	}
}
