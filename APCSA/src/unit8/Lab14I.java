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

	private final static int[] NUMBERS= {1000,500,100,
													50,10,5,1};
	
	private final static String[] LETTERS = {"M","D","C",
												  "L","X","V","I"};
	private final static int[] NUMBERSTWO = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	private final static String[] LETTERSTWO = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
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
		int summ = 0;
		for(int i = 0; i < roman.length()-1; i++){
			String temp = roman.substring(i, i+1);
			String tempTwo = roman.substring(i+1, i+2);
			for(int j = 0; j < LETTERS.length; j++){
				if(temp.equals(LETTERS[j])){
					for(int k = 0; k < LETTERS.length; k++){
						if(tempTwo.equals(LETTERS[k])){
							if(NUMBERS[j] < NUMBERS[k]){
								summ -= NUMBERS[j];
							}
							else{
								summ += NUMBERS[j];
							}
						}
					}
				}
			}
			
		}
		for(int i = 0; i < LETTERS.length; i++){
			if(roman.substring(roman.length()-1, roman.length()).equals(LETTERS[i])){
				summ += NUMBERS[i];
			}
		}
		return summ;
	}

	public String toString()
	{
		int temp = number;
		roman = "";
		int i =0;
		while(temp > 0){
			if(temp  >= NUMBERSTWO[i]){
				roman += LETTERSTWO[i];
				temp -= NUMBERSTWO[i];
			}
			else{
				i++;
			}
		}
		return roman + "\n";
	}
}