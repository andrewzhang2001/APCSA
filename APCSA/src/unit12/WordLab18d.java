package unit12;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.lang.Math;

public class WordLab18d implements Comparable<WordLab18d>
{
	private String word;

	public WordLab18d(String s)
	{
		word = s;
	}
	private int numVowels(){
		String vowels = "AEIOUaeiou";
		int vowelcount = 0;
		for(int i =0;i<word.length();i++){
			for(int j = 0;j<vowels.length();j++){
				if(word.charAt(i)==vowels.charAt(j))vowelcount+=1;
			}
		}
		return vowelcount;
	}

	public int compareTo( WordLab18d rhs )
	{	
		//Below code is for Lab18d only
		
		if (word.length()>rhs.toString().length()) return 1;
		else if(word.length()<rhs.toString().length())return -1;
		return 0;
		
	}

	public String toString()
	{
		return word;
	}
}