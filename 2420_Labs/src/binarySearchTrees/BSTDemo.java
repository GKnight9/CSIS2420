package binarySearchTrees;
/**
 * @author Garrett Knight
 * CSIS 2420 
 * Weeks 9 - 10 Assignment #1
 * The main class that prompts the user to input the number of nodes on a tree
 */
import java.util.Random;
import java.util.Scanner;

public class BSTDemo 
{
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		BinarySearchTree bst = new BinarySearchTree();
		//The minimal and maximal values that can be displayed in a tree
		int min = 10;
	    int max = 999;
	    int branches;
	    int randomNumber;
	    randomNumber = rand.nextInt((max - min) + 1) + min;
	    branches = randomNumber;
	    //Prompts user to enter how many nodes the tree should contain
	    System.out.println("Number of nodes: ");
	    branches = input.nextInt();   
	    int [] x = new int [branches];
		// Sample Data: 20, 33, 18, 19, 46, 29, 4, 62
	    for (int i = 1; i  <= x.length; i++) {
		
	    	bst.insert(rand.nextInt(randomNumber));
	    }	
	   	input.close();
	   	//Displays the output using the timing methods from bst
		System.out.print("PreOrder Traverse:\t");
		bst.preOrdertraverseTiming();
		System.out.println();
		System.out.print("InOrder Traverse:\t");
		bst.inOrdertraverseTiming();
		System.out.println();
		System.out.print("PostOrder Traverse:\t");
		bst.postOrdertraverseTiming();
		System.out.println(); 
	}
}