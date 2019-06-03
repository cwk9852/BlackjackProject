package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackJackDealer extends Player {

	private Shoe shoe;

	BlackJackDealer() {
		this.name = "DEALER ";
		this.shoe = new Shoe();
		this.playerNum = 1;
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
			System.out.println("Not enough cards left in shoe.");
		}
	}

	public void dealCards(ArrayList<Player> players, int howMany) {
		for (int i = 0; i < howMany; i++) {
			for (Player player : players) {
				dealCard(player);
			}
		}
	}

	public void turnBlind() {
		System.out.println("\n[FLIP FACEDOWN]\n[DEALER SHOWS]:" + this.getHand().getHandValue());
		this.getHand().printHand();
	}

	public void checkNaturals(ArrayList<Player> players) {
		for (Player player : players) {
			if ((player.getHand().getHandValue() == 21) && (this.getHand().getHandValue() != 21)) {
				if (this.getHand().getFirstCardValue() == 11) {
					System.out.println("[DEALER CHECKS BLIND]");
				}
				System.out.println("\n" + player.getName() + " !!!BLACKJACK!!! HOUSE PAYS 1.5 ");
				players.remove(player);
				break;
			}
		}
	}

	public void checkWins(ArrayList<Player> players) {
		for (Player player : players.subList(1, players.size())) {
			if (player.getHand().getHandValue() > 21) {
				players.remove(player);
				break;
			}
		}
		if (this.getHand().getHandValue() > 21) {
			System.out.println("[DEALER BUSTS]" + this.getHand().getHandValue());
			players.remove(0);
			for (Player player : players) {
				System.out.println(player.getName() + " STAYS, HOUSE PAYS");
			}
		} else {
			System.out.println("[DEALER STAYS " + this.getHand().getHandValue() + "]");
			for (Player player : players.subList(1, players.size())) {
				if ((this.getHand().getHandValue() > player.getHand().getHandValue())) {
					System.out.println("HOUSE BEATS " + player.getName() + ", PLAYER PAYS");
				}
				if ((player.getHand().getHandValue() == this.getHand().getHandValue())) {
					System.out.println(player.getName() + " PUSH " + this.getHand().getHandValue());
				} else if ((player.getHand().getHandValue() > this.getHand().getHandValue())) {
					System.out.println(player.getName() + " BEATS HOUSE, HOUSE PAYS");
				}
			}
		}
	}

	public void offerInsurance(ArrayList<Player> players, Scanner kb) {
		System.out.println("[DEALER CHECKS BLIND][OFFERING INSURANCE:]");
		for (Player player : players.subList(1, players.size())) {
			for (Hand hand : player.getHands()) {
				System.out.print("[" + player.getName() + "]\n[1 ACCEPT][2 DECLINE]:");
				int input = kb.nextInt();
				switch (input) {
				case 1:
					hand.setInsurance(true);
					break;
				case 2:
					hand.setInsurance(false);
					break;
				default:
					hand.setInsurance(false);
					System.out.println("Invalid Response: You forfeit insurance.");
					break;
				}
			}
		}
	}

	public int getBet(Scanner kb) {
		System.out.println("Set your bet, an int between 5 and 25");
		int bet = kb.nextInt();
		do {
			if (bet > 5 && bet < 25) {
				return bet;
			} else {
				System.out.println("Bet Not Allowed");
				bet = 0;
			}
		} while (bet == 0);
		return bet;
	}

	public void printPlayerHands(ArrayList<Player> players) {
		for (Player player : players.subList(1, players.size())) {
//			char c = 65;
			System.out.println("[ " + player.getName() + " ]");
			for (Hand hand : player.getHands()) {
//				System.out.println("HAND " + c);
//				++c;
				hand.printHand();
			}
		}
	}

	public void getHits(ArrayList<Player> players, Scanner kb) {
		for (Player player : players.subList(1, players.size())) {
			for (Hand hand : player.getHands()) {
				System.out.println();
				System.out.print("[ " + player.getName() + " ] - [1. HIT] [2. STAY]:");
				int input = kb.nextInt();
				if (input == 1) {
					do {
						Card card = shoe.removeCard();
						hand.add(card);
						System.out.println("[" + player.getName() + "]" + "[HITS]");
						if (player.getHand().getHandValue() > 21) {
							System.out.println(
									"[" + player.getName() + " BUSTS " + player.getHand().getHandValue() + "]");
							player.getHand().printHand();
						} else {
							player.getHand().printHand();
							System.out.print("[ " + player.getName() + " ] - [1. HIT] [2. STAY]:");
							input = kb.nextInt();
						}
					} while (player.getHand().getHandValue() < 21 && input == 1);
					if (input == 2) {
						System.out
								.println("[" + player.getName() + " STAYS on " + player.getHand().getHandValue() + "]");
					}
				}
			}
		}
	}

	public void printDealerHandWithBlind() {
		System.out.println("[DEALER  ]");
		System.out.println("[   " + this.getHand().printCardAtIndex(0) + "   ]");
		System.out.println("[   " + this.getHand().printCardFaceDown(1) + "      ]");
	}

	public ArrayList<Player> setPlayers(int num, Player dealer) {
		ArrayList<Player> players = new ArrayList<>();
		players.add(dealer);
		for (int i = 1; i < num + 1; i++) {
			players.add(new Player("PLAYER ", i));
		}
		return players;
	}

	public void playHouseRule() {
		if (this.getHand().getHandValue() < 17) {
			do {
				Card card = shoe.removeCard();
				this.getHand().add(card);
				System.out.println("[DEALER HITS]");
				this.getHand().printHand();
			} while ((this.getHand().getHandValue() < 16));
		}
	}
}