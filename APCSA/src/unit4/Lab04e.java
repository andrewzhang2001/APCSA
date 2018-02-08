package unit4;

public class Lab04e {
	public static void main(String[] args){
		StringChecker demo = new StringChecker("chicken");
		System.out.println("looking for c "+demo.findLetter('c'));
		System.out.println("looking for ch "+demo.findSubString("ch"));
		System.out.println("looking for x "+demo.findSubString("x"));
		System.out.println(demo);

		demo.setString("alligator");
		System.out.println("looking for g "+demo.findLetter('g'));
		System.out.println("looking for all "+demo.findSubString("all"));
		System.out.println("looking for gater "+demo.findSubString("gater"));
		System.out.println(demo);

		demo.setString("COMPUTER SCIENCE IS THE BEST!");
		System.out.println("looking for U "+demo.findLetter('U'));
		System.out.println("looking for COMP SCI "+demo.findSubString("COMP SCI"));
		System.out.println("looking for SCIENCE "+demo.findSubString("SCIENCE"));
		System.out.println(demo);
	}
}

class StringChecker
{
	private String word;

	public StringChecker()
	{


	}

	public StringChecker(String s)
	{
		setString(s);

	}

   public void setString(String s)
   {
   	word=s;
   }

	public boolean findLetter(char c)
	{
		char meep;
		for(int i = 0; i < word.length(); i++){
			meep = word.charAt(i);
			if (meep == c){
				return true;
			}
			
		}
		return false;
	}

	public boolean findSubString(String s)
	{
		int bloop = word.indexOf(s);
		if (bloop == -1){
			return false;
		}
		return true;
	}

 	public String toString()
 	{
 		return word + "\n\n";
	}
}