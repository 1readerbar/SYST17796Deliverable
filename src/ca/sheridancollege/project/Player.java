/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class that models each Player in the game. Players have an identifier,
 * which should be unique.
 * 
 * @author dancye, 2018
 */
public abstract class Player {

    private String playerID; // the unique ID for this player
    private String name;
    private Hand hand;
    private int attribute;
    public int score;

    /**
     * A constructor that allows you to set the player's unique ID
     * 
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        playerID = name;
    }

    /**
     * @return the playerID
     */
    public String getPlayerID() {
        return playerID;
    }

    /**
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * 
     * @return
     */
    public int getAttribute() {
        return attribute;
    }

    /**
     * 
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     * Ensure that the playerID is unique
     * 
     * @param givenID the playerID to set
     */
    public void setPlayerID(String givenID) {
        playerID = givenID;
    }

    /**
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @param name
     */
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    /**
     * 
     * @param name
     */
    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }

    /**
     * 
     * @param name
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * The method to be instantiated when you subclass the Player class with your
     * specific type of Player and filled in with logic to play your game.
     */
    public abstract void play();

}
