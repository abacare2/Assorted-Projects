
public class cache 
{
	int cache[];
	int length; //think of it as number of cache lines
	
	public cache()	//default constructor
	{
		cache = new int[10];
		length = 10;
	}
	public cache(int size)	//sets the cache memory size to the value of 'size'.
	{
		cache = new int[size];
		length = size;
	}
	public void setCache(int set, int data)	//allows us to put data into the array
	{
		cache[set] = data;
	}
	public int getCache(int location)	//returns the 'word' stored at the given location
	{
		return cache[location];
	}
}
