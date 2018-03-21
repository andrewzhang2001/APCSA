package unit14;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

import java.util.Arrays;

public class AtCounter
{
   private char[][] atMat;
   private int atCount;
   private boolean[][] visited;
   private boolean[][] binArray;
   private int rrr;
   private int ccc;
	public AtCounter()
	{
		atCount=0;
		atMat = new char[][]{		{'@','-','@','-','-','@','-','@','@','@'},
									{'@','@','@','-','@','@','-','@','-','@'},
									{'-','-','-','-','-','-','-','@','@','@'},
									{'-','@','@','@','@','@','-','@','-','@'},
									{'-','@','-','@','-','@','-','@','-','@'},
									{'@','@','@','@','@','@','-','@','@','@'},
									{'-','@','-','@','-','@','-','-','-','@'},
									{'-','@','@','@','-','@','-','-','-','-'},
									{'-','@','-','@','-','@','-','@','@','@'},
									{'-','@','@','@','@','@','-','@','@','@'}};
		binArray=new boolean[atMat[0].length+2][atMat[1].length+2];
		visited=new boolean[atMat[0].length+2][atMat[1].length+2];
		for(int i =0;i<atMat[0].length;i++){
			for(int k =0;k<atMat[1].length;k++){
				if(atMat[i][k]=='@') binArray[i+1][k+1]=true;
			}
		}
	}

	public int countAts(int r, int c)
	{
		int rr = r;
		int cc = c;
		atCount=0;
		if(!visited[r+1][c+1]&&binArray[r+1][c+1]){
			atCount+=1;
			visited[r+1][c+1]=true;
			atCount+=countAts(r+1,c);
			atCount+=countAts(r,c+1);
			atCount+=countAts(r-1,c);
			atCount+=countAts(r,c-1);
		}
		rrr=rr;
		ccc=cc;
		return atCount;
	}

	public int getAtCount()
	{
		return atCount;
	}

	public String toString()
	{
		String output=rrr+" "+ccc+" has ";
		output+=getAtCount()+" @s connected.";
		return output;
	}
}