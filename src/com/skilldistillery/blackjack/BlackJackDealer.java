package com.skilldistillery.blackjack;

import java.util.InputMismatchException;

public class BlackJackDealer extends Player {

	private Deck deck;

	BlackJackDealer() {
		deck = new Deck();
	}

	public int getHandValue(Hand hand) {
		return hand.getHandValue();
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Card dealCard(Player name) {
		Card card = null;
		try {
			if (deck.checkDeckSize() < 1) {
				throw new IndexOutOfBoundsException();
			} else {
				card = deck.removeCard();
				name.getHand().add(card);
				return card;
			}
		} catch (InputMismatchException e) {
			System.out.println("Not an integer");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Not enough cards.");
		}
		return card;
	}

	public void dealCards(Player name, int howMany) {
		for (int i = 0; i < howMany; i++) {
			Card card = dealCard(name);
			name.getHand().add(card);
		}
	}

	public String playHouseRules() {
		String string = "";
		final boolean houseRule = (getHand().getHandValue() < 17);
		if (houseRule) {
			Card card = deck.removeCard();
			getHand().add(card);
			string = "[Dealer Hits: " + card.toDealer() + "]";
		} else {
			string = "[Dealer Stays]";
		}
		return string;
	}

	public void checkForWinner() {
		if (getHand().getHandValue() > 17) {

		}
	}

	public Card turnBlind(Card theBlind) {
		return theBlind;
	}

	public String announceHandResult(int playerHandValueFinal, int houseHandValueFinal) {
		String string = "";
		if (playerHandValueFinal == houseHandValueFinal) {
			string = "PUSH";
		}
		if (houseHandValueFinal > 21) {
			string = "DEALER BUST, HOUSE PAYS";
		}
		if (playerHandValueFinal > 21) {
			string = "PLAYER BUST, HOUSE COLLECTS";
		}
		if (playerHandValueFinal == 21) {
			string = "PLAYER BLACKJACK";
		}
		if (houseHandValueFinal == 21) {
			string = "DEALER BLACKJACK";
		}
		return string;
	}
}