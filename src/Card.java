
public class Card implements Comparable<Card> {
	
	private Suit suit;
	private int value;
	
	public Card(Suit suit, int value) {
		this.suit = suit;
		this.value = value;
	}
	
	public Suit getSuit() {
		return this.suit;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String toString() {
		return "(" + getValueString() + ", " + this.suit + ")";
	}
	
	public boolean isHigherThan(Card b) {
		return this.compareTo(b) > 0;
	}
	
	public boolean isEqualTo(Card b) {
		return this.compareTo(b) == 0;
	}
	
	public boolean isLowerThan(Card b) {
		return this.compareTo(b) < 0;
	}

	@Override
	public int compareTo(Card o) {
		Integer a = new Integer(this.value);
		Integer b = new Integer(o.value);
		return a.compareTo(b);
	}
	
	public String getValueString() {
		switch (this.value) {
		case 1:
			return "Ace";
		case 11:
			return "Jack";
		case 12:
			return "Queen";
		case 13:
			return "King";
		default:
			return Integer.toString(this.value);
		}
	}
}
