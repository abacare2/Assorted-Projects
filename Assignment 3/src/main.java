import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main 
{
	public static void main(String[] args)
	{
		memBlock a;
		cache c;
		int memSize;
		int cSize;
		int cat;	//local variable used to represent cache access time
		int mat;	//memory access time
		int[] search = new int[8];
		String userFile;
		Scanner keyboard = new Scanner(System.in);
		Scanner fileIn = new Scanner(System.in);
		
		//prompting the user and configuring the system.
		System.out.println("Please follow the prompts to configure the simulated machine.");
		System.out.print("Block/Cache line size (# of words): "); //Number of words in each block / cache line. We want to search for a word address, not a block.
		memSize = keyboard.nextInt();
		a = new memBlock(10,memSize+1);	//adding 1 because the [][0] spot in the array is used to keep track of where it is vertically.
		
		System.out.print("Cache Memory size (number of cache lines): ");
		cSize = keyboard.nextInt();
		c = new cache(cSize);
		
		System.out.print("Cache access time (nsec): ");
		cat = keyboard.nextInt();
		
		System.out.print("Memory access time (nsec): ");
		mat = keyboard.nextInt();
		
		//prompting the user for the filename representing a program
		System.out.print("Input File Name of text file containing integer values of the sequence of memory locations to be accessed: ");
	    userFile = fileIn.nextLine();
	    File input = new File(userFile);
	    try 
	    {
			Scanner scan = new Scanner(input);
			int length = 0;
		    while (scan.hasNextInt())
		    {
		    	search[length++] = scan.nextInt();
		    }
		} 
	    catch (FileNotFoundException e) 
	    {
			System.out.println("File not found.");
			System.out.print("Looking for files here: ");
			System.out.println(input.getAbsolutePath());
		}
	    
	    //next, we need to initialize the memory blocks, and set up direct - mapped cache.
	    int address = 0;
		for (int i = 0; i < a.length; i++)	//initialize memory - we want to reliable find memory addresses, so an order would be nice.
		{
			a.setBlock(i, i);
			for (int j = 1; j < a.width; j++)
			{
				a.setAdd(i,j,address);
				address++;
			}
		}
		System.out.println("Main Memory contains: ");
		for (int i = 0; i < a.length; i++)	//displays the data stored in memory blocks
		{
			System.out.print("Memory Block "+"["+i+"]"+" contains words: ");
			for(int j = 1; j < a.width; j++)
			{		
				System.out.print(a.getAd(i, j)+" ");
			}
			System.out.println();
		}
		
		//now we need to initialize cache. It should be empty at the start.
		for (int i = 0; i < c.length; i++)	
		{
			c.setCache(i,999);
		}
		
		/*System.out.println("Cache contains: ");	//used for testing. we can optionally add this after we load a memory block to cache
		for (int i = 0; i < c.length; i++)
		{
			System.out.println(c.getCache(i));
		}*/

		System.out.println("Searching for: ");
		for(int i = 0; i < search.length; i++)
		{
			System.out.println(search[i]);
		}
		
		//finding the hit / miss count
		int hit = 0;
		int miss = 0;
		int checkC = 999;
		boolean found;
		for(int i = 0; i < search.length;i++) //loops through the search array, where each value is a memory address we are searching for.
		{
			found = false;
			for(int j = 0; j < a.length; j++) //loops through a.length, which is the a[j][] value. This is searching each memory block
			{
				for (int k = 1; k < a.width; k++) //loops through a.width, which is the a[][k] value. This is searching each word in the j block.
				{
					if(search[i] == a.getAd(j,k))
					{
						System.out.println("Memory location "+search[i]+" found in Memory Block "+"["+a.getBlock(j)+"]"+"["+k+"]("+a.getAd(j, k)+")");
						found = true;
						checkC = a.getBlock(j);
						//check cached memory to see if the item is there as well.
						int blockNum = a.getBlock(j);	//we looked for data in memory at location a[j][]
						while(blockNum > c.length-1)			//if we look for a[5] and our cache is only 4 lines, we need to map at the start again to cache line 0
						{
							blockNum = blockNum - c.length;	//we are essentially mapping each block to one cache line - might need to come back to this if we have issues with odd / even # of cache lines
							//System.out.println("Adjusted blocknum: "+blockNum);	//used for testing
						}
						//System.out.println("Blocknum = "+blockNum);	//used for testing
							if(c.getCache(blockNum) == checkC)
							{
								hit++;
								System.out.println("Found at cache line: "+blockNum);
								System.out.println();
							}
							else	//this is where direct mapping comes in to play
							{
								c.setCache(blockNum, a.getBlock(j));	//each block of memory will only be mapped a unique cache line.
								System.out.println("Location "+ search[i] +" not found in Cache. Cache line ["+blockNum+"] has loaded Memory block ["+a.getBlock(j)+"]");
								System.out.println();
								miss++;								
							}
					}
				}
			}
			if (found == false)
			{
				System.out.println("The value you were searching for does not exist in main memory:  "+search[i]);
				miss++;
			}
		}
		//The program should calculate and display the resulting hit ratio and effective access time for the given input file.
		int total = hit + miss;
		double eat; //Effective Access Time
		System.out.println("Hit Ratio: "+hit+"/"+total);
		System.out.println("Calculating ((# hits)*(Time per hit) + (# misses)*(Time per miss)) / (Total number of memory accesses))");
		System.out.println("Calculating (("+hit+") ("+cat+") + ("+miss+") ("+mat+")) / ("+total+")");
		cat = hit*cat;
		mat = miss*mat;
		System.out.println("Calculating ("+cat+" + "+mat+") / ("+total+"))");
		int first = cat+mat;
		eat = (double)first / (double)total;
		System.out.println("Effective access time: "+eat+ " nsec");
	}
}
