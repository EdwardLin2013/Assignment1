package code;

import java.util.Collections;
import java.util.List;

public class HeapSort 
{	
	int length;
	int heapSize;
	
	public HeapSort() 
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
		
		buildMaxHeap(inputArray);
		for(i=length-1; i>0; i--)
		{
			Collections.swap(inputArray, 0, i);
			heapSize--;
			maxHeapify(inputArray, 0);
		}
		
		return inputArray;
	}

	private void buildMaxHeap(List<Integer> inputArray) 
	{
		for(int i=inputArray.size()/2; i>-1; i--)
			maxHeapify(inputArray, i);
	}
	
	private void maxHeapify(List<Integer> inputArray, int i) 
	{
		int l = left(i);
		int r = right(i);
		int largest = 0;
		
		if( l<heapSize )
		{
			if( inputArray.get(l) > inputArray.get(i) )
				largest = l;
			else
				largest = i;
		}
		else
			largest = i;
		
		if ( r<heapSize )
		{
			if( inputArray.get(r) > inputArray.get(largest))
				largest = r;
		}
		
		if( largest != i )
		{
			Collections.swap(inputArray, i, largest);
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
