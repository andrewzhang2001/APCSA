package codeforces;
import java.util.*;
import java.io.*;
public class multimoo {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("multimoo.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("multimoo.out")));
		Set<Integer> cnt = new HashSet<Integer>();
		int n = Integer.parseInt(br.readLine());
		traversalHelper adam = new traversalHelper(n);
		int[][] bard = new int[n+2][n+2];
		for(int i=1;i<=n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++){
				int t = Integer.parseInt(st.nextToken());
				bard[i][j]=t+1;
				adam.setValue(i,j,t+1);
				cnt.add(t+1);
			}
		}
		int maxOne=0, maxhoriz=0, maxvert = 0;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				maxOne=Math.max(maxOne,adam.findMaxOcc(i, j, bard[i][j]));
			}
		}
		if(cnt.size()==n*n){
			String ans = maxOne+"\n2";
			pw.write(ans);
			pw.close();
			return;
		}
		if(cnt.size()==2||cnt.size()==1){
			String ans = maxOne+"\n"+(n*n);
			pw.write(ans);
			pw.close();
			return;
		}
		for(int i=1;i<=n;i++){
			for(int j=1;j<n;j++){
				maxhoriz=Math.max(maxhoriz,adam.findMaxOccHoriz(i, j));
			}
		}
		for(int i=1;i<n;i++){
			for(int j=1;j<=n;j++){
				maxvert=Math.max(maxvert,adam.findMaxOccVert(i, j));
			}
		}
		String ans = maxOne+"\n"+Math.max(maxhoriz, maxvert);
		pw.write(ans);
		pw.close();
		
		

	}
	static class traversalHelper{
		private int[][] board;
		private boolean[][] visited;
		private boolean[][] visited2;
		private boolean[][] visited3;
		private boolean[][][] pairseen;
		private int numlines;
		public traversalHelper(int n){
			board=new int[n+2][n+2];
			visited=new boolean[n+2][n+2];
			numlines = n;
			pairseen = new boolean[n+2][n+2][2];
		}
		public void setValue(int i, int j, int n){
			board[i][j]=n;
		}
		public int findMaxOcc(int r, int c, int target){
			int tempmax=0;
			if(!visited[r][c]&&board[r][c]==target){
				tempmax++;
				visited[r][c]=true;
				if(board[r+1][c]==target&&!visited[r+1][c])tempmax+=findMaxOcc(r+1,c,target);
				if(board[r-1][c]==target&&!visited[r-1][c])tempmax+=findMaxOcc(r-1,c,target);
				if(board[r][c+1]==target&&!visited[r][c+1])tempmax+=findMaxOcc(r,c+1,target);
				if(board[r][c-1]==target&&!visited[r][c-1])tempmax+=findMaxOcc(r,c-1,target);
			}

			return tempmax;
		}
		public int findMaxOccHoriz(int r, int c){
			int tempmax=0;
			if(pairseen[r][c][0]==true) return 0;
			if((board[r][c]!=board[r][c+1])){
				visited2 = new boolean[numlines+2][numlines+2];
				tempmax+=findMaxOccHorizHelper(r,c,board[r][c],board[r][c+1]);
			}

			return tempmax;
			
			
		}
		public int findMaxOccVert(int r, int c){
			
			int tempmax=0;
			if(pairseen[r][c][1]==true) return 0;
			if(board[r][c]!=board[r+1][c]){
				visited3=new boolean[numlines+2][numlines+2];
				tempmax+=findMaxOccVertHelper(r,c,board[r][c],board[r+1][c]);
			}
			return tempmax;
		}
		public int findMaxOccHorizHelper(int r, int c,int a, int b){
			int mymax=0;
			if((!visited2[r][c])&&(board[r][c]==a||board[r][c]==b)){
				visited2[r][c]=true;
				mymax++;
				if(board[r+1][c]==a||board[r+1][c]==b) {
					pairseen[r][c][1]=true;
					mymax+=findMaxOccHorizHelper(r+1,c,a,b);
				}
				if(board[r-1][c]==a||board[r-1][c]==b) {
					pairseen[r-1][c][1]=true;
					mymax+=findMaxOccHorizHelper(r-1,c,a,b);
				}
				if(board[r][c+1]==a||board[r][c+1]==b) {
					pairseen[r][c][0]=true;
					mymax+=findMaxOccHorizHelper(r,c+1,a,b);
				}
				if(board[r][c-1]==a||board[r][c-1]==b){
					pairseen[r][c-1][0]=true;
					mymax+=findMaxOccHorizHelper(r,c-1,a,b);
				}
			}
			return mymax;
		}
		public int findMaxOccVertHelper(int r, int c,int a, int b){
			int mymax=0;
			if((!visited3[r][c])&&(board[r][c]==a||board[r][c]==b)){
				visited3[r][c]=true;
				mymax++;
				if(board[r+1][c]==a||board[r+1][c]==b){
					pairseen[r][c][1]=true;
					mymax+=findMaxOccVertHelper(r+1,c,a,b);
				}
				if(board[r-1][c]==a||board[r-1][c]==b) {
					pairseen[r-1][c][1]=true;
					mymax+=findMaxOccVertHelper(r-1,c,a,b);
				}
				if(board[r][c+1]==a||board[r][c+1]==b){
					pairseen[r][c][0]=true;
					mymax+=findMaxOccVertHelper(r,c+1,a,b);
				}
				if(board[r][c-1]==a||board[r][c-1]==b){
					pairseen[r][c-1][0]=true;
					mymax+=findMaxOccVertHelper(r,c-1,a,b);
				}
			}
			return mymax;
		}
		
		
	}


}
