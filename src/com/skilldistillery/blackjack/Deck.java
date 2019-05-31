package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> deck;

	public Deck() {
		deck = newDeck();
	}

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	private List<Card> newDeck() {
		List<Card> deck = new ArrayList<>(52);
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(suit, rank));
			}
		}
		return deck;
	}

	public int checkDeckSize() {
		int deckSize = deck.size();
		return deckSize;
	}

	public Card dealCard() {
		return deck.remove(0);
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

}
