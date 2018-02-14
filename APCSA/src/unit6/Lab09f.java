package unit6;

public class Lab09f {

	public static void main(String[] args) {
		LetterRemover bob = new LetterRemover();
		bob.setRemover("I am Sam I am", 'a');
		
		bob.setRemover("ssssssssxssssesssssesss", 's');
		
		bob.setRemover("qwertyqwertyqwerty", 'a');
		
		bob.setRemover("abababababa", 'b');
		
		bob.setRemover("abaababababa", 'x');
		
	}

}
class LetterRemover{
	private String sentence;
	private char lookFor;
	public LetterRemover(){
		
	}
	public LetterRemover(String a, char b){
		setRemover(a,b);
	}
	public void setRemover(String in, char rem){
		sentence = in;
		lookFor = rem;
		System.out.println(this);
		removedLetters();
		System.out.println(this.removedLetters() + "\n");
	}
	public String removedLetters(){
		while(sentence.indexOf(lookFor) != -1){
			sentence = sentence.replaceAll(String.valueOf(lookFor), "");
		}
		return sentence;
	}
	public String toString(){
		return sentence + " -letter to remove " + lookFor;
	}
}