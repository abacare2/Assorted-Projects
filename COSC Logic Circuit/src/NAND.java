/**
 * The following class should outline the NAND gates on the circuit.
 * We will establish constructors to make the gates function properly. 
 */
public class NAND 
{
	int in1;
	int in2;
	int output;
	
	public NAND()	//default
	{
		in1 = 1;	//unused inputs are logical 1
		in2 = 1;
		output = 0;
	}
	
	public NAND(int a, int b)	//constructor for two inputs
	{
		in1 = a;
		in2 = b;
		if(in1 == 1 && in2 == 1)
			output = 0;
		else
			output = 1; 			
	}
	public NAND(int a)	//special case: using a nand gate to represent A or B
	{
		output = a;
	}
	//accessor methods to set the inputs after the gates have been initialized
	public void setIn1(int a)
	{
		in1 = a;
	}
	public void setIn2(int a)
	{
		in2 = a;
	}
	//getter methods used to return the values stored in each gate.
	public int getInput1()
	{
		return in1;
	}
	public int getInput2()
	{
		return in2;
	}
	public int getOut()
	{
		return output;
	}
}
