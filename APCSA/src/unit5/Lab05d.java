package unit5;
import java.util.Scanner;
public class Lab05d {

	public static void main(String[] args) {
		AnalyzeChar newchar = new AnalyzeChar();
		newchar.setChar('A');
		newchar.setChar('1');
		newchar.setChar('a');
		newchar.setChar('7');
		newchar.setChar('D');
		newchar.setChar('2');
		newchar.setChar('X');
		newchar.setChar('z');
		newchar.setChar('9');
		
	}

}
class AnalyzeChar{
	private char xd;
	private String dinput;
	public AnalyzeChar(){
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a letter:");
		dinput = keyboard.nextLine();
		xd = dinput.charAt(0);
		outputfile();
	}
	public AnalyzeChar(char a){
		xd = a;
		outputfile();
	}
	public void setChar(char a){
		xd = a;
		outputfile();
	}
	public void outputfile(){
		if (xd >= 48 && xd <= 57){
		System.out.println(xd + " is a number. ASCII = " + (int)xd);
		}
		else if (xd >= 65 && xd <= 90){
		System.out.println(xd + " is a capital letter. ASCII = " + (int)xd);
		}
		else if (xd >= 97 && xd <= 122){
		System.out.println(xd + " is a lowercase letter. ASCII = " + (int)xd);
		}
	}
}