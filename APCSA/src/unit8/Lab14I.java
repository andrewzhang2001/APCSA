package unit8;
import static java.lang.System.*;
public class Lab14I
{
	public static void main( String args[] )
	{
		RomanNumeral test = new RomanNumeral(10);
		out.println("10 is " + test.toString());

		test.setNumber(100);
		out.println("100 is " + test.toString());

		test.setNumber(1000);
		out.println("1000 is " + test.toString());

		test.setNumber(2500);
		out.println("2500 is " + test.toString());

		test = new RomanNumeral(1500);
		out.println("1500 is " + test.toString());

		test.setNumber(23);
		out.println("23 is " + test.toString());

		test.setNumber(38);
		out.println("38 is " + test.toString());

		test.setNumber(49);
		out.println("49 is " + test.toString());

		test.setRoman("LXXVII");
		out.println("LXXVII is " + test.getNumber() + "\n");

		test.setRoman("XLIX");
		out.println("XLIX is " + test.getNumber() + "\n");

		test.setRoman("XX");
		out.println("XX is " + test.getNumber() + "\n");

		test.setRoman("XLIX");
		out.println("XLIX is " + test.getNumber() + "\n");
	}
}
class RomanNumeral
{
	private Integer number;
	private String roman;

	private final static int[] NUMBERS= {1000,900,500,400,100,90,
													50,40,10,9,5,4,1};

	private final static String[] LETTERS = {"M","CM","D","CD","C","XC",
												  "L","XL","X","IX","V","IV","I"};

	public RomanNumeral(String str)
	{
		setRoman(str);


	}

	public RomanNumeral(Integer orig)
	{
		setNumber(orig);


	}

	public void setNumber(Integer num)
	{
		number = num;




	}

	public void setRoman(String rom)
	{
		roman = rom;


	}

	public Integer getNumber()
	{
		
		return number;
	}

	public String toString()
	{
		return roman + "\n";
	}
}