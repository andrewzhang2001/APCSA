//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package unit10;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import static java.lang.System.*;

public class Histogram
{
	private ArrayList<Integer> count;
	private ArrayList<Character> letters;
	private String fileName;
	public Histogram()
	{
		letters = new ArrayList<Character>();
		count = new ArrayList<Integer>();
		char[] values = {'a'};
		for(char i:values){ letters.add(i); count.add(0);};
		fileName = "lab16e1.dat";
		out.println("search letters = "+letters);
	}

	public Histogram(char[] values, String fName)
	{
		letters = new ArrayList<Character>();
		count = new ArrayList<Integer>();
		for(char i:values){ letters.add(i); count.add(0);};
		fileName = fName;
		out.println("search letters = "+letters);
	}

	public void loadAndAnalyzeFile() throws IOException
	{
		try 
		{
			Scanner sc = new Scanner(new File(System.getProperty("user.dir")+"\\src\\unit10\\"+fileName));
			while(sc.hasNextLine()){
				String t=sc.nextLine();
				for(int i=0; i < t.length();i++){
					for (int j = 0;j<letters.size();j++){
						if(letters.get(j)==t.charAt(i)) count.set(j, count.get(j)+1); 
					}
				}
			}
			sc.close();
		}
		catch(Exception e){
			out.println(e);
		}
	}

	public String mostFrequent()
	{
		ArrayList<Integer> maxindexes = new ArrayList<Integer>();
		int maxv=count.get(0);
		maxindexes.add(0);
		for(int i =1; i < count.size();i++){
			if (count.get(i)>maxv){
				maxindexes.clear();
				maxindexes.add(i);
				maxv=count.get(i);
			}
		}
		String ans ="";
		for(int i:maxindexes) ans+=letters.get(i)+" ";
		ans+="\n";
		return ans;
	}

	public String leastFrequent()
	{
		ArrayList<Integer> minindexes = new ArrayList<Integer>();
		int minv=count.get(0);
		minindexes.add(0);
		for(int i =1; i < count.size();i++){
			if (count.get(i)<minv){
				minindexes.clear();
				minindexes.add(i);
				minv=count.get(i);
			}
		}
		String ans ="";
		for(int i:minindexes) ans+=letters.get(i)+" ";
		ans+="\n";
		return ans;
	}
	
	public String toString()
	{
	   return fileName
	   + "\n" + letters
	   + "\n" + count + "\n\n";
	}
}