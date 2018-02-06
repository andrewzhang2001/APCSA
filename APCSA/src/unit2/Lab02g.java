package unit2;

public class Lab02g {
	public static void main (String[] args){
		Fahrenheit adam = new Fahrenheit(98.6);
		Fahrenheit bdam = new Fahrenheit(52.30);
		Fahrenheit cdam = new Fahrenheit(82.45);
		Fahrenheit ddam = new Fahrenheit(75.00);
		Fahrenheit edam = new Fahrenheit(100.0);
		
	}
}
class Fahrenheit
{
	private double fahrenheit;
	public Fahrenheit(double fahren){
		setFahrenheit(fahren);
		getCelsius();
		print();
	}
	public void setFahrenheit(double fahren)
	{
		fahrenheit = fahren;
	}

	public double getCelsius()
	{
		double celsius = 0.0;
		celsius = (fahrenheit - 32)* 5 /9;
		return celsius;
	}

	public void print()
	{
		System.out.println(String.format("%.2f", fahrenheit) + " degrees Fahrenheit is " + String.format("%.2f", getCelsius()) + " degrees Celsius.\n");
	}
}
