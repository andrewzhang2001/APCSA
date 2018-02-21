package usacotraining;

/*
ID: azhang21
LANG:JAVA
PROG:beads
*/
import java.util.*;
import java.io.*;
import java.lang.Math;
public class beads {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("beads.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		int numBeads = Integer.parseInt(br.readLine());
		String beadOrd = br.readLine();
		String doubleBead = beadOrd + beadOrd;
		int maxval = 0;

		int indexCharOne = 0, indexCharTwo = 0;
		for(int i = 0; i < doubleBead.length(); i++){
			char foo = doubleBead.charAt(i);
			if(foo == 'r'){
				
			}
			
		}
		
		
		pw.println(Math.min(maxval,numBeads));
		pw.close();
		

	}

}