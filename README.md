## Blackjack Project

### Skill Distillery Week 4 Homework

### Description
BlackJackTable is a simple command line version of the well-known game of 21. The only rule is the house must hit if the house hand value is less than 17.

If player's hits a hand value greater than 21 the player BUSTS, and is immediately out.

If the dealer busts, any staying players WIN, HOUSE PAYS.

If the dealer STAYS and player STAYS, and their hands are equal, a stand off occurs (PUSH); otherwise, the player with the greatest hand is paid. 


## Lessons Learned
A lot of practice on calling/writing methods, extends and implements, experimented with constants, implementing enums, foreach, if else, do while, and switches. Substantial time wasted trying out variables. Simply calling the method would have saved a lot of time. Writing tests would have saved a lot of time but still very weak in this area.

Stretch Goals Achieved:
Deals from a six deck shoe.
Multiple Players (have played upto 25);
Bet system commmented out that doesnt really function because no bank.
Checks for Natural BlackJack - still broken on pays for when deal has natural blackjack, which should remove all player that doesnt also have natural blackjack, and end the game. 

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