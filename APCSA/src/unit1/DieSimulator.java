package unit1;

import java.util.Random;

public class DieSimulator {
	public static void main(String[] args){
		Random riggedDie = new Random();
		System.out.println(riggedDie.nextInt(6)+1);
	}
}
