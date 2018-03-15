package unit12;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.lang.Math;

public class WordLab18e implements Comparable<WordLab18e>
{
	private String word;

	public WordLab18e(String s)
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

	public int compareTo( WordLab18e rhs )
	{	
		//Below code is for Lab18e only
		if(numVowels()>rhs.numVowels()) return 1;
		if(numVowels()<rhs.numVowels()) return -1;
		for(int i =0;i<Math.min(rhs.toString().length(),toString().length());i++){
			if(toString().charAt(i)>rhs.toString().charAt(i)) return 1;
			else if (toString().charAt(i)<rhs.toString().charAt(i)) return -1;
		}
		return toString().length()-rhs.toString().length();
		
	}

	public String toString()
	{
		return word;
	}
}