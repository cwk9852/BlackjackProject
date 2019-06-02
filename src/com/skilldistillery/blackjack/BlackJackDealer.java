package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackJackDealer extends Player {

	private Shoe shoe;

	BlackJackDealer() {
		this.name = "Dealer ";
		this.shoe = new Shoe();
		this.playerNum = 0;
	}

	public Shoe getShoe() {
		return shoe;
	}

	public void dealCard(Player name) {
		try {
			if (shoe.checkShoeSize() < 1) {
				throw new IndexOutOfBoundsException();
			} else {
				Card card = shoe.removeCard();
				name.getHand().add(card);
			}
		} catch (InputMismatchException e) {
			System.out.println("Not an integer");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Not enough cards.");
		}
	}

	public void dealCards(ArrayList<Player> players, int howMany) {
		for (int i = 0; i < howMany; i++) {
			for (Player player : players) {
				dealCard(player);
			}
		}
	}

	public void dealNewBlackJackHand(Player name) {
		System.out.println("[Player\t]");
		System.out.println("[Dealer\t]");
	}

	public void turnBlind() {
		System.err.println("[FLIP FACEDOWN]\t[" + this.getHand().printCardAtIndex(1) + "]");
	}

	public boolean checkWinsTable(Player player) {
		boolean gameOver = false;
		String winString = "";
		if (player.getHand().getHandValue() == 21 || this.getHand().getHandValue() == 21) {
			gameOver = true;
			if (player.getHand().getHandValue() == 21) {
				winString = "PLAYER WIN 21";
			} else {
				winString = "HOUSE WIN 21";
			}
		}
		if (this.getHand().getHandValue() > 21 || player.getHand().getHandValue() > 21) {
			gameOver = true;
			if (player.getHand().getHandValue() > 21) {
				winString = "HOUSE WIN, PLAYER BUSTS ON " + player.getHand().getHandValue();
			} else {
				winString = "PLAYER WIN, DEALER BUSTS ON " + this.getHand().getHandValue();
			}
		}
		if ((player.getHand().getHandValue() >= this.getHand().getHandValue() && this.getHand().getHandValue() >= 17)) {
			gameOver = true;
			winString = "PLAYER WIN, HOUSE STAYS ON " + this.getHand().getHandValue();
			if (player.getHand().getHandValue() == this.getHand().getHandValue()) {
				winString = "PUSH" + this.getHand().getHandValue();
			}
		}
		if (gameOver) {
			System.out.println("\n" + winString);
		}
		return gameOver;
	}

	public boolean offerInsurance(ArrayList<Player> players, Scanner kb) {
		System.out.println("\nDEALER CHECKS BLIND\nOFFERING INSURANCE:\n");
		int input = kb.nextInt();
		for (Player player : players) {
			System.out.println(player.getName());
			System.out.println("[1 ACCEPT] [2 DECLINE]");
			
		}
		switch (input) {
		case 1:
			return true;
		case 2:
			return false;
		default:
			System.out.println("Invalid Response: You forfeit insurance.");
		}
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