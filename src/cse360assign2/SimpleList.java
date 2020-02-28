package cse360assign2;

import java.lang.*;	

// I don't know how to do defines in java (I'm a C++ programmer)
// So magic numbers everywhere.

/**
 * This class contains a wrapping list of integers.
 * @author Brandan Tyler Lalsey
 * 
 */
public class SimpleList
{
	/**
	* This constructs a empty SimpeList of size 0.	
	*/
	SimpleList()
	{
		numArray =  new int[10];
		count = 0;
	}
	
	/**
	 * This adds an integer to the SimpleList class.
	 * @param Integer to add to the SimpleList
	 */
	public void add(int num)
	{
        if (count < 10)
        {
        	count++;
        }
		
        // Free up index 0
		// This should destroy index 9
		// We start at 8 because 8 + 1 = 9 which is the 
		// max size of the array (arrays start at 0)
		if (count > 1)
		{
        	for( int index = count-1; index >= 1 ; index-- )
        		numArray[index] = numArray[index - 1];
		}
        
        // Add num to the front of the array.
        numArray[0] = num; 
	}
	
	/**
	 * The number of elements in SimpleList
	 * @return Integer
	 */
	public int count()
	{
		return count;
	}
	
	/**
	 * Removes an interger from the SimpleList
	 * @param Integer to remove
	 */
	public void remove(int thing)
	{
		// I don't know what the instructions mean by 
		// "other values in the list may need to be moved down"
		// What direction is down to 0 or to 10?
		// So I'm just going to shift everything left over by 1.
		
		// Such that
		// 0, 1, 2, 3, 4 ,5
		//       ^ if we delete 2
		
		// 2 will become 0
		// 0, 1, 0, 3, 4, 5
		//       ^ Zero
		
		// Then we shift everything over by 1.
		// 0, 1, 3, 4, 5, 0
		//                ^ Our deleted element. 
		
		// Do that when we add something the 0
		// gets dropped off.
		
		int idx = search(thing);
		
		if (idx >= 0)
		{	
			// Shift 0 to the end of the list.
			for (int i = idx; i < count-1; i++)
			{
				numArray[i] = numArray[i + 1];
			}
			
			numArray[count-1] = 0;
			
			if (count != 0)
			{
				count--;
			}
		}
		// Else the item doesn't exist in the array.
	}
	
	/**
	 * Searches SimpleList for Integer 
	 * @param thing Integer to find
	 * @return Integer index of found element or -1 if not found.
	 */
	public int search(int thing)
	{
		int found_idx = -1;
		for (int i = 0; i < count; i++)
		{
			if (numArray[i] == thing)
			{
				found_idx = i;
				break;
			}
		}
		return found_idx;
	}
	
	/**
	 * @return
	 */
	public String toString()
	{
		String ret = new String();
		
		for (int i = 0; i < count; i++)
		{
			ret += String.valueOf(numArray[i]);
			if (i != count-1)
			{
				ret += " ";
			}
		}
		return ret;
	}

	private int count;
	private int numArray[];
}
