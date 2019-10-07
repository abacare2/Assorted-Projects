package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test {
	public static void main(String[] args) 
	{ 
		int a = 0;
		int b = 0;
		int input1 = 0;
		int input2 = 0;
		int[] circuit = new int[11];
		
		try 
		{	
			Scanner input = new Scanner(new File("F:\\School\\Eclipse Workspace\\test\\src\\test\\testlist.txt"));
			a = input.nextInt();
			b = input.nextInt();
			input.nextLine();
			circuit[9] = a;
			circuit[10] = b;

			while(input.hasNextLine())
			{
				input1 = input.nextInt();	//storing the values for later
				input2 = input.nextInt();
				circuit[input.nextInt()] = input1;	//reading in the third number of each line, determine which gate our inputs are going into and then initialize the gate.
				input.nextLine();
			}
			
			input.close();
		}
		
		catch (FileNotFoundException e)
		{
			System.out.println("File not found.");
		}		

		System.out.println("Format is: Input Input Output");
		for (int i = 0; i<circuit.length;i++)
		{
			System.out.println(circuit[i]);
		}
	}
}

