package usacotraining;
/*
ID: azhang21
LANG:JAVA
PROG:friday
*/
import java.util.*;
import java.io.*;
public class friday {

	public static void main(String[] args) throws IOException {
		BufferedReader fin = new BufferedReader(new FileReader("friday.in"));
		
		int numYears = Integer.parseInt(fin.readLine());
		Counting cn = new Counting(numYears);
		
	}

}
class Counting{
	private int year = 1900;
	private int day = 1;
	private int[] normList = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30,31};
	private int[] leapList = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static int[] counter = new int[7];
	public Counting(int n) throws IOException{
		for(int i = 0; i < n; i++){
			if((year % 4 == 0 && year % 100 != 0 )|| year % 400 == 0){
				LeapYear();
			}
			else{
				NormYear();
			}
			year += 1;
		}
		print();
	}
	public void LeapYear(){
		for(int i = 0; i < 12; i++){
			int modulo = (day - 2) % 7;
			while(modulo <0){
				modulo += 7;
			}
			counter[modulo] += 1;
			day += leapList[i];
		}
	}
	public void NormYear(){
		for(int i = 0; i < 12; i++){
			int modulo = (day - 2) % 7;
			while(modulo <0){
				modulo += 7;
			}
			counter[modulo] += 1;
			day += normList[i];
		}
	}
	public void print() throws IOException{
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
		int j;
		for (int i = -1; i < 5; i++){
			if(i <0){
				j = i + 7;
			}
			else{
				j = i;
			}
			pw.print(	counter[j] + " ");
		}
		pw.print(counter[5] + "\n");
		pw.close();
	}
}
