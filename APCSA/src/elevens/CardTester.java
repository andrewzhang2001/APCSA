package elevens;

public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card silver = new Card("Ace", "Hearts", 750);
		Card gold = new Card("3", "Clubs", 419);
		Card platon = new Card("2", "Spades", 12);
		System.out.println(platon.matches(silver));
		System.out.println(platon.suit());
		System.out.println(platon.rank());
		System.out.println(platon.pointValue());
		System.out.println(gold);
	}
}