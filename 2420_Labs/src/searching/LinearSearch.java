package searching;

/**
 * 
 * @author Garrett Knight
 * CSIS 2420
 * Week 3 Part 1
 * 
 */
import java.util.Random;

public class LinearSearch {
  
	public static void main(String[] args) {
	 
		int memoryConsumption = 0;
		int min = 10000;
		int max = 99999;
		int numElements = 100; //Number of elements can be tested with different incremented values
		Random rand = new Random();
		int dataArray[] = new int[numElements];
		memoryConsumption = (4 * dataArray.length) + 24 + 8;
		int result = linearSearch(dataArray, numElements);
		
		for (int i = 0; i < dataArray.length; i++) {
			
			dataArray[i] = (rand.nextInt((max - min) + 1) + min); 
		}		
		
		if (result > -1) {
		System.out.printf("%n%d elements: %,d comparisons", numElements, result);
		System.out.printf("\s%,d bytes", memoryConsumption);		
		}
	}

	//Returns comparisons using sequential search method
	static int linearSearch(int searchArray[], int elemValue) {
	   
	   int compares = 0;
	   int indexLocation = -1;
	   for (int i = 0; i < searchArray.length; i++) {
			 compares++;
	          if (searchArray[i] == elemValue)
	        	  indexLocation = i;
	   }
	   return compares;
	}
}

