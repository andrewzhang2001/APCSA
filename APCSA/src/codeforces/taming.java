package codeforces;
import java.util.*;
import java.io.*;
public class taming {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("taming.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
		int n = Integer.parseInt(br.readLine());
		int[] log = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			log[i]=Integer.parseInt(st.nextToken());
		}
		boolean possible = true;
		int posdays=0;
		int zerocnt = 0;
		for(int i=0;i<n;i++){
			if (log[i]!=0){
				for(int j=1;j<=log[i];j++){
					if(log[i-j]!=-1&&log[i-j]+j!=log[i]) possible = false;
					else log[i-j]=log[i]-j;
				}
			}
		}
		if(!possible){
			pw.write("-1");
			return;
		}
		for(int i:log){
			if (i==0)zerocnt++;
			else if(i==-1)posdays++;
		}
		String ans = zerocnt+" "+posdays;
		pw.write(ans);
		
	}
}
