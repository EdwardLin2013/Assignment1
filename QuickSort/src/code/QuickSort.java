package code;

import java.util.Collections;
import java.util.List;

public class QuickSort 
{

	public QuickSort() 
	{
		// TODO Auto-generated constructor stub
	}

	public List<Integer> sort(List<Integer> inputArray, int p, int r)
	{
		int q=0;
		if(p<r)
		{
			q = partition(inputArray, p, r);
			this.sort(inputArray, p, q-1);
			this.sort(inputArray, q+1, r);
		}
		return inputArray;
	}

	private int partition(List<Integer> inputArray, int p, int r) 
	{
		Integer pivot = inputArray.get(r);
		int i = p-1;
		for(int j=p; j<r; j++)
		{
			if(inputArray.get(j).compareTo(pivot) <= 0)
			{
				i++;
				Collections.swap(inputArray, i, j);
			}
		}
		Collections.swap(inputArray, i+1, r);
		
		return i+1;
	}
}
