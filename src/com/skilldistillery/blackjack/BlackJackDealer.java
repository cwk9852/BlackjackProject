package com.skilldistillery.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackJackDealer extends Player {

	private Deck shoe;

	BlackJackDealer() {
		shoe = new Deck();
	}

	public Deck getDeck() {
		return shoe;
	}

	public void setDeck(Deck deck) {
		this.shoe = deck;
	}

	public Card dealCard(Player name) {
		Card card = null;
		try {
			if (shoe.checkDeckSize() < 1) {
				throw new IndexOutOfBoundsException();
			} else {
				card = shoe.removeCard();
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

	public void dealNewHand(BlackJackPlayer player, Scanner kb) {
		Card card = shoe.removeCard();
		player.getHand().add(card);
		System.out.println(card.toPlayer());
		card = shoe.removeCard();
		this.getHand().add(card);
		System.out.println(card.toHouse());
		card = shoe.removeCard();
		card = shoe.removeCard();
		player.getHand().add(card);
		System.out.println(card.toPlayer());
		card = shoe.removeCard();
		System.out.println(card.toHouseBlind());
		this.getHand().add(card);
	}

	public boolean continueHand(BlackJackPlayer player, Scanner kb, boolean firstRound) {
		System.out.println("\n[1 HIT]\t[2 STAND]");
		Card card;
		int input = kb.nextInt();
		switch (input) {
		case 1:
			card = shoe.removeCard();
			player.getHand().add(card);
			System.out.println("Player Hits: " + card.toPlayer());
		default:
			if (firstRound) {
				System.out.println("[FLIP FACEDOWN]\t[" + this.getHand().getCard(1) + "]");
			}
			if (getHand().getHandValue() < 17) {
				card = shoe.removeCard();
				getHand().add(card);
				System.out.println("House Hits: " + card.toHouse());
			}
			return false;
		}
	}

	public boolean checkWinsTable(int playerHandValue) {
		boolean gameOver = false;
		String winString = "";
		if (this.getHand().getHandValue() > 21 || playerHandValue > 21) {
			gameOver = true;
			if (playerHandValue > 21) {
				winString = "PLAYER BUSTS ON " + playerHandValue + ", HOUSE COLLECTS";
			} else {
				winString = "DEALER BUSTS ON " + this.getHand().getHandValue() + ", HOUSE PAYS";
			}
		}
		if (playerHandValue == 21 || this.getHand().getHandValue() == 21) {
			gameOver = true;
			if (playerHandValue == 21) {
				winString = "PLAYER 21, HOUSE PAYS";
			} else {
				winString = "HOUSE 21, HOUSE COLLECTS";
			}
		}
		if ((this.getHand().getHandValue() >= 16 && playerHandValue <= 21
				&& (playerHandValue >= this.getHand().getHandValue()))) {
			gameOver = true;
			winString = "HOUSE STAYS ON " + this.getHand().getHandValue() + ", PLAYER COLLECTS ON " + playerHandValue;
			if (playerHandValue == this.getHand().getHandValue()) {
				winString = "PUSH\tHOUSE:" + this.getHand().getHandValue() + "\tPLAYER: " + playerHandValue;
			}
		}
		if (gameOver) {
			System.out.println("\n" + winString);
		}
		return gameOver;
	}

	public boolean offerInsurance(BlackJackPlayer player, Scanner kb) {
		boolean insurance = false;
		System.out.println("\nDEALER CHECKS BLIND\nOFFERING INSURANCE:");
		System.out.println("[1 BUY INSURANCE] [2 DECLINE INSURANCE]");
		int input = kb.nextInt();
		switch (input) {
		case 1:
			return insurance = true;
		case 2:
			return insurance;
		default:
			System.out.println("Invalid Response: You forfeit insurance.");
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

}