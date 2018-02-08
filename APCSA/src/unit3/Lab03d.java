package unit3;
import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;
public class Lab03d {
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter x1: ");
		int xOne = keyboard.nextInt();
		System.out.print("\nEnter y1: ");
		int yOne = keyboard.nextInt();
		System.out.print("\nEnter x2: ");
		int xTwo = keyboard.nextInt();
		System.out.print("\nEnter y2: ");
		int yTwo = keyboard.nextInt();
		Distance calculator = new Distance(xOne, yOne, xTwo, yTwo);
	}
}
class Distance
{
	private int xOne,yOne,xTwo,yTwo;
	private double distance;

	public Distance()
	{



	}

	public Distance(int x1, int y1, int x2, int y2)
	{
		setCoordinates(x1,y1,x2,y2);
		calcDistance();
		print();


	}

	public void setCoordinates(int x1, int y1, int x2, int y2)
	{
		xOne = x1;
		yOne = y1;
		xTwo = x2;
		yTwo = y2;


	}

	public void calcDistance()
	{
		distance = Math.sqrt((xTwo-xOne) *(xTwo-xOne) + (yTwo - yOne) * (yTwo - yOne));

	}

	public void print( )
	{
		System.out.println("Distance is " + String.format("%.3f", distance));
	}

	}