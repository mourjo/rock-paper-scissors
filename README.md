# rock-paper-scissors

Paper-Rock-Scissors is a game for two players. Each player simultaneously opens their hand to
display
a symbol:

- Fist 👊 means rock
- Palm ✋ means paper
- Victory ✌️means scissors

The winner is determined by the rules:

- Paper beats rock
- Rock beats scissors
- Scissors beats paper

This is a program that plays Rock-Paper-Scissors between the computer and a real player.

## Compiling the system

Requirements:

- Maven
- Java 21

```bash 
mvn clean package
```

## Running the compiled Jar

```bash
 java -cp target/rps-1.0-SNAPSHOT.jar me.mourjo.RPSApplication
```

## Sample Run

```bash 
java -cp target/rps-1.0-SNAPSHOT.jar me.mourjo.RPSApplication
Starting the system...

r: Rock
p: Paper
s: Scissors
q: Quit the game

Input: r

--------------------------------------
Player played: Rock
Computer played: Paper
Result: Player Loses
--------------------------------------


r: Rock
p: Paper
s: Scissors
q: Quit the game

Input: s

--------------------------------------
Player played: Scissors
Computer played: Paper
Result: Player Wins
--------------------------------------


r: Rock
p: Paper
s: Scissors
q: Quit the game

Input: q
Exiting, bye!
```
