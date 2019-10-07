
public class Database 
{
	private DatabaseArray myDbArr;
	private IndexIterator idIt, firstIt, lastIt;
	
	public Database(int size)
	{
		myDbArr = new DatabaseArray(size);
		idIt = new IndexIterator(size);
		firstIt = new IndexIterator(size);
		lastIt = new IndexIterator(size);
	}
	//insert method
	public void insert(DatabaseArray n)
	{
		addRecord(n);
	}
	//list by id method
	public void listByID()
	{
		firstIt.iteratorInitFront();
		
		while (firstIt.hasNext())
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
	public void listByLast();
	{
		lastIt.iteratorInitFront();
		
		while (lastIt.hasNext))
		{
			System.out.println(myDbArr.retrieve(lastIt.getNext()));
		}
		System.out.println(myDbArr.retrieve(lastIt.getCurrent()));
	}
}
