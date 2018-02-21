package usacotraining;
/*
 * ID:azhang21
 * LANG:JAVA
 * TASK: ride
 */

import java.util.*;
import java.io.*;
public class ride {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		PrintWriter pw = new PrintWriter((new BufferedWriter(new FileWriter("ride.out"))));
		String wordOne = f.readLine();
		String wordTwo = f.readLine();
		int productOne = 1, productTwo = 1;
		for(int i = 0; i < wordOne.length(); i++){
			productOne *= (int) wordOne.charAt(i)-64;
		}
		for(int i =0; i < wordTwo.length(); i++){
			productTwo *=  (int) wordTwo.charAt(i) - 64;
		}
		boolean go = productOne%47 == productTwo % 47; 
		if (go){
			pw.println("GO");
		}
		else{
			pw.println("STAY");
		}
		pw.close();
	}

}
