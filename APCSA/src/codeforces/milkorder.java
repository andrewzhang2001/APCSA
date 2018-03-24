package codeforces;
import java.util.*;
import java.io.*;

public class milkorder {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milkorder.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milkorder.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] order = new int[n + 1];
		order[0] = -1;
		int[] sh = new int[m];
		StringTokenizer stt = new StringTokenizer(br.readLine());
		boolean oneInSH = false;
		for (int i = 0; i < m; i++) {
			sh[i] = Integer.parseInt(stt.nextToken());
			if (sh[i] == 1)
				oneInSH = true;
		}
		for (int i = 0; i < k; i++) {
			StringTokenizer sttt = new StringTokenizer(br.readLine());
			int cown = Integer.parseInt(sttt.nextToken());
			int cowp = Integer.parseInt(sttt.nextToken());
			order[cowp] = cown;
			if (cown == 1) {
				pw.write(Integer.toString(cowp));
				pw.close();
				return;
			}
		}

		if (!oneInSH) {
			int lastindex = n;
			for (int i = m - 1; i >= 0; i--) {
				boolean exists = false;
				for (int j = 1; j <= n; j++) {
					if (order[j] == sh[i]) {
						exists = true;
						lastindex = j;
					}
				}

				if (exists)
					continue;
				for (int z = lastindex; z >= 1; z--) {
					if (order[z] == 0) {
						order[z] = sh[i];
						lastindex = z;
						break;
					}
				}
			}
		}
		else{
			int firstindex =0;
			for(int i = 0; i < m; i++){
				boolean exists = false;
				for(int j = 1; j<=n;j++){
					if(order[j]==sh[i]){
						exists = true;
						firstindex = j;
						break;
					}
				}
				if (exists) continue;
				for(int z = firstindex; z<=n; z++){
					if (order[z]==0){
						order[z]=sh[i];
						firstindex =z;
						break;
					}
				}
				if(sh[i]==1){
					pw.write(Integer.toString(firstindex));
					pw.close();
					return;
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			if (order[i] == 0) {
				pw.write(Integer.toString(i));
				pw.close();
				break;
			}

		}
		pw.close();

	}

}
