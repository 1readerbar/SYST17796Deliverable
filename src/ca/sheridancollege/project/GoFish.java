/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author The Master
 */
public class GoFish extends Game {

    public GoFish(String gameName, ArrayList<Player> players) {
        super(gameName, players);
    }

    public boolean askPlayerForCard(Player player, int card) {

        return true;
    }

    public void goFishing(Player player) {

    }

    public int scores() {
        return 1;
    }

    public void endGame() {

    }

    public void play() {

    }

    public void declareWinner() {

    }

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