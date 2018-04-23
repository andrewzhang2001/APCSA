package linearAlgebra;
import java.lang.Math;
public class MixedNumber implements Comparable{
	//PRIVATE VARIABLES
	private int numerator, denominator;
	//CONSTRUCTORS
	public MixedNumber(int n){
		numerator = n;
		denominator = 1;
	}
	public MixedNumber(int numerator, int denominator){
		this.numerator=numerator;
		this.denominator=denominator;
	}
	public MixedNumber(String fraction){
		int slashLocation = fraction.indexOf('/');
		numerator = Integer.parseInt(fraction.substring(0, slashLocation));
		denominator = Integer.parseInt(fraction.substring(slashLocation+1,fraction.length()));
	}
	public static MixedNumber valueOf(int n){
		return new MixedNumber(n);
	}
	//GET & SET METHODS
	public int getNumerator(){
		return numerator;
	}
	public int getDenominator(){
		return denominator;
	}
	public void setNumerator(int n){
		numerator = n;
	}
	public void setDenominator(int n){
		denominator = n;
	}
//MIXED NUMBER HELPER OPERATIONS
	public int GCD(int a, int b) {
		   if (b==0) return a;
		   return GCD(b,a%b);
	}
	public MixedNumber ratioOfMultiplication(MixedNumber m){
		return dividedBy(m);
	}
//MIXED NUMBER OPERATIONS	
	public void simplify(){
		int gcd = GCD(numerator,denominator);
		numerator = numerator / gcd;
		denominator = denominator / gcd;
	}
	public MixedNumber add(MixedNumber m){
		int lcmDenom = m.getDenominator()*this.getDenominator()/GCD(m.getDenominator(),this.getDenominator());
		int numerator = this.getNumerator()*lcmDenom/this.getDenominator()+m.getNumerator()*lcmDenom/m.getDenominator();
		return new MixedNumber(numerator, lcmDenom);
	}
	public void addToSelf(MixedNumber m){
		int lcmDenom = m.getDenominator()*this.getDenominator()/GCD(m.getDenominator(),this.getDenominator());
		int tempNumerator = this.getNumerator()*lcmDenom/this.getDenominator()+m.getNumerator()*lcmDenom/m.getDenominator();
		denominator = lcmDenom;
		numerator = tempNumerator;
	}
	public MixedNumber subtract(MixedNumber m){
		m.setNumerator(-1*m.getNumerator());
		return this.add(m);
	}
	public void subtractToSelf(MixedNumber m){
		m.setNumerator(-1*m.getNumerator());
		this.addToSelf(m);
	}
	public MixedNumber multiply(MixedNumber m){
		int n = this.getNumerator()*m.getNumerator();
		int d = this.getDenominator()*m.getDenominator();
		MixedNumber ans = new MixedNumber(n,d);
		ans.simplify();
		return ans;
	}
	public void multiplyToSelf(MixedNumber m){
		numerator *=m.getNumerator();
		denominator *= m.getDenominator();
		this.simplify();
	}
	public MixedNumber dividedBy(MixedNumber m){
		int n = this.getNumerator()*m.getDenominator();
		int d = this.getDenominator()*m.getNumerator();
		MixedNumber ans = new MixedNumber(n,d);
		ans.simplify();
		return ans;
	}
	public void dividedByToSelf(MixedNumber m){
		numerator*=m.getDenominator();
		denominator*=m.getNumerator();
		this.simplify();
	}
	//COMPARE METHOD
	public int compareTo(Object o){
		if(o instanceof MixedNumber){
			MixedNumber m = (MixedNumber) o;
			int thisWeight = this.getNumerator()*m.getDenominator();
			int thatWeight = this.getDenominator()*m.getNumerator();
			if(thisWeight > thatWeight) return 1;
			else if(thisWeight<thatWeight) return -1;
			return 0;
		}
		else if(o instanceof Integer){
			int m = (Integer) o;
			return this.getNumerator()-m*this.getDenominator();
		}
		else return 0;
	}
	public String toString(){
		this.simplify();
		if(denominator == 1) return ""+numerator;
		return numerator + "/"+denominator;
	}
}
