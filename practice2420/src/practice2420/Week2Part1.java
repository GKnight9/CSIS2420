/**
 * Garrett Knight
 * CSIS 2420
 * Week2 part 1 Assignment
 * 
 */
package practice2420;


import java.util.Scanner;

public class Week2Part1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int[][] gameScores = new int[][] {
			      	 {44,63,45,23,76,45},
			    	 {76,23,56,98,33,24},
			    	 {23,71,92,39,45,44},
			    	 {70,20,46,64,77,29},
			    	 {83,45,99,20,10,21},
			    	 {86,34,92,34,88,11}
			    };
		int min;
		int max;
		int total = 0;
		
		//Adds the integers between the min and max value
		System.out.print("Enter min number: ");
		min = input.nextInt();
		System.out.print("Enter max number: ");
		max = input.nextInt();
		
		for (int i = min; i <= max; i++) {
			total = total + i;
			}
		
		System.out.printf("\nTotal: %,d", total);
		input.close();
		System.out.print("\n\n");
		
		//Calculates scores of the gameScore array
		int numGames = gameScores[1].length -1;
		int gameScoreTotal = 0;
		int highScore = 0;
		printHeader();
		for (int i = 0; i < gameScores.length; i++) {
			int rSum = 0;
			
			for (int j = 0; j <= numGames; j++) {
				if (j == 0) {
				System.out.print("Row " + (i + 1) + ": \t" + gameScores[i][j] + " ");
				}
				
				else {
			    System.out.print(gameScores[i][j] + " ");
			  
				}  
				gameScoreTotal +=  gameScores[i][j];
				rSum +=  gameScores[i][j];
				if (rSum > gameScores[i][j]) {
					highScore = rSum;
				}
			}
			System.out.print("\t" + rSum + "\n");
			
		}	
			printFooter(gameScoreTotal, highScore);	
	}
	
	//Displays the gameScore header
	 private static void printHeader() {
	    System.out.println();
	    printLine(62);
	    System.out.println("Total Scores");
	    printLine(62);
	    System.out.println("Row ID\tScores\t\t\tTot");
	    printLine(62);
	  }
	 
	 //Displays gameScore footer
	 private static void printFooter(int gameScoreTotal, int highScore) {
	    printLine(62);
	    System.out.println("High Score: \t\t\t"	+ highScore);
	    printLine(62);
	  }
	 
	 //Prints dashes for the header and footer
	  private static void printLine(int dashes) {
	    for (int i = 1; i <= dashes; i++)
	    {
	      System.out.print("-");
	    }
	      System.out.print("\n");
	    }
}



