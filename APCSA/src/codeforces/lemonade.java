package codeforces;
import java.util.*;
import java.io.*;
public class lemonade {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("lemonade.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			input[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		int z=0;
		for(int i=n-1;i>=0;i--){
			if(input[i]>=z) z++;
		}
		pw.write(Integer.toString(z));
		pw.close();
	}
}
