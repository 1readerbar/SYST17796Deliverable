package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class that models each Player in the game. Players have an identifier,
 * that is unique.
 * 
 * @modifier Barrett, Esteban, Chris 2020
 */
public class Player {

    // the unique ID for this player
    private String id; 
    private String name;
    private ArrayList<Card> hand;
    private int attribute;
    public int score;

    /**
     * A constructor that allows you to set the player's unique ID
     * 
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * a constructor to take for the variables and array list
     * @param id
     * @param name
     * @param cards
     * @param score
     */
    public Player(String id, String name, ArrayList<Card> cards, int score) {
        this.id = id;
        this.name = name;
        this.hand = cards;
        this.score = score;
    }

    /**
     * getter for ID
     * @return the playerID
     */
    public String getId() {
        return id;
    }

    /**
     * getter for name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * getter for hand
     * @return
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * getter for attribute
     * @return
     */
    public int getAttribute() {
        return attribute;
    }

    /**
     * getter for score
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     * unique playerID
     * 
     * @param givenID
     */
    public void setPlayerID(String givenID) {
        id = givenID;
    }

    /**
     * setter for name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter for hand
     * @param name
     */
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    /**
     * setter for attribute
     * @param name
     */
    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }

    /**
     * setter for score
     * @param name
     */
    public void setScore(int score) {
        this.score = score;
    }

}
