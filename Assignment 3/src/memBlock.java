
public class memBlock 
{
	int block[][];
	int length;
	int width;
	
	public memBlock()	//default constructor
	{
		block = new int[10][];
		length = 10;
	}
	public memBlock(int size,int wordNum)	//constructor that allows users to input the number of memory blocks and how many words per block in the machine
	{
		block = new int[size][wordNum];
		length = size;
		width = wordNum;
	}
	
	public void setBlock(int set, int data)	//allows us to put data into the array
	{
		block[set][0] = data;
	}
	public void setAdd(int set,int address,int data) //maybe we can condense these two methods?
	{
		block[set][address] = data;
	}
	public int getBlock(int location)
	{
		return block[location][0];
	}
	public int getAd(int location,int address)
	{
		return block[location][address];
	}
}