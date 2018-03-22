package codeforces;

import java.lang.Math;
import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Problem solver = new Problem();
		solver.solve(in, out);
		out.close();
	}

	// Problem Solver
	static class Problem {
		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			int counter=1;
			String[] w=new String[n];
			for(int i=0;i<n;i++){
				w[i]=in.next();
			}
			boolean possible=true;
			for(int i=1;i<n;i++){
				int absdiff = Math.abs(Integer.parseInt(w[i])-Integer.parseInt(w[i-1]));
				int diff = Math.abs(Integer.parseInt(w[i])-Integer.parseInt(w[i-1]));
				if(absdiff==1){
					continue;
				} 
				if(counter==1){
					if(diff>=-1){
						counter=absdiff;
						continue;
					}
					else{

						possible = false;
						break;
					}
				}
				if(absdiff!=counter){

					possible = false;
					break;
				}
			}
			if(possible&&counter>1){
				for(int i=1;i<n;i++){
					int a=Integer.parseInt(w[i]);
					int b=Integer.parseInt(w[i-1]);
					if(a%counter==0&&b%counter==1&&b-a==1||b%counter==0&&a%counter==1&&a-b==1){

						possible=false;
						break;
					}
				}
			}
			if(possible){
				System.out.println("YES");
				System.out.println("1000000000 "+counter);
			}
			else{
				System.out.println("NO");
			}
		}

	}
	// Insert any additional methods/classes below below

	// Do not touch
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 500000);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

	}
}