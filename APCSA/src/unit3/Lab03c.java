package unit3;

import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;
public class Lab03c {
	public static void main( String[] args )
	   {
	   	Scanner keyboard = new Scanner(System.in);
	   	System.out.print("Enter a:: ");
	   	int aa = keyboard.nextInt();
	   	System.out.print("\nEnter b:: ");
	   	int bb = keyboard.nextInt();
	   	System.out.print("\nEnter c:: ");
	   	int cc = keyboard.nextInt();
	   	Quadratic solver = new Quadratic(aa,bb,cc);
	   	
	   	
			
			
		}
}
class Quadratic
{
	private int a, b, c;
	private double rootOne;
	private double rootTwo;

	public Quadratic()
	{


	}

	public Quadratic(int quadA, int quadB, int quadC)
	{
		a = quadA;
		b = quadB;
		c = quadC;
		setEquation(a,b,c);
		print();

	}

	public void setEquation(int quadA, int quadB, int quadC)
	{
		rootOne = (-quadB + Math.sqrt(quadB * quadB - 4 * quadA * quadC))/(2 * quadA);
		rootTwo = (-quadB - Math.sqrt(quadB * quadB - 4 * quadA * quadC))/(2 * quadA);
 	}

	public void calcRoots( )
	{


	}

	public void print( )
	{
		
		System.out.println("\n");
		System.out.println("Root one is "+String.format("%.2f", rootOne));
		System.out.println("Root two is "+String.format("%.2f", rootTwo));
		System.out.print("\n\n");
	}
}