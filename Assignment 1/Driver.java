
public class Driver 
{
	public static void main(String[] args)
	{
		Database d = new Database(10); 
		
		d.insert("1234", "alice", "jones");
		d.insert("1235", "zelda", "smith");
		d.insert("9999", "mike", "adams");
		d.insert("9988", "dave", "bing");
		d.insert("2233", "sue", "charles");
		d.insert("2244", "ed", "smiley");
		d.insert("6655", "mary", "rogers");
		d.insert("6633", "ellen", "nance");
		d.insert("4234", "roger", "morris");
		d.insert("3234", "mac", "edwards");
		
		System.out.println("by id: ");
		d.listByID();
		System.out.println("****");
		System.out.println("by first: ");
		d.listByFirst();
		System.out.println("***************");
		System.out.println("by last: ");
		d.listByLast();
	}

}
