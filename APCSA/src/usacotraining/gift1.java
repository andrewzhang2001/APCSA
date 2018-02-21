package usacotraining;

/*
ID:azhang21
LANG:JAVA
PROB: gift1
 */
import java.util.*;
import java.io.*;

public class gift1 {

	public static void main(String[] args) throws IOException {
		BufferedReader fin = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		int numPpl = Integer.parseInt(fin.readLine());
		String[] ppl = new String[numPpl];
		int[] money = new int[numPpl];
		for(int i = 0; i < numPpl; i++){
			StringTokenizer st = new StringTokenizer(fin.readLine());
			ppl[i] = st.nextToken();
			money[i] = 0;
		}
		String line, giver,receiver;
		int psn,moneyGive,moneyTo,psnrec;
		while((line = fin.readLine()) != null){
			giver = line;
			psn = Arrays.asList(ppl).indexOf(giver);
			StringTokenizer st = new StringTokenizer(fin.readLine());
			moneyGive = Integer.parseInt(st.nextToken());
			moneyTo = Integer.parseInt(st.nextToken());
			if (moneyTo == 0){
				continue;
			}
			for(int i = 0; i < moneyTo; i++){
				receiver = fin.readLine();
				psnrec = Arrays.asList(ppl).indexOf(receiver);
				money[psnrec] += moneyGive/moneyTo;
			}
			money[psn] -= (moneyGive/moneyTo)*moneyTo;
		}
		for (int i = 0; i < numPpl; i++){
			System.out.println(ppl[i] + " " + money[i]);
			pw.println(ppl[i] + " " + money[i]);
		}
		pw.close();
	}

}
