package ca.sheridancollege.project;

/**
 * A class is be used as the base Card class for the go-fish game.
 * 
 * @modifier Barrett, 2020
 */
public class Card {

    //the value
    private int value;

    /**
     * constructor for value
     * @param value
     */
    public Card(int value) {
        this.value = value;
    }
    
    /**
     * getter for integer value
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * to string method to return card value string
     * 
     * @return a String representation of a card. Could be an UNO card, a regular
     *         playing card etc.
     */
    @Override
    public String toString() {

        String cardname;

        if(value == 1){
            cardname = "A";
            return String.format("%s", cardname);
        } else if (value == 11){
            cardname = "J";
            return String.format("%s", cardname);
        } else if (value == 12){
            cardname = "Q";
            return String.format("%s", cardname);
        } else if (value == 13){
            cardname = "K";
            return String.format("%s", cardname);
        } else {

            return String.format("%d", value);
        }
        
    }

}
