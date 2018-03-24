package codeforces;
import java.util.*;
import java.io.*;

public class family {
	private static int ancestorLevel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("family.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("family.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		String cowa = st.nextToken();
		String cowb = st.nextToken();
		String[] mothers = new String[n];
		String[] daughters = new String[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer stt = new StringTokenizer(br.readLine());
			mothers[i] = stt.nextToken();
			daughters[i] = stt.nextToken();
		}
		if (!highestAncestor(cowa, mothers, daughters).equals(highestAncestor(cowb, mothers, daughters))) {
			pw.write("NOT RELATED");
			pw.close();
			return;
		}
		if (isAncestor(cowa, cowb, mothers, daughters)) {
			String output = "mother";
			if (ancestorLevel >= 2) {
				output = "grand-" + output;
			}
			if (ancestorLevel > 2) {
				for (int i = 2; i < ancestorLevel; i++)
					output = "great-" + output;
			}
			pw.write(cowa + " is the " + output + " of " + cowb);
			pw.close();
			return;
		}
		if (isAncestor(cowb, cowa, mothers, daughters)) {
			String output = "mother";
			if (ancestorLevel >= 2) {
				output = "grand-" + output;
			}
			if (ancestorLevel > 2) {
				for (int i = 2; i < ancestorLevel; i++)
					output = "great-" + output;
			}
			pw.write(cowb + " is the " + output + " of " + cowa);

			pw.close();
			return;
		}
		String motherb = getMother(cowb, mothers, daughters);
		String mothera = getMother(cowa, mothers, daughters);
		if (isAncestor(motherb, cowa, mothers, daughters)) {
			if (ancestorLevel == 1) {
				pw.write("SIBLINGS");
				pw.close();
				return;
			}
			String output = "aunt";
			if (ancestorLevel > 2) {
				for(int i=2;i<ancestorLevel;i++){
					output = "great-" + output;
				}
			}
			pw.write(cowb + " is the " + output + " of " + cowa);
			pw.close();
			return;
		}
		if (isAncestor(mothera, cowb, mothers, daughters)) {
			if (ancestorLevel == 1) {
				pw.write("SIBLINGS");
				pw.close();
				return;
			}
			String output = "aunt";
			if (ancestorLevel > 2) {
				for(int i=2;i<ancestorLevel;i++){
					output = "great-" + output;
				}
			}
			pw.write(cowa + " is the " + output + " of " + cowb);

			pw.close();
			return;
		}
		pw.write("COUSINS");
		pw.close();
		return;

	}

	public static String highestAncestor(String name, String[] mothers, String[] daughters) {
		for (int i = 0; i < daughters.length; i++) {
			if (daughters[i].equals(name))
				return highestAncestor(mothers[i], mothers, daughters);
		}
		return name;
	}

	public static boolean isAncestor(String ancestor, String daughter, String[] mothers, String[] daughters) {
		if (ancestor.equals(daughter))
			return true;
		ancestorLevel++;
		for (int i = 0; i < daughters.length; i++) {
			if (daughters[i].equals(daughter))
				return isAncestor(ancestor, mothers[i], mothers, daughters);
		}
		ancestorLevel = 0;
		return false;
	}

	public static String getMother(String daughter, String[] mothers, String[] daughters) {
		for (int i = 0; i < daughters.length; i++) {
			if (daughters[i].equals(daughter))
				return mothers[i];
		}
		return " ";
	}

}
