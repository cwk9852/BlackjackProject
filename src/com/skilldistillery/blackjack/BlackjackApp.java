package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackjackApp {
	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		BlackjackApp table = new BlackjackApp();
		table.run();
	}

	public void run() {
		BlackJackDealer cecil = new BlackJackDealer();
		BlackJackPlayer player = new BlackJackPlayer();
		System.out.println("Welcome to Cecil's Blackjack Table");
		System.out.println("Shuffling...");
		cecil.getDeck().shuffle();
		// int bet = cecil.getBet(kb);
		System.out.println("Dealing two cards to each player, and one blind to the house.. \n");
		Card theBlind = cecil.dealNewHand(player, kb);
		int houseHandValue = cecil.getHandValue(cecil.getHand());
		int playerHandValue = player.getHandValue(player.getHand());
		System.out.println("Dealer Shown: " + (houseHandValue - theBlind.getValue()));
		System.out.println("Player Hand: " + playerHandValue);
		//boolean insurance = cecil.offerInsurance(player, kb, theBlind);
		if (cecil.checkWinsTable(houseHandValue, playerHandValue) != true) {
			do {
				cecil.continueRound(player, kb);
				houseHandValue = cecil.getHandValue(cecil.getHand());
				playerHandValue = player.getHandValue(player.getHand());
			} while (cecil.checkWinsTable(houseHandValue, playerHandValue) != true);
		}
		cecil.checkWinsTable(houseHandValue, playerHandValue);
		// cecil.housePays(playerHandValue, bet, insurance);
		//cecil.clearHands();
		kb.close();
	}
}
