
import java.io.*;
import java.util.*;
public class Circuit 
{

	public static void main(String[] args) 
	{ 
		int a = 0;
		int b = 0;
		int input1 = 0;
		int input2 = 0;
		NAND[] circuit = new NAND[11];
		
		try 
		{	
			Scanner input = new Scanner(new File("F:\\School\\Eclipse Workspace\\COSC Logic Circuit\\src\\wiring list.txt"));
			a = input.nextInt();
			b = input.nextInt();
			input.nextLine();

			circuit[9] = new NAND(a);	//This represents A. We are using the NAND object to simplify the code.
			circuit[10] = new NAND(b);	//This represents B
			while(input.hasNextLine())
			{
				input1 = input.nextInt();	//storing the values for later
				input2 = input.nextInt();
				circuit[input.nextInt()] = new NAND(circuit[input1].getOut(),circuit[input2].getOut());	//reading in the third number of each line, determine which gate our inputs are going into and then initialize the gate.
				input.nextLine();
			}
			
			input.close();
		}
		
		catch (FileNotFoundException e)
		{
			System.out.println("File not found.");
		}		
		System.out.println("A = "+circuit[9].getOut()+"\nB = "+circuit[10].getOut());
		
		
		//Truth Table
		System.out.println("Format is: Input Input Output");
		for (int i = 0; i<9;i++)
		{
			System.out.println(circuit[i].getInput1()+" "+circuit[i].getInput2()+" "+circuit[i].getOut());
		}
	}
}
