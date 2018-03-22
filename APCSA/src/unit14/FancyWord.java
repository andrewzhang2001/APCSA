package unit14;
//© A+ Computer Science  -  www.apluscompsci.com

import java.util.Arrays;

//Name -
//Date -
//Class - 
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class FancyWord {
	private char[][] mat;
	
	public FancyWord() {

	}

	public FancyWord(String s) {
		mat = new char[s.length()][s.length()];
		for(int i=0;i<s.length();i++){
			Arrays.fill(mat[i], ' ');
		}
		for(int i=0;i<s.length();i++){
				mat[0][i]=s.charAt(i);
				mat[s.length()-1][i]=s.charAt(i);
		}
		for(int i=1;i<s.length()-1;i++){
			for(int k=1;k<s.length();k++){
				if(i==k)mat[i][k]=s.charAt(i);
				if(i+k==s.length()-1)mat[i][k]=s.charAt(k);
			}
		}
	}

	public String toString() {
		String output = "";
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[i].length;j++)output+=mat[i][j];
			output+="\n";
		}
		return output + "\n\n";
	}
}