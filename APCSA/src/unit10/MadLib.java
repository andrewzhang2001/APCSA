package unit10;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import static java.lang.System.*;

public class MadLib
{
	private ArrayList<String> verbs;
	private ArrayList<String> nouns;
	private ArrayList<String> adjectives;
	
	public MadLib()
	{
		loadNouns();
		loadAdjectives();
		loadVerbs();


	}

	public MadLib(String fileName)
	{
		//load stuff
		
		String mb="";
		
		try{
			Scanner file = new Scanner(new File(fileName));
			mb= file.nextLine();		
		
		
		
		
		
	
		
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");
		}
		loadNouns();
		loadAdjectives();
		loadVerbs();
		String ans ="";
		for(int i =0; i < mb.length(); i++){
			
		}
		
	}

	public void loadNouns()
	{
		try{
			Scanner file = new Scanner(new File(System.getProperty("user.dir")+"\\src\\Lab16d\\nouns.dat"));
			while(file.hasNextLine()){
				nouns.add(file.nextLine());
			}
			
		}
		catch(Exception e)
		{
			out.println(e);
		}	
		
	}
	
	public void loadVerbs()
	{
		try{
			Scanner file = new Scanner(new File(System.getProperty("user.dir")+"\\src\\Lab16d\\verbs.dat"));
			while(file.hasNextLine()){
				verbs.add(file.nextLine());
			}
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

	public void loadAdjectives()
	{
		try{
			Scanner file = new Scanner(new File(System.getProperty("user.dir")+"\\src\\Lab16d\\adjectives.dat"));
			while(file.hasNextLine()){
				adjectives.add(file.nextLine());
			}
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

	public String getRandomVerb()
	{
		return verbs.get((new Random()).nextInt(verbs.size()));
	}
	
	public String getRandomNoun()
	{
		
		return nouns.get((new Random()).nextInt(nouns.size()));
	}
	
	public String getRandomAdjective()
	{
		
		return adjectives.get((new Random()).nextInt(adjectives.size()));
	}		

	public String toString()
	{
	   return "\n\n\n";
	}
}