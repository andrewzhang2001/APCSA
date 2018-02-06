package unit1;

import java.util.Random;

public class DieSimulator {
	public static void main(String[] args){
		boolean zero = true;
		Random riggedDie = new Random();
		while (zero = true){
			int i = riggedDie.nextInt(7);
			if (i != 0){
				System.out.println(i);
				break;
			}
		}
		
	}
}
