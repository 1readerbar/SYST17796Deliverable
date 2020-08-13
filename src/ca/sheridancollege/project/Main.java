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
        GroupOfCards tempDeck = new GroupOfCards(DECK_COUNT, tempCards);
        tempDeck.shuffle();
        ArrayList<Card> deck = tempDeck.getCards();

        ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("how many players?");
        int playerCount = input.nextInt();

        for (int i = 0; i < playerCount; i++) {

            // GENERATES HAND
            ArrayList<Card> tempHand = new ArrayList<Card>();
            for (int j = 0; j < BASE_HAND_COUNT; j++) {
                tempHand.add(deck.remove(j));
            }

            Player player = new Player(String.format("%d", i), "Barrett", tempHand, 0);

            players.add(player);

        }

        System.out.print(players.toString());

    }
}
