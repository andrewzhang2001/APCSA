package unit13;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.*;
import java.io.*;

import static java.lang.System.*;

public class Lab15d
{
	public static void main( String args[] ) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\unit13\\lab15d.dat"));
		int n = Integer.parseInt(br.readLine());
		for(int i =0;i<3;i++){
			FancyWords happyfeet = new FancyWords(br.readLine());
			System.out.println(happyfeet);
		}





	}
}