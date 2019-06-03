## Blackjack Project

### Skill Distillery Week 4 Homework

### Description
BlackJackTable is a simple command line version of the well-known game of 21. The only rule is the house must hit if the house hand value is < 17. To begin, each player except the dealer receives two cards face up, and the dealer receives one card face up and one card face down.. . After all players have been dealt, the dealer receives their second card facedown. If any player, including the dealer, first two cards' are an ace and a "ten-card", giving a count of 21 in two cards, this is BLACKJACK. If the dealer is showing an ACE, insurance will be offered. Players are then offered a chance to take additional cards (HIT) to try to beat the dealer hand value. If a player hits a hand value > 21 the player BUSTS, and is immediately removed from the round. If the player does not bust, and declines additional cards, player STAY occurs. After all players STAY or BUST, the dealer then follows the house rule, until a dealer STAY or BUST occurs. 

In the case of dealer BUST, any staying players WIN. If the dealer and player both STAY, the player with the greatest hand WINS. If both the dealer and player hands are equal, a stand off occurs PUSH.

## Lessons Learned
A ton of practice on calling & writing methods, extends, experimented with constants, implementing enums, foreach, if else, do while, and switches. Substantial time wasted "fooling" with assigning values to variables that shouldnt have been variables. Calling the method everytime was less work than the mess setting and needing to reassign variables caused.

Stretch Goals Achieved:
Deals from a six deck shoe.
Multiple Players.
Insurance is offered, stored as a boolean field for each hand.
Checks for Natural BlackJack - still broken when dealer has natural blackjack, should remove all player that do not also have natural blackjack, and end the round. 
For future case of offering split, players have an arraylist of hands, which is already checked by the dealer when dealing: for each player, for each hand.
Commented out place holder for primitive bet system because no banks.
Commented out place holders for cut, because does nothing.

Areas to Improve: 
"getting things working" before "refactoring"
Develop ability to write tests
Develop ability to draw UML
Impre workflow - APIE

### Technologies Used
Java, Eclipse, vi, git

### UML Diagram
An sample UML diagram, this program does not strictly follow this.
![UML](Blackjack.png)