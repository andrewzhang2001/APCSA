package unit1;

public class HollePrinter {
	public static void main(String[] args){
		System.out.println("Hello World");
		String helloWorld = " ";
		helloWorld = "Hello World!";
		String ting = helloWorld.replace('e', '^');
		String skrrraa = ting.replace('o', 'e');
		String poppopkakaka = skrrraa.replace('^','o');
		System.out.println(poppopkakaka);
	}
}



