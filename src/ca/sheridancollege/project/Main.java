package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *This is the main class from the go fish game that
 holds the main method game
 * @modifier Barrett, Esteban, Chris 2020
 */
public class Main {

    /**
     * main method for the game
     * @param args
     */
    public static void main(String[] args) {

        //initializing deck count and base hand
        final int DECK_COUNT = 52;
        final int BASE_HAND_COUNT = 5;
        //initializing the scanner
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

        ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("how many players?");
        int playerCount = input.nextInt();

        for (int i = 0; i < playerCount; i++) {

            // GENERATES HAND
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

        while (deck.size() > -1) {

            int counter = 0;
            boolean activeTurn = true;

            while (counter < playerCount) {

                do {

                    // TURN START

                    Player currentPlayer = players.get(counter);
                    System.out.println("Current Player Turn: " + currentPlayer.getName() + " " + currentPlayer.score);

                    System.out
                            .print("Please select player to confront from the list using the number beside the name: ");
                    for (Player player : players) {
                        System.out.print(player.getName() + " (" + player.getId() + ")   ");
                    }
                    
                    int playerNumber = input.nextInt();

                    Player targetPlayer = players.get(playerNumber - 1);

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

                    System.out.println(targetCardValue + " " + targetPlayer.getName());

                    int numOfMatches = goFish.askPlayerForCard(targetPlayer, targetCardValue);
                    if (numOfMatches < 1) {
                        goFish.goFishing(currentPlayer, deck);
                        activeTurn = false;
                        counter++;

                    } else {
                        GoFish.getCardsFromPlayer(currentPlayer, targetPlayer, targetCardValue);

                        if (goFish.hasBook(currentPlayer)) {
                            currentPlayer.score++;

                            ArrayList<Card> currentPlayerHand = currentPlayer.getHand();
                            int currentPlayerHandSize = currentPlayerHand.size();

                            for (int i = currentPlayerHandSize; i > 0; i--) {
                                Card card = currentPlayerHand.get(i - 1);
                                if (card.getValue() == targetCardValue) {
                                    currentPlayerHand.remove(card);

                                }
                            }
                        }

                    }

                    for (Player player : players) {
                        System.out.println(player.getName());
                        System.out.println(player.getHand());
                    }

                } while (activeTurn);

            }

        }

        System.out.print("Please select from the list using the number: ");

        // TEMPORARY (PROVES CREATION OF PLAYERS AND HANDS)
        for (Player player : players) {
            System.out.println(player.getName());
        }
        input.close();
    }
}
