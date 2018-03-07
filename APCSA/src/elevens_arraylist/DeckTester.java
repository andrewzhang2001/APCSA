package elevens_arraylist;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] adam = {"Jack", "Queen", "King"};
		String[] andy = {"Diamonds", "Hearts", "Spades"};
		int[] raymond = {96, 40, 2};
		Deck orrin = new Deck(adam, andy, raymond);
		System.out.println(orrin.size());
		orrin.shuffle();
		System.out.println(orrin);
		
	}
}