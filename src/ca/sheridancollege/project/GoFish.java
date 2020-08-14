package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * This class is for the fo-fish methods used to play the game
 * 
 * @modifier Barrett, Esteban, Chris 2020
 */
public class GoFish extends Game {

    /**
     * This is a constructor for go-fish taking in given name and array list players
     * 
     * @param gameName
     * @param players
     */
    public GoFish(String gameName, ArrayList<Player> players) {
        super(gameName, players);
    }

    /**
     * This is the ask player for card method to take in both player and card value
     * to return numMatch
     * 
     * @param player
     * @param cardValue
     * @return
     */
    public int askPlayerForCard(Player player, int cardValue) {

        int numMatch = 0;

        for (int i = 0; i < player.getHand().size(); i++)
            if (player.getHand().get(i).getValue() == cardValue) {
                numMatch++;
            }

        return numMatch;
    }

    /**
     * taking card from the deck
     * 
     * @param player
     * @param cards
     */
    public void removeIfHasBook(Player currentPlayer, int targetCardValue) {

        if (hasBook(currentPlayer)) {
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

    // taking card from deck
    public void goFishing(Player player, ArrayList<Card> cards) {
        if (player.getHand().size() != 0) {
            player.getHand().add(cards.remove(cards.size() - 1));
        }
    }

    /**
     * get cards from the target player
     * 
     * @param currentPlayer
     * @param targetPlayer
     * @param targetCardValue
     */
    public void getCardsFromPlayer(Player currentPlayer, Player targetPlayer, int targetCardValue) {
        ArrayList<Card> currentPlayerHand = currentPlayer.getHand();
        ArrayList<Card> targetPlayerHand = targetPlayer.getHand();
        int targetPlayerHandSize = targetPlayerHand.size();
        int j = 0;

        for (j = 0; j < targetPlayerHandSize; j++) {
            Card card = targetPlayerHand.get(j);
            if (card.getValue() == targetCardValue) {
                currentPlayerHand.add(card);
                targetPlayerHand.remove(card);
                targetPlayerHandSize--;
                j = 0;
            }
        }
    }

    /**
     * override method to declare the winner of the game and end game
     */
    @Override
    public void declareWinner(ArrayList<Player> players) {

        int max = 0;
        String name = "";
        for (int i = 0; i < players.size(); i++) {

            if (players.get(i).getScore() > max) {
                max = players.get(i).getScore();
                name = players.get(i).getName();
            }
        }

        System.out.println("The winner is " + name + "with a score of " + max);
    }

    /**
     * seeing if there is a book in the player
     * 
     * @param player
     * @return
     */
    public boolean hasBook(Player player) {
        ArrayList<Card> hand = player.getHand();
        int[] ranks = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        for (int i = 0; i < hand.size(); i++) {
            switch (hand.get(i).getValue()) {
                case 1:
                    ranks[0]++;
                    break;
                case 2:
                    ranks[1]++;
                    break;
                case 3:
                    ranks[2]++;
                    break;
                case 4:
                    ranks[3]++;
                    break;
                case 5:
                    ranks[4]++;
                    break;
                case 6:
                    ranks[5]++;
                    break;
                case 7:
                    ranks[6]++;
                    break;
                case 8:
                    ranks[7]++;
                    break;
                case 9:
                    ranks[8]++;
                    break;
                case 10:
                    ranks[9]++;
                    break;
                case 11:
                    ranks[10]++;
                    break;
                case 12:
                    ranks[11]++;
                    break;
                case 13:
                    ranks[12]++;
                    break;
                default:
                    break;
            }
        }

        for (int j = 0; j < ranks.length; j++) {
            if (ranks[j] == 4) {
                return true;
            }
        }

        return false;
    }
}
