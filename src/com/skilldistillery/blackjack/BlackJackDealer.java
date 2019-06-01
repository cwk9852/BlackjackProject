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
		return theBlind;
	}

	public void continueRound(BlackJackPlayer player, Scanner kb) {
		System.out.println("[1 HIT]\t[2 STAND]");
		Card card;
		int input = kb.nextInt();
		switch (input) {
		case 1:
			card = deck.removeCard();
			player.getHand().add(card);
			System.out.println(card.toPlayer());
		case 2:
			if (houseRule = true) {
				card = deck.removeCard();
				getHand().add(card);
				System.out.println(card.toHouse());
			}
		default:
			break;
		}
	}

	@Override
	public boolean checkWinsTable(int houseHandValue, int playerHandValue) {
		boolean win = false;
		String winString = "";
		if ((playerHandValue > houseHandValue) && (houseRule !=true)) {
				win = true;
				winString = "HOUSE STAYS ON " + houseHandValue + ", PLAYER COLLECTS ON " + playerHandValue;
				if (playerHandValue == houseHandValue) {
					win = true;
					winString = "PUSH" + houseHandValue;
				}
				if (playerHandValue == 21) {
					win = true;
					winString = "PLAYER BLACKJACK, HOUSE PAYS";
				}
				if (houseHandValue == 21) {
					win = true;
					winString = "HOUSE BLACKJACK, HOUSE COLLECTS";
				}
			}
//		} else {
//			if (playerHandValue > 21) {
//				win = true;
//				winString = "PLAYER BUSTS ON " + playerHandValue + ", HOUSE COLLECTS";
//			}
//			if (houseHandValue > 21) {
//				win = true;
//				winString = "DEALER BUSTS ON " + houseHandValue + ", PLAYER COLLECTS";
//			}
//			if (win == true) {
//				System.out.println(winString);
//			}
		return win;
		}
	}

	public boolean offerInsurance(BlackJackPlayer player, Scanner kb, Card theBlind) {
		boolean insurance = false;
		System.out.println("DEALER CHECKS BLIND, OFFERS INSURANCE");
		System.out.println("[1 BUY INSURANCE]\t[2 DECLINE INSURANCE]");
		int input = kb.nextInt();
		switch (input) {
		case 1:
			return insurance = true;
		case 2:
			return insurance;
		default:
			System.out.println("Invalid Selection");
		}
		System.out.println("Flipping the blind.." + theBlind);
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
	public boolean housePays(int playerHandValue, int bet, boolean insurance) {
		// TODO Auto-generated method stub
		return false;
	}
}