package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackjackApp {

	public static void main(String[] args) {
		BlackjackApp table = new BlackjackApp();
		table.run();
	}

	public void run() {
		BlackJackDealer dealer = new BlackJackDealer();
		BlackJackPlayer player = new BlackJackPlayer();
		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to Cecil's Blackjack App");
		System.out.println("Shuffling...");
		dealer.getDeck().shuffle();
		System.out.println("Dealing two cards to each player.. \n");
		System.out.println("[" + dealer.dealCard(dealer).toDealer() + "]");
		System.out.println("[" + dealer.dealCard(player).toPlayer() + "]");
		final Card theBlind = dealer.dealCard(dealer);
		System.out.println("[" + theBlind.blind() + "]");
		System.out.println("[" + dealer.dealCard(player).toPlayer() + "]\n");
		System.out.println("[  Dealer Shown:\t" + (dealer.getHand().getHandValue() - theBlind.getValue()) + " ]");
		System.out.println("[  Player Hand:\t\t" + player.getHandValue(player.getHand()) + " ]\n");
		do {
			if (player.getHand().getHandValue() < 21) {
				System.out.println("[1 - Hit][2 - Stay]");
				int input = kb.nextInt();
				System.out.println("[Turn the Blind: " + dealer.turnBlind(theBlind) + ".]");
				System.out.println("Dealer Hand:\t" + (dealer.getHand().getHandValue()));
				switch (input) {
				case 1:
					System.out.println(dealer.dealCard(player).toPlayer());
				case 2:
					System.out.println(dealer.playHouseRules());
					System.out.println("Dealer Hand:\t" + dealer.getHandValue(dealer.getHand()));
					System.out.println("Player Hand:\t" + player.getHandValue(player.getHand()));
					break;
				}
			}
		} while (player.getHand().getHandValue() < 21 && dealer.getHand().getHandValue() < 21);
		final int playerHandValueFinal = player.getHand().getHandValue();
		final int houseHandValueFinal = dealer.getHand().getHandValue();
		System.out.println(dealer.announceHandResult(playerHandValueFinal, houseHandValueFinal));
		kb.close();
	}
}
