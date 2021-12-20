package hashing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HashingDemo1 {
	/*
		hashArray[0] -> Barnes 
		hashArray[1] -> Andrews -> Mathison -> Jones
		hashArray[2] -> Yates   -> Carlson
	*/
	
	public static String[] dataArray = new String[] {"Yates","Andrews","Barnes","Mathison","Jones","Carlson"};
	public static int[] customerIDsArray = new int[] {1111, 2222, 3333, 4444, 5555, 6666};
	public static HashNode hashArray[] = new HashNode[3];
	int nanoDivisor = 1000000000;
	public static void main(String[] args) throws IOException {
		File userList = new File ("C:\\Data\\HashingDemoDataFile.csv");
    	BufferedReader br = null;
        String line = "";
        String splitBy = ",";
       
        br = new BufferedReader(new FileReader(userList));
    
        while ((line = br.readLine()) != null) {
	    
        	String[] user = line.split(splitBy);
        	int customerID = Integer.parseInt(user[0]);
        	String name = user[1]; 
        	
        } 
        br.close();
		displayDataArray();
		displayHashExampleOutput();
		for (int j = 0; j < dataArray.length; j++)
		{
			appendNode(hashIt(dataArray[j]), customerIDsArray[j], dataArray[j]);
		}
		displayHashArray();
		
	}
	
	private static void displayHashExampleOutput() 
	{
		int asciiTotal = 0;
		for (int j = 0; j < dataArray.length; j++)
		{
			for (int k = 0; k < dataArray[j].length(); k++)
			{
				char c = dataArray[j].charAt(k);
				System.out.println(c + "  " + (int)c);
				asciiTotal = asciiTotal + (int)c;
			}
			System.out.print("asciiTotal: " + asciiTotal);
			System.out.println("\t[" + asciiTotal % hashArray.length + "]\n");
			asciiTotal = 0;
		}
		
	}

	private static void displayDataArray() 
	{
		for (int i = 0; i < dataArray.length; i++)
		{
			System.out.printf("dataArray[%d]: %s%n", i, dataArray[i]);
		}
		System.out.println();
		for (int i = 0; i < customerIDsArray.length; i++)
		{
			System.out.printf("customerIDsArray[%d]: %s%n", i, customerIDsArray[i]);
		}
		System.out.println();
	}

	public static int hashIt(String data)
	{
		int asciiTotal = 0;
		for (int n = 0; n < data.length(); n++)
		{
			char c = data.charAt(n);
			asciiTotal = asciiTotal + (int)c;
		}
		return asciiTotal % hashArray.length;
	}
	
	public static void appendNode(int arrayIndex, int customerID, String name)
	{
		if (hashArray[arrayIndex] == null)
		{
			hashArray[arrayIndex] = new HashNode(customerID, name);
		}
		else
		{
			HashNode current = hashArray[arrayIndex];
			while (current.next != null)
			{
				current = current.next;
			}
			current.next = new HashNode(customerID, name);
		}
	}

	public static void displayHashArray()
	{
		for (int i = 0; i < hashArray.length; i++)
		{
			System.out.printf("hashArray[%d]", i);
			if (hashArray[i] != null)
			{
				HashNode current = hashArray[i];
				System.out.printf(" -> [%d][%s]", current.customerID, current.lastName);
				while (current.next != null)
				{
					current = current.next;
					System.out.printf(" -> [%d][%s]", current.customerID, current.lastName);
				}
			}
			System.out.println();
		}
	}
	private void search(String Mathison)
    {
        //Compute the index by using the hash function
        int index = hashIt(Mathison);int customerID; String name;
        //Search the linked list at that specific index
        for(int i = 0;i < hashArray[index].size();i++)
        {	
        	
        	HashNode current = hashArray[i];
            if(hashArray[index][i] == Mathison)
            {
            	customerID << Mathison << " is found!" << Mathison;
                return;
            }
            else { 
            	customerID << Mathison << " is not found!" << name;
            }
        }
        timeHash();
    }
	public void timeHash() {
		long start = System.nanoTime();
		displayHashExampleOutput();
		displayHashArray();
		long end = System.nanoTime();	
		long duration = end - start;
	double seconds = (double)duration/nanoDivisor;
	System.out.printf("\nDuration: %,d nanoseconds [%.10f seconds]%n", duration, seconds);
	}
}
