package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the main class from the go fish game that holds the main method game
 * 
 * @modifier Barrett, Esteban, Chris 2020
 */
public class Main {

    /**
     * main method for the game
     * 
     * @param args
     */
    public static void main(String[] args) {

        // initializing deck count and base hand
        final int DECK_COUNT = 52;
        final int BASE_HAND_COUNT = 5;
        // initializing the scanner
        Scanner input = new Scanner(System.in);

        // GENERATES DECK
        ArrayList<Card> tempCards = new ArrayList<Card>();
        for (int i = 0; i < 13; i++) {
            Card tempCard;
            for (int j = 0; j < 4; j++) {
                tempCard = new Card(i + 1);
                tempCards.add(tempCard);
            }
        }

        // SHUFFLES DECK AND RESTORES INTO SIMPLER VARIABLE
        GroupOfCards tempDeck = new GroupOfCards(DECK_COUNT, tempCards);
        tempDeck.shuffle();
        ArrayList<Card> deck = tempDeck.getCards();

        // TAKES INPUT FOR AMOUNT OF PLAYERS AND VALIDATES
        ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("How many players?");
        int playerCount = input.nextInt();
        while (playerCount <= 1 || playerCount > 6) {
            System.out.print("Pick a number from 2-6: ");
            playerCount = input.nextInt();
        }

        // GENERATES HAND FOR EACH INPUTTED PLAYER
        for (int i = 0; i < playerCount; i++) {
            ArrayList<Card> hand = new ArrayList<Card>();
            for (int j = 0; j < BASE_HAND_COUNT; j++) {
                hand.add(deck.remove(j));
            }

            System.out.print("Please enter player name: ");
            String name = input.next();

            players.add(new Player(String.format("%d", i + 1), name, hand, 0));
        }

        // GOFISH STARTS HERE
        GoFish goFish = new GoFish("Go-Fish", players);

        // RUNS UNTIL DECK IS EMPTY
        while (deck.size() > 0) {

            int counter = 0;
            boolean activeTurn = true;

            // ROTATES THROUGH PLAYERS (TURNS)
            while (counter < playerCount) {
                do {
                    // TURN START

                    // DISPLAYS CURRENT PLAYERS NAME, SCORE, AND HAND
                    Player currentPlayer = players.get(counter);
                    System.out.println("Current Player Turn: " + currentPlayer.getName());
                    System.out.println("Score: " + currentPlayer.score);
                    System.out.println("Current Hand: " + currentPlayer.getHand() + "\n");

                    // PROMPTS CURRENT PLAYER TO SELECT OTHER PLAYER
                    System.out
                            .print("Please select player to confront from the list using the number beside the name [");
                    for (Player player : players) {
                        System.out.print(" " + player.getName() + " (" + player.getId() + ") ");
                    }
                    System.out.print("]: ");

                    // VALIDATES SELECTION OF OTHER PLAYER
                    int playerNumber = input.nextInt();
                    while (playerNumber == Integer.parseInt(currentPlayer.getId()) || playerNumber > playerCount
                            || playerNumber != (int) playerNumber) {
                        System.out.println("Can't pick yourself or a non-existing player! Try again: ");
                        playerNumber = input.nextInt();
                    }

                    // CORRECTS SELECTION
                    Player targetPlayer = players.get(playerNumber - 1);

                    // PROMPTS USER FOR CARD SELECTION
                    System.out.print("What card do you want to ask for? (A 2 3 4 5 6 7 8 9 10 J Q K): ");
                    String targetCard = input.next();

                    // GETS INPUTTED CARD VALUE REGARDLESS OF LETTER
                    int targetCardValue;
                    if (targetCard.equalsIgnoreCase("A")) {
                        targetCardValue = 1;
                    } else if (targetCard.equalsIgnoreCase("J")) {
                        targetCardValue = 11;
                    } else if (targetCard.equalsIgnoreCase("Q")) {
                        targetCardValue = 12;
                    } else if (targetCard.equalsIgnoreCase("K")) {
                        targetCardValue = 13;
                    } else {
                        targetCardValue = Integer.parseInt(targetCard);
                    }

                    int numOfMatches = goFish.askPlayerForCard(targetPlayer, targetCardValue);
                    if (numOfMatches < 1) {
                        goFish.goFishing(currentPlayer, deck);
                        activeTurn = false;
                        counter++;
                    } else {
                        goFish.getCardsFromPlayer(currentPlayer, targetPlayer, targetCardValue);
                        goFish.removeIfHasBook(currentPlayer, targetCardValue);
                    }
                    goFish.removeIfHasBook(currentPlayer, targetCardValue);

                    for (Player player : players) {
                        System.out.println(player.getName());
                        System.out.println(player.getHand());
                    }

                } while (activeTurn);
            }
        }

        goFish.declareWinner(players);

        input.close();
    }
}
