package unit7;

public class Lab11C {

	public static void main(String[] args) {
		TriangleThree andy = new TriangleThree();
		andy.setTriangle("A",3);
		System.out.println(andy);
		andy.setTriangle("X", 7);
		System.out.println(andy);
		andy.setTriangle("R", 1);
		System.out.println(andy);
		andy.setTriangle("T", 5);
		System.out.println(andy);
	}

}
class TriangleThree
{
   private int size;
   private String letter;

	public TriangleThree()
	{
		setTriangle("a",1);
	}

	public TriangleThree(int count, String let)
	{
		size = count;
		letter = let;
	}

	public void setTriangle( String let, int sz )
	{
		letter= let;;
		size= sz;
		
	}

	public String getLetter()
	{
		
		String answer = "";
		for(int i = 1; i < size+1; i++){
			
			String spaces = "";
			
			for(int k = size - i; k > 0; k--){
				spaces = spaces + " ";
			}
			answer = spaces;
			for(int j = 0; j < i; j++){
				
				answer = answer +letter;
			}
			answer = answer + "\n" ;
		}
		return answer;
	}

	public String toString()
	{
		String output=getLetter();
		return output+"\n";
	}
}