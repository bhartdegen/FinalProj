import java.util.ArrayList;
import java.util.Random;

public class Deck {
	Random random = new Random();
	
	private ArrayList<Cards> cDeck = new ArrayList<Cards>(52);
	private ArrayList<Cards> shuffleDeck = new ArrayList<Cards>(52);
	
	public Deck() {
		String suit = "";
		String rank = "";
		
		//Assign cards suits and ranks for cDeck
		for(int i = 0; i < 4; i++) {
			if (i == 0) {
				suit = "CLUBS";
			} else if (i == 1) {
				suit = "HEARTS";
			} else if (i == 2) {
				suit = "SPADES";
			} else if (i == 3) {
				suit = "DIAMONDS";
			}
			for (int y = 1; y <= 13; y++) {
				if (y == 1) {
					rank = "ACE";
				} else if (y > 1 && y < 11) {
					rank = "" + y;
				} else if (y == 11) {
					rank = "JACK";
				} else if (y == 12) {
					rank = "QUEEN";
				} else if (y == 13) {
					rank = "KING";
				}
				Cards card = new Cards(suit, rank);
				cDeck.add(card);
			}
		}
	}
	
	//When card is drawn from a shuffled deck of cards
	public Cards getShuffledDeck(int x) {
		if(!shuffleDeck.isEmpty())
				return shuffleDeck.get(x);
		return null;
	}
	
	public void Shuffle() {
		ArrayList<Integer> usednums = new ArrayList<>(52);
		int counter = 0;
		while (counter < 52) {
			int cardNum = random.nextInt((51-0)+1);
			while (usednums.indexOf(cardNum) == -1) {
				usednums.add(counter,cardNum);
				shuffleDeck.add(counter, cDeck.get(cardNum));
				counter++;
			}
		}
	}
}

