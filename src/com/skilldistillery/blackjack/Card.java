package com.skilldistillery.blackjack;

public class Card {

	private Suit suit;
	private Rank rank;

	Card(Suit suit, Rank rank) {
		setRank(rank);
		setSuit(suit);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

	public String toString() {
		return rank + " of " + suit;
	}

	public String blind() {
		return "FACEDOWN to dealer.";
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public int getValue() {
		return rank.getValue();
	}

	public String toDealer() {
		return rank + " of " + suit + " to dealer.";

	}
	public String toPlayer() {
		return rank + " of " + suit + " to player.";
		
	}
}
