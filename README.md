## Blackjack Project

### Skill Distillery Week 4 Homework

### Description
BlackJackTable is a simple command line version of the well-known game of 21. The only rule is the house must hit if the house hand value is less than 17. If a player hits a hand value greater than 21 the player BUSTS, and is immediately removed from the round. After all players have hit, the dealer hits while rule is true. If the dealer busts, any staying players WIN. If the dealer and player both STAY, and their hands are equal, a stand off occurs PUSH. Otherwise, the player with the greatest hand WINS. 

## Lessons Learned
A ton of practice on calling & writing methods, extends, experimented with constants, implementing enums, foreach, if else, do while, and switches. Substantial time wasted trying out variables. Simply calling the method would have saved a lot of time. Writing tests would have also saved a lot of time but still very weak in this area. Learned a ton, practiced a ton, enjoyed the project.

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