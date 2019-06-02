package com.skilldistillery.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackJackDealer extends Player implements HouseRules {

	boolean houseRule = (getHand().getHandValue() < 17);

	private Deck deck;

	BlackJackDealer() {
		deck = new Deck();
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

	public Card dealNewHand(BlackJackPlayer player, Scanner kb) {
		Card card = deck.removeCard();
		player.getHand().add(card);
		System.out.println(card.toPlayer());
		card = deck.removeCard();
		getHand().add(card);
		System.out.println(card.toHouse());
		card = deck.removeCard();
		card = deck.removeCard();
		player.getHand().add(card);
		System.out.println(card.toPlayer());
		Card theBlind = deck.removeCard();
		System.out.println(theBlind.toHouseBlind());
		getHand().add(theBlind);
		return theBlind;
	}

	public Card continueRound(BlackJackPlayer player, Scanner kb, Card theBlind) {
		System.out.println("[1 HIT]\t[2 STAND]");
		Card card;
		int input = kb.nextInt();
		switch (input) {
		case 1:
			card = deck.removeCard();
			player.getHand().add(card);
			System.out.println("Player Hits: " + card.toPlayer());
		case 2:
			if (theBlind != null) {
				System.out.println("Flipping the blind.." + theBlind);
				theBlind = null;
			}
			if (getHand().getHandValue() < 17) {
				card = deck.removeCard();
				getHand().add(card);
				System.out.println("House Hits: " + card.toHouse());
			}
		default:
			break;
		}
		return theBlind;
	}

	@Override
	public boolean checkWinsTable(int houseHandValue, int playerHandValue) {
		boolean gameOver = false;
		String winString = "";
		if (houseHandValue > 21 || playerHandValue > 21) {
			gameOver = true;
			if (playerHandValue > 21) {
				winString = "PLAYER BUSTS ON " + playerHandValue + ", HOUSE COLLECTS";
			} else {
				winString = "DEALER BUSTS ON " + houseHandValue + ", PLAYER COLLECTS";
			}
		}
		if (playerHandValue == 21 || houseHandValue == 21) {
			gameOver = true;
			if (playerHandValue == 21) {
			winString = "PLAYER BLACKJACK, HOUSE PAYS";
			} else {
			winString = "HOUSE BLACKJACK, HOUSE COLLECTS";
			}
		}
		if ((getHand().getHandValue() > 16 && playerHandValue <= 21 && (playerHandValue >= houseHandValue))) {
			gameOver = true;
			winString = "HOUSE STAYS ON " + houseHandValue + ", PLAYER COLLECTS ON " + playerHandValue;
			if (playerHandValue == houseHandValue) {
				winString = "PUSH" + houseHandValue;
			}
		}
		if (gameOver) {
			System.out.println(winString);
		}
		return gameOver;
	}

	public boolean offerInsurance(BlackJackPlayer player, Scanner kb) {
		boolean insurance = false;
		System.out.println("\nDEALER CHECKS BLIND\nOFFERING INSURANCE:");
		System.out.println("[1 BUY INSURANCE]\t[2 DECLINE INSURANCE]");
		int input = kb.nextInt();
		switch (input) {
		case 1:
			return insurance = true;
		case 2:
			return insurance;
		default:
			System.out.println("Invalid Selection, Defaulting to False");
		}
		return insurance;
	}

	public int getBet(Scanner kb) {
		System.out.println("Set your bet, an int between 5 and 25");
		int bet = kb.nextInt();
		do {
			if (bet > 5 && bet < 25) {
				return bet;
			} else {
				System.out.println("Invalid Input");
				bet = 0;
			}
		} while (bet == 0);
		return bet;
	}

	@Override
	public void housePaysDouble(int playerHandValue, int bet, boolean insurance) {
		System.out.println("Dont have a payment && ||  wallet system yet.");
	}

	@Override
	public void housePays(int playerHandValue, int bet, boolean insurance) {
		System.out.println("Dont have a payment && ||  wallet system yet.");
	}
}