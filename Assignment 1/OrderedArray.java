
public class OrderedArray 
{
	public IndexRecord[] IndexIterator;
	public int length;
	public int max;
	public int iterator;
	
	public OrderedArray() // no argument constructor
	{
		Index Iterator = new IndexRecord[10];
		length = 0;
		max = 10;
	}
	
	public OrderedArray(int size) //Constructor for creating the array
	{
		IndexIterator = new IndexRecord[size];	//initialize the array 
		length = 0;								//remains 0 because nothing has been added.
		max = size;								//We don't want to exceed the length of the array
	}
	
	//setting up the iterator methods
	public void iteratorInitFront()		//set the iterator to 0
	{
		iterator = IndexIterator[0];
	}
	public void iteratorInitBack()		//set the iterator to the last element in the array
	{
		iterator = IndexIterator[IndexIterator.length-1];
	}
	public boolean hasNext()			//return true if the iterator <= points to the last element in the array
	{
		if(iterator <= IndexIterator.length-1)
			return true;
		else
			return false;
	}
	public boolean hasPrevious()		//return true if iterator > 0
	{
		if(iterator > 0)
			return true;
		else
			return false;
	}
	public int getNext()				//return the where component of the IndexRecord, then increments iterator.
	{
		if (iterator < IndexIterator.length-1)
		{
			return IndexIterator[iterator].getPosition;
			iterator++;
		}
		else 
			return null;
	}
	public int getPrevious()			//return the where component of the IndexRecord, then deccrements iterator.
	{
		if (iterator > 0)
		{
			return IndexIterator[iterator].getPosition;
			iterator--;
		}
		else 
			return null;
	}
	//Insertions must maintain the order in the array, by key value.
	
	public boolean addIndex (IndexRecord r) //add a record in order.
	{
		if(length+1 <= max)
		{
			int j;
			for(j=0; j<11; j++)
			{
				if(r.compareTo(IndexIterator[j])> 0)//Compare lexicographically. if the argument is earlier in the alphabet, the value will be positive. this means the new record goes after the current
				{
					IndexIterator[j+1] = r;		//inserting the new record later in the array to maintain alphabetical order
					length++;
				}
				else
				{
					IndexIterator[j+1] = IndexIterator[j];	//current record goes after the new record
					IndexIterator[j] = r;
					length++;
				}
			}
			else
				return false;	//array is full
		}
	}
	
}
