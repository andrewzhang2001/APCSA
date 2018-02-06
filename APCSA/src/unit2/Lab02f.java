package unit2;

public class Lab02f {

	public static void main(String[] args) {
		SlopeFinder boopala = new SlopeFinder(1, 9, 14, 2);
		SlopeFinder adamR = new SlopeFinder(1, 9, 14, 2);
		SlopeFinder anothaOne = new SlopeFinder(1, 7, 18, 3);
		SlopeFinder boo = new SlopeFinder(6, 4, 2, 2);
		SlopeFinder rayraypear = new SlopeFinder(4, 4, 5, 3);
		SlopeFinder andypear = new SlopeFinder(1, 1, 2, 9);
		
	}

}

class SlopeFinder
{
	private double yTwo;
	private double yOne;
	private double xTwo;
	private double xOne;
	private double m;
	public SlopeFinder(double xOne, double yOne, double xTwo, double yTwo){
		slope(xOne, yOne, xTwo, yTwo);
		print();
	}
	public void slope(double xOne, double yOne, double xTwo, double yTwo){
		m = (yTwo - yOne) / (xTwo - xOne);
		
	}
	public void print(){
		System.out.print("Te slope of the line is ");
		System.out.printf("%.2f", m );
		System.out.println();
	}
	
}
