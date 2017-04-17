import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
	
	private ArrayList<Card> cards;
	
	public Deck() {
		cards = new ArrayList<Card>(52);
		for (Suit suit : Suit.values()) {
			for (int j = 1; j < 14; j++) {
				cards.add(new Card(suit, j));
			}
		}
	}
	
	public Card draw() {
		int sizeOfDeck = cards.size();
		if (sizeOfDeck > 0) {
			return cards.remove(sizeOfDeck - 1);
		} else {
			return null;
		}
	}
	
	public void addCard(Card card) {
		if (cards.size() < 52) {
			cards.add(card);
		}
	}
	
	public void shuffle() {
		long seed = System.nanoTime();
		Collections.shuffle(cards, new Random(seed));
	}
	
	public void printDeck() {
		Card card;
		int sizeOfDeck = cards.size();
		if (sizeOfDeck > 0) {
			for (int i = 0; i < sizeOfDeck; i++) {
				card = cards.get(i);
				System.out.print("(" + card.getSuit() + ", " + card.getValue() + ")");
			}
			System.out.println("");
		}
	}
}
