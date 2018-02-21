package usacotraining;
import java.util.*;
import java.io.*;
import java.lang.Math;
public class hps {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("hps.in"));
		PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		int numObs = Integer.parseInt(br.readLine());
		int cntOne = 0; int cntTwo = 0;
		for(int i = 0; i < numObs; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int numOne = Integer.parseInt(st.nextToken());
			int numTwo = Integer.parseInt(st.nextToken());
			if(numOne % 3 > numTwo % 3){
				cntOne += 1;
			}
			else if(numOne% 3 < numTwo % 3){
				cntTwo += 1;
			}
		}
		pr.println(Math.max(cntOne, cntTwo));
		
	}

}
