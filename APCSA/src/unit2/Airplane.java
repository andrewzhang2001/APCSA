package unit2;
import java.util.Scanner;
import static java.lang.System.*;

public class Airplane {

	public static void main(String[] args) {
		Scanner pearMaster = new Scanner(System.in);
		System.out.print("Enter velocity: ");
		double v = pearMaster.nextDouble();
		System.out.print("\nEnter acceleration: ");
		double a = pearMaster.nextDouble();
		double length = v* v / 2 /a;
		System.out.println("\nThe minimum runway length for this airplane is "+ String.format("%.3f", length) + " meters.");
		
	}

}
