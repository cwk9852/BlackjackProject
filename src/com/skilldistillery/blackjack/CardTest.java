package com.skilldistillery.blackjack;

public class CardTest {
	public static void main(String[] args) {
		Rank[] ranks = Rank.values();
		for (int i = 0; i < ranks.length; i++) {
			System.out.println(ranks[i] + " " + ranks[i].getValue());
		}

		for (Suit s : Suit.values()) {
			System.out.println(s);
		}
		Deck firstDeck = new Deck();
		firstDeck.shuffle();
		for (int i = 0; i < 52 ; i++) {
			System.out.println(firstDeck.getDeck().remove(0));
		}
	}
}
