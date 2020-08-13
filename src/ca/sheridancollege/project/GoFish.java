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

    public void goFishing(Player player, Hand hand) {

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
}
