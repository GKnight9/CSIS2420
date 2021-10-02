package searching;

/**
 * 
 * @author Garrett Knight
 * CSIS 2420
 * Week 3 Part 2
 * 
 */
import java.util.Arrays;
import java.util.Random;

public class  BinarySearch {
	
  public static void main(String[] args) {
	  
    int memoryConsumption = 0;
    int min = 10000;
    int max = 99999;
    int numElements = 100; //Number of elements can be tested with different incremented values
    Random rand = new Random();
    int dataArray[] = new int[numElements];
    Arrays.sort(dataArray); 
    memoryConsumption = (4 * dataArray.length) + 24 + 8;
    int result = binarySearch(dataArray, numElements);
    for (int i = 0; i < dataArray.length; i++) {
    	
        dataArray[i] = (rand.nextInt((max - min) + 1) + min);
    }
    if (result > -1) {
    
    System.out.printf("%n%d elements: %,d comparisons", numElements, result);
	
    }
}
  //Returns comparisons using binary search
  static int binarySearch(int searchArray[], int seekValue) {
	
	int compares = 0;  
    int low = 0;
    int high = searchArray.length - 1;
    while (low <= high) {
    	compares++;
    	int mid = low + (high- low) / 2;
        if (searchArray[mid] == seekValue)
            return mid;
        if (searchArray[mid] < seekValue)
        	low = mid + 1;
        else
        	high = mid - 1;
    }
	return compares;
  }

}