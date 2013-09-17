package code;

import java.util.List;

public class InsertionSort 
{

	public InsertionSort() 
	{	
		// TODO Auto-generated constructor stub
	}

	public List<Integer> sort(List<Integer> inputArray)
	{		
		int i=0, j=0;
		Integer key = new Integer(0);
		int inputSize = inputArray.size();
		
		for(j=1; j<inputSize; j++)
		{
			key = inputArray.get(j);
			i = j-1;
			
			while (i>-1 && (inputArray.get(i)).compareTo(key) > 0)
			{
				inputArray.set(i+1, inputArray.get(i));
				i = i-1;
			}
			inputArray.set(i+1, key);
		}
		
		return inputArray;
	}
}
