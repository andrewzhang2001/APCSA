package unit7;

public class Lab11J
{
   public static void main(String args[])
   {
	   Triples pythagoras = new Triples(110);
	   System.out.println(pythagoras);
	}
}
class Triples
{
   private int number;

	public Triples()
	{
		
	}

	public Triples(int num)
	{
		setNum(num);

	}

	public void setNum(int num)
	{
		number = num;

	}
	
	private int greatestCommonFactor(int a, int b, int c)
	{
		int afactor = a;
		int bfactor = b;
		int cfactor = c;
		int buffer;
		while(bfactor % afactor != 0){
			bfactor -= afactor;
			if(afactor > bfactor){
				buffer = afactor;
				afactor = bfactor;
				bfactor = buffer;
			}
			if(afactor == 1){
				return 1;
			}
		}
		while(cfactor % afactor != 0){
			cfactor -= afactor;
			if(afactor > bfactor){
				buffer = afactor;
				afactor = bfactor;
				bfactor= buffer;
			}
			if(afactor == 1){
				return 1;
			}
		}
		return afactor;

	}

	public String toString()
	{
		String printstatement = "";
		for(int i = 1; i < number; i ++){
			for(int j = i;j < number -1; j++){
				for(int k = j; k < number; k++){
					if(k * k != i * i + j * j){
						continue;
					}
					if( greatestCommonFactor(i,j,k) == 1&&(i % 2 != j % 2) && k % 2 == 1){
						printstatement = printstatement + i + " " + j + " " + k + "\n";
					
				}
				
				
			}
		}
		
	}
		return printstatement+"\n";
}
	}