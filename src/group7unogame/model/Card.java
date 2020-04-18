package group7unogame.model;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game.
 *
 * @author dancye GROUP 7:
 * @modified Mariana Baroni - April 17, 2020
 * @modified Katrina Metha - February 12, 2020
 */
public abstract class Card {
    //default modifier for child classes

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    @Override
    public abstract String toString();

}
