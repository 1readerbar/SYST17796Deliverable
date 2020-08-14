package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * 
 * @modifier Barrett, Esteban, Chris 2020
 */
public class GroupOfCards {

    // The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;
    private int size;// the size of the grouping

    /**
     * constructor for given size
     * @param givenSize
     */
    public GroupOfCards(int givenSize) {
        this.size = givenSize;
    }

    /**
     * constructor for given size and array list cards
     * @param givenSize
     * @param cards
     */
    public GroupOfCards(int givenSize, ArrayList<Card> cards) {
        this.size = givenSize;
        this.cards = cards;
    }

    /**
     * A method that will get the group of cards as an ArrayList
     * 
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * A method to shuffly the deck
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }

}