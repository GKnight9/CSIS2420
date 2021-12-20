package theNetworkTree;
/**
 * 
 * @author Garrett Knight
 * CSIS 2420
 * Weeks 9 - 10 Assignment #2
 * This is the node class assigning the values used in the Network Search Tree
 */
public class NetworkNode {
	
	int ip;
	String user;
	NetworkNode left;
	NetworkNode right;
	
	public NetworkNode(int ip, String user) {
		
		this.ip = ip;
		this.user = user;
	}

}
