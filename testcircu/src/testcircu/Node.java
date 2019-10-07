package testcircu;

public class Node {
	int key;
	double data;

	Node left;
	Node right;
	Node parent;

	public Node(int key) {
		this.key = key;
		data = -100;
	}
	
	public String toString(){
		return "" + key;
	}
	
}
