/*
 * Anthony Bacarella COSC 311
 * The program should implement an AVL tree to create a system that acts as a dictionary.
 * Each node in the tree should contain the word, frequency of how many times the word is encountered in the dictionary,
 * a boolean variable to support lazy deletion, and links to its left and right children.
 * 
 * We should also be able to perform the following:
 * Check if the dictionary is empty.
 * Find how many words are in the dictionary.
 * Insert a word.
 * Find a word by returning the frequency.
 * Print the dictionary in lexicographical order.
 * Remove a node by utilizing the boolean variable.
 */
public class Dictionary 
{
	int key = 0;
	WordNode root = null;
	WordNode node = null;
	WordNode delete = null;
	WordNode insert = null;
	WordNode find = null;
	
	public boolean isEmpty()
	{
		if(root == null)	//root has not been initialized - tree is empty
			return true;
		else
			return false;
	}
	public void insert(String n)
	{
		insert = new WordNode(n);
		insert(insert);
	}
	public void insert(WordNode n) //insert node "n"
	{
		if(root == null)		//True for first insertion
		{
			root = n;
			root.position = 1;
			root.frequency++;
			key++;
			System.out.println("Insterting "+ n.data + " at position "+ key);
		}
		else			//Every insertion after the first
		{
			root = insert(n, root);	//sending current node and root
			n.position = key;
			n.frequency++;
			key++;
			System.out.println("Inserting "+ n.data +" at position " + key);
		}
	}
	/*public WordNode insert(WordNode n, WordNode current)
	{
		if(current == null)
			return n;
		
		if(current.left == null)
		{
			//System.out.println( );
			current.left = insert(n, current.left);
		}
		
		else if(current.right == null)
		{
			current.right = insert(n, current.right);			
		}
		
		return balance(current);
	}*/
	
	public WordNode insert(WordNode n, WordNode current) 
	{
		if(current == null)
		{
			return n;
		}
		
		if(n.data.compareTo(current.data) < 0 )	//n.data is earlier in the alphabet than current.data
		{
			current.left = insert(n, current.left);
		}
		
		else if(n.data.compareTo(current.data) > 0)	//n.data is lexicographically larger than current
		{
			current.right = insert(n, current.right);
		}
		else if(n.data.compareTo(current.data) == 0)	//duplicate entry
		{
			current.frequency++;
		}
		
		return balance(current);
	}
	//balancing the tree 
	private WordNode balance(WordNode n) {
		if(n == null)
			return n;
		
		if(height(n.left) - height(n.right) > 1) {
			if(height(n.left.left) >= height(n.left.right))
				n = rotateWithLeftChildCase1(n);
			else
				n = doubleWithLeftChildCase2(n);
		} else if(height(n.right) - height(n.left) > 1){
			if(height(n.right.right) >= height(n.right.left))
				n = rotateWithRightChildCase4(n);
			else
				n = doubleWithRightChildCase3(n);
		}
			
		n.height = Math.max(height(n.left), height(n.right)) + 1;
		return n;
	}
	
	public int height(WordNode n) {
		if ( n == null)
			return -1;
		else
			return n.height;
	}
	//rotations
	private WordNode rotateWithLeftChildCase1(WordNode k2){
		WordNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		
		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
		k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
		return k1;
	}
	
	private WordNode rotateWithRightChildCase4(WordNode k1) {
		WordNode k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
		k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
		return k2;
	}
	
	private WordNode doubleWithLeftChildCase2(WordNode k3){
		k3.left = rotateWithRightChildCase4(k3.left);
		return rotateWithLeftChildCase1(k3);
	}
	
	private WordNode doubleWithRightChildCase3(WordNode k3){
		k3.right = rotateWithLeftChildCase1(k3.right);
		return rotateWithRightChildCase4(k3);
	}
	//end of rotations
	//printing
	public void printSorted()		//prints the words in the tree in lexicographic order (WIP currently prints each node followed by its children)
	{
		boolean leftChild = false;
		boolean rightChild = false;
		System.out.println("Printing...");
		WordNode n = root;
		n.print();
		if(n.left != null)
		{
			System.out.println("Left child: ");
			n.left.print();
			leftChild = true;
		}
		if(n.right != null)
		{
			System.out.println("Right child: ");
			n.right.print();
			rightChild = true;
		}
		if(leftChild == true)
		{
			printSorted(n.left);
		}
		if(rightChild == true)
		{
			printSorted(n.right);
		}
	}
	public void printSorted(WordNode n)
	{
		System.out.print("Printing children of");
		n.print();
		if(n.left != null)
		{
			System.out.println("Left child: ");
			n.left.print();
		}
		if(n.right != null)
		{
			System.out.println("Right child: ");
			n.right.print();
		}
	}
	
	public int find(String s)
	{
		find = new WordNode(s);
		int result = find(find);
		return result;
	}
	public int find(WordNode n)
	{
		WordNode leftNode = root;
		WordNode rightNode = root;
		int counter = -1;
		while(leftNode.left != null)
		{
			if(leftNode.data.compareTo(n.data) == 0)
			{
				//return leftNode.frequency;
				counter++;
			}
			leftNode = leftNode.left;
		}
		while(rightNode.right != null)
		{
			if(rightNode.data.compareTo(n.data) == 0)
			{
				//return rightNode.frequency;
				counter++;
			}
			rightNode = rightNode.right;
		}
			return counter;
	}
	
	public void remove(String s)
	{
		node = new WordNode(s);
		delete = remove(node, root);
	}
	public WordNode remove(WordNode s, WordNode current)
	{		
			if(current == null)
			{
				return s;
			}
			
			if(s.data.compareTo(current.data) < 0 )	//n.data is earlier in the alphabet than current.data
			{
				current.left = insert(s, current.left);
			}
			
			else if(s.data.compareTo(current.data) > 0)	//n.data is lexicographically larger than current
			{
				current.right = insert(s, current.right);
			}
			else if(s.data.compareTo(current.data) == 0)	//duplicate entry
			{
				current.removed = true;
			}
			return current;
	}
}
