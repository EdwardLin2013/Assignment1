package code;

import java.util.ArrayList;
import java.util.List;

public class MergeSort 
{
	public MergeSort() 
	{
		// TODO Auto-generated constructor stub
	}

	public List<Integer> sort(List<Integer> inputArray)
	{
		if(inputArray.size() == 1)
			return inputArray;
		else
		{
			List<Integer> left = inputArray.subList(0, inputArray.size()/2);
			List<Integer> right = inputArray.subList((inputArray.size()/2), inputArray.size());
			
			return Merge(this.sort(left), this.sort(right));
		}
	}

	private List<Integer> Merge(List<Integer> left, List<Integer> right) 
	{
		int i=0,j=0;
		ArrayList<Integer> retval = new ArrayList<Integer>();
		
		while( i<left.size() && j<right.size() )
		{
			if( (left.get(i)).compareTo(right.get(j)) < 0 )
			{
				retval.add(left.get(i));
				i++;
			}
			else
			{
				retval.add(right.get(j));
				j++;
			}				
		}
		
		while( i<left.size() ) // Copy the remaining left
		{
			retval.add(left.get(i));
			i++;
		}
		
		while( j<right.size() ) // Copy the remaining right
		{
			retval.add(right.get(j));
			j++;
		}
		
		return retval;
	}
}
