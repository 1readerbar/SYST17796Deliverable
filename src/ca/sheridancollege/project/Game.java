package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The class that models the game.
 * 
 * @modifier Barrett, 2020
 */
public abstract class Game {

    //the title of the game
    private final String gameName;
    // the players of the game
    private ArrayList<Player> players;

    /**
     * constructor for given name and player
     * @param givenName
     * @param players
     */
    public Game(String givenName, ArrayList<Player> players) {
        this.gameName = givenName;
        this.players = players;
    }

    /**
     * @return the gameName
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * This method to declare and display a winning
     * player and end the game.
     */
    public abstract void declareWinner(ArrayList<Player> players);

}// end class
