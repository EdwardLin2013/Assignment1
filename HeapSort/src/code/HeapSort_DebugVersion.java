package code;

import java.util.Collections;
import java.util.List;

public class HeapSort_DebugVersion 
{	
	int length;
	int heapSize;
	
	public HeapSort_DebugVersion() 
	{
		// TODO Auto-generated constructor stub
		length=0;
		heapSize=0;
	}

	public List<Integer> sort(List<Integer> inputArray)
	{
		int i=0;
		length = inputArray.size();
		heapSize = inputArray.size();
		
		System.out.println("sort: length: " + length + "; heapSize: " + heapSize);
		buildMaxHeap(inputArray);
		System.out.println("sort: finish building the heap");
		for(i=0; i<inputArray.size(); i++)
			System.out.print(inputArray.get(i) + " ");
		System.out.print("\n");
		

		for(i=length-1; i>0; i--)
		{
			System.out.println("sort: swap inputArray[0]: " + inputArray.get(0) + " with inputArray[" + i + "]: " + inputArray.get(i)); 
			Collections.swap(inputArray, 0, i);
			System.out.println("sort: now inputArray[0]: " + inputArray.get(0) + " with inputArray[" + i + "]: " + inputArray.get(i));
			heapSize--;
			System.out.println("sort: heapSize now: " + heapSize);
			maxHeapify(inputArray, 0);
		}
		
		return inputArray;
	}

	private void buildMaxHeap(List<Integer> inputArray) 
	{
		for(int i=inputArray.size()/2; i>-1; i--)
		{
			System.out.println("buildMaxHeap: i: " + i);
			maxHeapify(inputArray, i);
		}
	}
	
	private void maxHeapify(List<Integer> inputArray, int i) 
	{
		System.out.println("maxHeapify: i: " + i);
		
		int l = left(i);
		int r = right(i);
		int largest = 0;
		
		System.out.println("maxHeapify: l: " + l + "; r: " + r + "; heapSize: " + heapSize);
		if( l<heapSize )
		{
			System.out.println("maxHeapify: inputArray[" + l + "]: " + inputArray.get(l) + "; inputArray[" + i  + "]: " + inputArray.get(i));
			if( inputArray.get(l) > inputArray.get(i) )
				largest = l;
			else
				largest = i;
		}
		else
			largest = i;
		
		System.out.println("maxHeapify: largest: " + largest);
		if ( r<heapSize )
		{
			if( inputArray.get(r) > inputArray.get(largest))
				largest = r;
		}
		System.out.println("maxHeapify: largest: " + largest);
		
		if( largest != i )
		{
			System.out.println("sort: swap inputArray[i]: " + inputArray.get(i) + " with inputArray[largest]: " + inputArray.get(largest));
			Collections.swap(inputArray, i, largest);
			System.out.println("sort: swap inputArray[i]: " + inputArray.get(i) + " with inputArray[largest]: " + inputArray.get(largest));
			maxHeapify(inputArray, largest);
		}
	}
	private int left(int i) 
	{
		return i*2+1;
	}
	
	private int right(int i) 
	{
		return i*2+2;
	}
	
}
