package gold2018;
import java.util.*;
import java.io.*;

public class talent {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("talent.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("talent.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		Cow[] mycows = new Cow[n];
		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			mycows[i]=new Cow(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(mycows);
		int totWeight =0;
		int totTalent =0;
		for(int i=n-1;i>=0;i--){
			if(totWeight>=w){
				pw.write(Integer.toString((int) (1000.0*totTalent/totWeight)));
				pw.close();
				return;
			}
			int weightRemaining = w-totWeight;
			int nextTalent = mycows[i].getTalent();
			int j=i;
			ArrayList<Cow> sameTalent = new ArrayList<Cow>();
			while(j>=0&&mycows[j].getTalent()==nextTalent){
				sameTalent.add(mycows[j]);
				j--;
			}

		}
	}

}
class Cow implements Comparable<Cow>{
	private int weight;
	private int talent;
	public Cow(int w, int t){
		weight = w;
		talent = t;
	}
	public int getWeight(){
		return weight;
	}
	public int getTalent(){
		return talent;
	}
	public int compareTo(Cow c){
		if (getTalent()*c.getWeight()>c.getTalent()*getWeight()) return 1;
		if (getTalent()*c.getWeight()<c.getTalent()*getWeight()) return -1;
		return 0;
	}
}
