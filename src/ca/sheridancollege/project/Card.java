/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the
 * code should remember to add themselves as a modifier.
 * 
 * @author dancye, 2018
 * @author esteban
 */
public class Card {

    //
    private int value;
    // default modifier for child classes

    public Card(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**
     * Students should implement this method for their specific children classes
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
