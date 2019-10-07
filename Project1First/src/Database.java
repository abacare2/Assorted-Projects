/*
 * The class that utilizes each other class to form a database of sorted arrays as indexes
 */
public class Database 
{
	private DatabaseArray myDbArr;
	private IndexIterator idIt, firstIt, lastIt;
	private OrderedArray idOrd, firstOrd, lastOrd;
	
	public Database(int size)
	{
		myDbArr = new DatabaseArray(size);
		idIt = new IndexIterator(size);
		firstIt = new IndexIterator(size);
		lastIt = new IndexIterator(size);
		idOrd = new OrderedArray(size);
		firstOrd = new OrderedArray(size);
		lastOrd = new OrderedArray(size);
	}
	//insert method
	public void insert(String i, String f, String l)
	{
		int position = 0;
		DatabaseRecord a = new DatabaseRecord(i,f,l);	//create a database record with the inserted id, first name, and last name.
		myDbArr.addRecord(a);							// add the record to the database array
		
		IndexRecord id = new IndexRecord(i, position);
		IndexRecord first = new IndexRecord(f, position);
		IndexRecord last = new IndexRecord(l, position);
		
		idOrd.addIndex(id);
		firstOrd.addIndex(first);
		lastOrd.addIndex(last);
		
		idIt.addIndex(idOrd);
		firstIt.addIndex(firstOrd);
		lastIt.addIndex(lastOrd);
		
		position++;
	}
	
	//list by id method
	public void listByID()
	{
		idIt.iteratorInitFront();
		
		while (idIt.hasNext())
		{
			System.out.println(myDbArr.retrieve(idIt.getNext()));
		}
		System.out.println(myDbArr.retrieve(idIt.getCurrent()));		
	}
	//List by first name method
	public void listByFirst()
	{
		firstIt.iteratorInitFront();
		
		while (firstIt.hasNext())
		{
			System.out.println(myDbArr.retrieve(firstIt.getNext()));
		}
		System.out.println(myDbArr.retrieve(firstIt.getCurrent()));		
	}
	//list by Last name method
	public void listByLast()
	{
		lastIt.iteratorInitFront();
		
		while (lastIt.hasNext())
		{
			System.out.println(myDbArr.retrieve(lastIt.getNext()));
		}
		System.out.println(myDbArr.retrieve(lastIt.getCurrent()));
	}
}
