package codeforces;
import java.lang.Math;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem solver = new Problem();
        solver.solve(in, out);
        out.close();
    }
//Problem Solver
    static class Problem {
        public void solve(InputReader in, PrintWriter out) {
        	//Start of Solution
            	int r=in.nextInt();int c=in.nextInt();
            	char[][]sheepwolf=new char[r][c];
            	for(int i=0;i<r;i++){
            		String temp = in.next();
            		for(int k=0;k<c;k++){ 
            			sheepwolf[i][k]=temp.charAt(k);
            		}
            	}
            	
            }
            //End of Solution
           }

//Insert any additional methods/classes below below

    
//Do not touch
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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