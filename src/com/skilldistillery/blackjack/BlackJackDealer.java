package com.skilldistillery.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackJackDealer extends Player implements HouseRules {

	final boolean houseRule = (getHand().getHandValue() < 17);

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

	public Card dealFirstRound(BlackJackPlayer player, Scanner kb) {
		Card card = deck.removeCard();
		getHand().add(card);
		System.out.println(card.toHouse());
		card = deck.removeCard();
		player.getHand().add(card);
		System.out.println(card.toPlayer());
		card = deck.removeCard();
		Card theBlind = deck.removeCard();
		System.out.println(theBlind.toHouseBlind());
		getHand().add(theBlind);
		card = deck.removeCard();
		player.getHand().add(card);
		System.out.println(card.toPlayer());
		System.out.println("Dealer Shown: " + (getHand().getHandValue() - theBlind.getValue()));
		System.out.println("Player Hand: " + player.getHandValue(player.getHand()));
		continueRound(player, kb);
		return theBlind;
	}

	public void continueRound(BlackJackPlayer player, Scanner kb) {
		System.out.println("[1 HIT][2 STAND]");
		int input = kb.nextInt();
		Card card;
		switch (input) {
		case 1:
			card = deck.removeCard();
			player.getHand().add(card);
			System.out.println(card.toPlayer());
		case 2:
			if (houserule) {
				card = deck.removeCard();
				getHand().add(card);
				System.out.println(card.toHouse());
			}
		default:
			break;
		}
	}

	public String continueRound(BlackJackPlayer player) {
		String string = "";

		return string;
	}

	@Override
	public String checkWins(int houseHandValueFinal, int playerHandValueFinal) {
		String string = null;
		if (playerHandValueFinal == houseHandValueFinal) {
			string = "PUSH";
		}
		if (houseHandValueFinal < 17 ) {
			string = null;
		}
		if (houseHandValueFinal > 21) {
			string = "DEALER BUSTS, PLAYER COLLECTS";
		}
		if (playerHandValueFinal > 21) {
			string = "PLAYER BUSTS, HOUSE COLLECTS";
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