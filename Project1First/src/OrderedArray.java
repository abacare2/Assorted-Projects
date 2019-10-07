/*
 * A class that contains methods to construct an ordered array.
 */
public class OrderedArray 
{
	public IndexRecord[] orderedArray;
	public int length;
	public int max;
	public int position = 0;
	
	public OrderedArray() // no argument constructor
	{
		orderedArray = new IndexRecord[10];
		length = 0;
		max = 10;
	}
	
	public OrderedArray(int size) //Constructor for creating the array
	{
		orderedArray = new IndexRecord[size];	//initialize the array 
		length = 0;								//remains 0 because nothing has been added.
		max = size;								//We don't want to exceed the length of the array
	}
	
	//I originally thought the IndexIterator was a part of the ordered array class, not it's own class.
//	public void iteratorInitFront()		//set the iterator to 0
//	{
//		iterator = 0;
//	}
//	public void iteratorInitBack()		//set the iterator to the last element in the array
//	{
//		iterator = orderedArray.length-1;
//	}
//	public boolean hasNext()			//return true if the iterator <= points to the last element in the array
//	{
//		if(iterator <= orderedArray.length-1)
//			return true;
//		else
//			return false;
//	}
//	public boolean hasPrevious()		//return true if iterator > 0
//	{
//		if(iterator > 0)
//			return true;
//		else
//			return false;
//	}
//	public int getNext()				//return the where component of the IndexRecord, then increments iterator.
//	{
//		iterator++;
//		return orderedArray[iterator-1].getPosition();
//	}
//	public int getPrevious()			//return the where component of the IndexRecord, then decrements iterator.
//	{
//		iterator--;	
//		return orderedArray[iterator+1].getPosition();
//	}
	//Insertions must maintain the order in the array, by key value.
	
	public boolean addIndex (IndexRecord r) //add a record in order.
	{
		if(length == 0)
		{
			orderedArray[0]=r;
			return true;
		}
		if(length+1 <= max)
		{
			int j;
			for(j=0; j<11; j++)
			{
				if(r.compareTo(orderedArray[j])> 0)//Compare lexicographically. if the argument is earlier in the alphabet, the value will be positive. this means the new record goes after the current
				{
					orderedArray[j+1] = r;		//inserting the new record later in the array to maintain alphabetical order
					length++;
				}
				else
				{
					orderedArray[j+1] = orderedArray[j];	//current record goes after the new record
					orderedArray[j] = r;
					length++;
				}
			}
			return true;
		}
		else
			return false;	//array is full
	}
	
	public int getPosition()
	{
		if (length < max)
		{
			return length+1;		//add one because the first position in the array is 0;
		}
		else
			return length;
	}

}