
public class WordNode 
{
	int position;
	String data;
	int frequency;
	int height;
	boolean removed;
	
	WordNode left = null;
	WordNode right = null;

	public WordNode(String key) 
	{
		position = 0;
		data = key.toString();
		frequency = 0;
		removed = false;
	}

	public void print() 
	{
		if(removed == true)
		{
			System.out.println("Node has been removed.");
		}
		else
		System.out.println("" +  " " + data + " " + frequency);
	}

}