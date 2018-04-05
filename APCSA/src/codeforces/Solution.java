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
				int k = in.nextInt();
				int[] counter = new int[n];
				for(int i=0;i<k;i++){
					counter[in.nextInt()-1]++;
				}
				int minval = counter[0];
				for(int i=1;i<n;i++){
					if (counter[i]>minval) minval = counter[i];
				}
				System.out.println(minval);
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