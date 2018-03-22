package unit14;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class TicTacToe
{
	private char[][] mat;
	private String winner;
	private String typewin;
	public TicTacToe()
	{


	}

	public TicTacToe(String game)
	{
		mat=new char[3][3];
		for(int i=0;i<9;i++){
			mat[i/3][i%3]=game.charAt(i);
			System.out.print(game.charAt(i));
			if(i%3==2)System.out.println();
		}
		for(int i=0;i<3;i++)if(mat[i][0]==mat[i][1]&&mat[i][1]==mat[i][2]){
			winner=String.valueOf(mat[i][0]);
			typewin="horizontally!";
			return;
		}
		for(int i=0;i<3;i++)if(mat[0][i]==mat[1][i]&&mat[1][i]==mat[2][i]){
			winner=String.valueOf(mat[0][i]);
			typewin="vertically!";
			return;
		}
		if(mat[0][0]==mat[1][1]&&mat[1][1]==mat[2][2]||mat[2][0]==mat[1][1]&&mat[1][1]==mat[0][2]){
			winner=String.valueOf(mat[1][1]);
			typewin="diagonally!";
			return;
		}
		winner="Draw";
		
	}

	public String getWinner()
	{
		

		return winner;
	}

	public String toString()
	{
		String output="";
		if(winner.equals("Draw"))output+="cat's game - no winner";
		else output+=winner+" wins "+typewin;





		return output+"\n\n";
	}
}