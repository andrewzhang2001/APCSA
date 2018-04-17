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
			solver.solve(in, out,1);

			out.close();
		}
	
		// Problem Solver
		static class Problem {
			public void solve(InputReader in, PrintWriter out,int testCase) {
				int n = in.nextInt();
				
				
				//End Solver (There should be 2 parenthesis below)
			}
		}
		// Insert any additional methods/classes below below
		static class Board{
			private boolean[][] boardData;
			public Board(int n, String s){
				boardData = new boolean[n][n];
				for(int i=0;i<n*n;i++){
					boardData[i/n][i%n]=s.charAt(i)=='1'?true : false;
				}
				
			}
			public int evenIs1Parity(){
				for(int i=0;i<boardData.length)
			}
		}
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