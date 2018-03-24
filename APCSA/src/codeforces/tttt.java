package codeforces;
import java.util.*;
import java.io.*;
public class tttt {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("tttt.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));
		char[][] board = new char[3][3];
		for(int i=0;i<3;i++){
			String temp = br.readLine();
			for(int j=0;j<3;j++){
				board[i][j]=temp.charAt(j);
			}
		}
		int indivwin=0;
		int doubwin=0;
		boolean[] seen=new boolean[26];
		for(int i=0;i<3;i++){
			if(board[i][0]==board[i][1]&&board[i][1]==board[i][2]){
				if(!seen[board[i][0]-65]){
					indivwin++;
					seen[board[i][0]-65]=true;
				}

			}
			if(board[0][i]==board[1][i]&&board[1][i]==board[2][i]) {
				if(!seen[board[0][i]-65]){
					indivwin++;
					seen[board[0][i]-65]=true;
				}
			}
		}
		if(board[0][0]==board[1][1]&&board[1][1]==board[2][2]){
			if(!seen[board[1][1]-65]){
				indivwin++;
				seen[board[1][1]-65]=true;
			}
		}
		if(board[2][0]==board[1][1]&&board[1][1]==board[0][2]){
			if(!seen[board[1][1]-65]){
				indivwin++;
				seen[board[1][1]-65]=true;
			}
		}
		String indiv=indivwin+"\n";
		boolean[][] saw=new boolean[26][26];
		for(int i=0;i<3;i++){
			if(board[i][0]==board[i][1]&&board[i][1]!=board[i][2]) {
				if(!saw[board[i][0]-65][board[i][2]-65]){
					doubwin++;
					saw[board[i][0]-65][board[i][2]-65]=true;
					saw[board[i][2]-65][board[i][0]-65]=true;
				}
			}
			if(board[i][0]==board[i][2]&&board[i][1]!=board[i][2]){
				if(!saw[board[i][0]-65][board[i][1]-65]){
					doubwin++;
					saw[board[i][0]-65][board[i][1]-65]=true;
					saw[board[i][1]-65][board[i][2]-65]=true;
				}
			}
			if(board[i][1]==board[i][2]&&board[i][0]!=board[i][2]){
				if(!saw[board[i][0]-65][board[i][2]-65]){
					doubwin++;
					saw[board[i][0]-65][board[i][2]-65]=true;
					saw[board[i][2]-65][board[i][0]-65]=true;
				}
			}
			if(board[0][i]==board[1][i]&&board[1][i]!=board[2][i]){
				if(!saw[board[i][0]-65][board[i][2]-65]){
					doubwin++;
					saw[board[1][i]-65][board[2][i]-65]=true;
					saw[board[2][i]-65][board[1][i]-65]=true;
				}
			}
			if(board[0][i]==board[2][i]&&board[1][i]!=board[2][i]){
				if(!saw[board[1][i]-65][board[2][i]-65]){
					doubwin++;
					saw[board[1][i]-65][board[2][i]-65]=true;
					saw[board[2][i]-65][board[1][i]-65]=true;
				}
			}
			if(board[0][i]!=board[1][i]&&board[1][i]==board[2][i]){
				if(!saw[board[0][i]-65][board[1][2]-65]){
					doubwin++;
					saw[board[0][i]-65][board[1][i]-65]=true;
					saw[board[1][i]-65][board[0][i]-65]=true;
				}
			}
		}
		if(board[0][0]==board[1][1]&&board[1][1]!=board[2][2]){
			if(!saw[board[1][1]-65][board[2][2]-65]){
				doubwin++;
				saw[board[1][1]-65][board[2][2]-65]=true;
				saw[board[2][2]-65][board[1][1]-65]=true;
			}
		}
		if(board[0][0]==board[2][2]&&board[1][1]!=board[2][2]){
			if(!saw[board[1][1]-65][board[2][2]-65]){
				doubwin++;
				saw[board[1][1]-65][board[2][2]-65]=true;
				saw[board[2][2]-65][board[1][1]-65]=true;
			}
		}
		if(board[0][0]!=board[1][1]&&board[1][1]==board[2][2]){
			if(!saw[board[1][1]-65][board[0][0]-65]){
				doubwin++;
				saw[board[1][1]-65][board[0][0]-65]=true;
				saw[board[0][0]-65][board[1][1]-65]=true;
			}
		}
		if(board[0][2]==board[1][1]&&board[1][1]!=board[2][0]){
			if(!saw[board[1][1]-65][board[2][0]-65]){
				doubwin++;
				saw[board[1][1]-65][board[2][0]-65]=true;
				saw[board[2][0]-65][board[1][1]-65]=true;
			}
		}
		if(board[0][2]==board[2][0]&&board[1][1]!=board[2][0]){
			if(!saw[board[1][1]-65][board[2][0]-65]){
				doubwin++;
				saw[board[1][1]-65][board[2][0]-65]=true;
				saw[board[2][0]-65][board[1][1]-65]=true;
			}
		}
		if(board[0][2]!=board[1][1]&&board[1][1]==board[2][0]){
			if(!saw[board[1][1]-65][board[2][2]-65]){
				doubwin++;
				saw[board[1][1]-65][board[0][2]-65]=true;
				saw[board[0][2]-65][board[1][1]-65]=true;
			}
		}
		String ans = indiv+doubwin+"\n";
		pw.write(ans);
		pw.close();

	}

}
