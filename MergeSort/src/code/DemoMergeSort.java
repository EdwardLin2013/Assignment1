package code;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DemoMergeSort 
{

	public static void main(String[] args) throws IOException
	{
		ArrayList<Integer> inputArray = new ArrayList<Integer>();
		ArrayList<Integer> outputArray = new ArrayList<Integer>();
		MergeSort engine = new MergeSort();
		int i=0;
		
		if(args.length != 2 || args[0].equalsIgnoreCase("help"))
		{
			System.out.println("Argument is empty! Please provide the path of the input.txt");
			System.out.println("MergeSort Path/to/input.txt Path/to/output.txt");
			return;
		}
		
		// Get an array of number from input.txt
		/*
		 *  input.txt assumption:
		 *  1) all numbers are integer
		 *  2) one line only has one number
		 *  3) number should not out of the range of int data type
		 *  4) args[0] provide the path of input.txt
		 */
		Scanner sc = new Scanner(new File(args[0]));
		while (sc.hasNextInt())
		{
			inputArray.add(new Integer(sc.nextInt()));
		}
		sc.close();
		
		// Sort the numbers
		long startTime=0, endTime=0;
		System.out.println("Start to do the Insertion Sort, and the Current Time is " + (startTime=System.nanoTime()));
		outputArray = (ArrayList<Integer>) engine.sort(inputArray);
		System.out.println("Finish the Sorting, and the End time is " + (endTime=System.nanoTime()));
		System.out.println("Total Execution Time is " + (endTime-startTime) + " nanoseconds");
		
		// Output the result to output.txt
		FileOutputStream fos = new FileOutputStream(args[1]); 
		OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8");
		for(i=0; i<outputArray.size(); i++)
			out.write(outputArray.get(i).toString() + "\n");
		out.close();
	}
}
