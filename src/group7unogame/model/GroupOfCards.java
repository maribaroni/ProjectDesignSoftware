package group7unogame.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @modified Paul Bonenfant Jan 2020
 * GROUP 7:
 * @modified Mariana Baroni - March 10, 2020
 * @modified Danish Siddiqui - February 12, 2020
 * @modified Husam Haidarah - February 12, 2020
 * @modified Katrina Metha - February 12, 2020
 */
public abstract class GroupOfCards {

    //The group of cards, stored in an ArrayList
    protected ArrayList<Card> cards;
    private int size;//the size of the grouping

    public GroupOfCards(){}
    
    public GroupOfCards(ArrayList<Card> cards, int size) {
        this.size = size;
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

    public abstract void shuffle();

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    
}//end class
