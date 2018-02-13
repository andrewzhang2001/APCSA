package unit6;
import java.lang.Math;
public class Lab08i {

	public static void main(String[] args) {
		PrimeTester adamdriver = new PrimeTester(24);
		adamdriver.print();
		adamdriver.setValue(7);
		adamdriver.setValue(100);
		adamdriver.setValue(113);
		adamdriver.setValue(65535);
		adamdriver.setValue(2);
		adamdriver.setValue(7334);
		adamdriver.setValue(7919);
		adamdriver.setValue(1115125003);
	}

}
class PrimeTester{
	private int a;
	public PrimeTester(int b){
		a = b;
	}
	public void setValue(int c){
		a = c;
		this.print();
	}
	public boolean tester (){
		for (int i = 2; i <= a / Math.sqrt(a); i++){
			if (a % i == 0){
				return true;
			}
		}
		return false;
	}
	public void print(){
		if (this.tester()){
			System.out.println(a +" is composite");
		}
		else{
			System.out.println(a +" is prime");
		}

	}
}
