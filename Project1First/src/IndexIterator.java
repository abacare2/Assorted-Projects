/*
 * A class that defines the index iterator structure. The index iterator is an array of index records that are in order because they have been passed through 
 * the OrderedArray class.
 */
public class IndexIterator {

	public OrderedArray[] IndexIterator;
	public int length;
	public int max;
	public int iterator;
	
	public IndexIterator() // no argument constructor
	{
		IndexIterator = new OrderedArray[10];
		length = 0;
		max = 10;
	}
	
	public IndexIterator(int size) //Constructor for creating the array
	{
		IndexIterator = new OrderedArray[size];	//initialize the array 
		length = 0;								//remains 0 because nothing has been added.
		max = size;								//We don't want to exceed the length of the array
	}
	
	//setting up the iterator methods
	public void iteratorInitFront()		//set the iterator to 0
	{
		iterator = 0;
	}
	public void iteratorInitBack()		//set the iterator to the last element in the array
	{
		iterator = IndexIterator.length-1;
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
		iterator++;
		return IndexIterator[iterator-1].getPosition();
	}
	public int getPrevious()			//return the where component of the IndexRecord, then decrements iterator.
	{
		iterator--;	
		return IndexIterator[iterator+1].getPosition();
	}
	public int getCurrent()
	{
		return iterator-1;
	}
	//Insertions must maintain the order in the array, by key value.
	
	public int addIndex (OrderedArray r) //add a record in order.
	{
		IndexIterator[length] = r;		//add new record to the next available position in the array;
		length++;					//update length, which holds the amount of positions filled
		return (length - 1);		//returns location where 'r' was added
	}
	
}
