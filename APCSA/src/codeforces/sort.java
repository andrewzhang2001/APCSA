package codeforces;
import java.util.*;
import java.io.*;
import java.lang.Math;
public class sort {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("sort.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[(int)Math.pow(10, 8)+1];
		SortedSet<Integer> vals= new TreeSet<>();
		int[] dp2 = new int[(int)Math.pow(10, 8)+1];
		for(int i=0;i<n;i++){
			int t = Integer.parseInt(br.readLine());
			dp[t]++;
			vals.add(t);
			dp2[t]=i;
		}
		int index =0;
		int maxval=0;
		for(int i:vals){
			index=index+dp[i]-1;
			maxval = Math.max(maxval, dp2[i]-index);
			index++;
		}
		pw.write(Integer.toString(maxval+1));
		pw.close();
	}

}
