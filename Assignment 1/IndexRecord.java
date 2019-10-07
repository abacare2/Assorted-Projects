
public class IndexRecord 
{
	private String key;
	private int where;
	
	public IndexRecord()	//Default constructor
	{
		key = "none";
		where = -1;
	}
	public IndexRecord(String k, int w)		//constructor
	{
		this.key = k;
		this.where = w;
	}
	public String getKey()	//accessor method to find the data stored in the location
	{
		return key;
	}
	public int getPosition()	//method to return the position in the array
	{
		return where;
	}
	public int compareTo(IndexRecord r)	//allows us to use the key as an int and not a string. Should return 0 if the strings are the same, positive if key is alphabetically larger
	{
		return(r.getKey().compareTo(key));
	}
}
