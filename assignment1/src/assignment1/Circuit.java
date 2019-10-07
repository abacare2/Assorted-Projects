package assignment1;
/**
 * Anthony Bacarella COSC 321 Programming Project #1
 * The program should:
 * 1) read a wiring list from a text file
 * 2) create an array of NAND gates that are wired according to the list
 * 3) display all possible outputs
 */
import java.io.*;
import java.util.*;
public class Circuit 
{

	public static void main(String[] args) 
	{ 
		int input1 = 0;
		int input2 = 0;
		int loop = 0;
		NAND[] circuit = new NAND[11];
		boolean done = false;

		while(done != true)
		{
			if(loop == 0)
			{
				circuit[9] = new NAND(0);	//This represents A. We are using the NAND object to simplify the code.
				circuit[10] = new NAND(0);	//This represents B	
			}
			if(loop == 1)
			{
				circuit[9] = new NAND(1);
				circuit[10] = new NAND(0);
			}
			if(loop == 2)
			{
				circuit[9] = new NAND(0);
				circuit[10] = new NAND(1);
			}
			if(loop == 3)
			{
				circuit[9] = new NAND(1);
				circuit[10] = new NAND(1);
				done = true;
			}
			System.out.println(new File("test.txt").getAbsolutePath());
			try 
			{	
				Scanner input = new Scanner(new File("F:\\School\\Eclipse Workspace\\assignment1\\wiring list.txt"));	//full file path goes here
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
			System.out.println("----------------");
			loop++;
		}
	}
}
