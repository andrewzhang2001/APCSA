package unit7;

import java.util.Scanner;
import java.util.Random;

public class Lab10E
{
	public static void main(String args[])
	{
		Scanner keyboard = new Scanner(System.in);
		GuessingGame adam = new GuessingGame(3);






	}
}

class GuessingGame
{
	private int upperBound;
;
	public GuessingGame(int stop)
	{
		
		upperBound = stop;
		playGame();

	}

	public void playGame()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Guessing Game- How many numbers? ");
		upperBound = keyboard.nextInt();
		Random rng = new Random();
		int ans = rng.nextInt(upperBound) + 1;
		boolean correct = false;
		int counter = 0;
		while(!correct){
			System.out.println("Enter a guess: ");
			int guess = keyboard.nextInt();
			correct = guess == ans;
			counter +=1;
		}
		System.out.println("It took "+counter+ " guesses to guess "+ ans);
		System.out.println("You guessed wrong " +(double)(counter -1)/upperBound * 100 +"% of the time\n");
		System.out.println("Do you want to play again? (Y/N)");
		String yesno = keyboard.next();
		if(yesno.equals("y") || yesno.equals("Y")){
			playGame();
		}






	}

	public String toString()
	{
		String output="";
		return output;
	}
}