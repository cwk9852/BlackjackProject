package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackjackTable {
	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		BlackjackTable table = new BlackjackTable();
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
}
