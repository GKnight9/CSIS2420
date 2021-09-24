package practice2420;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Week2Part2 {
	public static void main(String[] args) throws IOException {
		
		File fileName = new File ("C:\\Data\\Week2Part2.txt");
			
	 	if (fileName.exists()) {
            BufferedReader br = null;
            String line = "";
            String cvsSplitBy = " ";
            int recordCount = 0;
            
            float sum = 0;
	    br = new BufferedReader(new FileReader(fileName));
	    System.out.println("--------------------------------------------------------------");
	    System.out.println("Number List");
	    System.out.println("--------------------------------------------------------------");
	    System.out.println("Amount");
	    System.out.println("--------------------------------------------------------------");
	    
	    while ((line = br.readLine()) != null) {
	    String[] customer = line.split(cvsSplitBy);
		float f = Float.parseFloat(customer[0]);
		System.out.println(f);
		if (f >= 0) {
			sum += f;
		}
	
	
			recordCount++;
	    }
	    System.out.println("--------------------------------------------------------------");
	    System.out.printf("Number of records: %d%n", recordCount);
	    System.out.println("--------------------------------------------------------------");
	    System.out.printf("Sum of records: %,.2f%n", sum);
	    System.out.println("--------------------------------------------------------------");
	    System.out.printf("Average of records: %,.2f%n", sum/recordCount);
	    System.out.println("--------------------------------------------------------------");
            br.close();
    	}
	}
}


