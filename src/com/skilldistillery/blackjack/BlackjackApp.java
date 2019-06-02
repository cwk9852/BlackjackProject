package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackjackApp {
	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		BlackjackApp table = new BlackjackApp();
		table.run();
	}

	public void run() {
		BlackJackDealer house = new BlackJackDealer();
		BlackJackPlayer player = new BlackJackPlayer();
		System.out.println("Welcome to Cecil's Blackjack Table");
		System.out.println("Shuffling...");
		house.getDeck().shuffle();
		int bet = 5;
		System.out.println("Placing Minimum Bet: " + bet);
		System.out.println("Dealing...\n");
		house.dealNewHand(player, kb);
		boolean firstRound = true;
		if ((house.getHand().getFirstCardValue()) == 11) {
			house.checkWinsTable(player.getHand().getHandValue());
			house.offerInsurance(player, kb);
		}
		do {
			firstRound = house.continueHand(player, kb, firstRound);
		} while (house.checkWinsTable(player.getHand().getHandValue()) != true);
		kb.close();
	}

	public void printHands(int house, int player) {
		System.out.println("House: " + house);
		System.out.println("Player: " + player);
	}
}
