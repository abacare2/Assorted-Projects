
public class Driver {

	public static void main(String[] args) 
	{
		Dictionary avl = new Dictionary();
		if(avl.isEmpty() == true)
		{
			System.out.println("Dictionary is empty.");
		}
		avl.insert("tiger");
		avl.insert("lion");
		avl.insert("seal");
		avl.insert("bear");
		avl.insert("lion");
		avl.insert("llama");
		avl.insert("horse");
		avl.remove("horse");
		avl.printSorted();
		System.out.println(avl.find("llama"));
	}
}
