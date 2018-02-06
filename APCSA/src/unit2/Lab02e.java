package unit2;


public class Lab02e {

	public static void main(String[] args) {
	
		Circle hehe = new Circle();
		hehe.setRadius(7.5);
		hehe.setRadius(10);
		hehe.setRadius(72.534);
		hehe.setRadius(55);
		hehe.setRadius(101);
		hehe.setRadius(99.952);
	}

}
class Circle
{
	private double radius;
	private double area;

	public void setRadius(double rad)
	{
		radius = rad;
		this.calculateArea();
		
	}

	public void calculateArea( )
	{
		area = 3.14159*radius*radius;
		this.print();
	}

	public void print( )
	{
		System.out.print("The area of this circle is ");
		System.out.printf("%.4f", area);
		System.out.println("");
	}
}