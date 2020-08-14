/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author The Master
 */
public class Main {

    public static void main(String[] args) {

        final int DECK_COUNT = 52;
        final int BASE_HAND_COUNT = 5;
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

        while (deck.size() > 0) {

            boolean activeTurn = true;

            do {

                // TURN START
                for (int i = 0; i < playerCount; i++) {
                    Player currentPlayer = players.get(i);
                    System.out.println("Current Player Turn: " + currentPlayer.getName());

                    System.out.print(
                            "Please select player to confront from the list using the number besides the name: ");
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

                    int numOfMatches = goFish.askPlayerForCard(targetPlayer, targetCardValue);
                    if (numOfMatches < 1) {
                        activeTurn = false;
                    } else {
                        // get cards from the target player
                        ArrayList<Card> currentPlayerHand = currentPlayer.getHand();
                        ArrayList<Card> targetPlayerHand = targetPlayer.getHand();

                        for (int j = 0; j < targetPlayerHand.size(); j++) {
                            Card card = targetPlayerHand.get(j);
                            if (card.getValue() == targetCardValue) {
                                currentPlayerHand.add(card);
                                targetPlayerHand.remove(card);
                            }
                        }
                    }

                }

            } while (activeTurn);

        }

        System.out.print("Please select from the list using the number: ");

        // TEMPORARY (PROVES CREATION OF PLAYERS AND HANDS)
        for (Player player : players) {
            System.out.println(player.getName());
        }
        input.close();
    }
}
