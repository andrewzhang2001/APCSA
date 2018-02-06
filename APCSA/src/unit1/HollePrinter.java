package unit1;

public class HollePrinter {
	public static void main(String[] args){
		System.out.println("Hello World");
		String helloWorld = " ";
		helloWorld = "Hello World!";
		String bob = helloWorld.replace('e', '^');
		String skrrraa = bob.replace('o', 'e');
		String poppop = skrrraa.replace('^','o');
		System.out.println(poppop);
	}
}



