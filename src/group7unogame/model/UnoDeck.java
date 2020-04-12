package group7unogame.model;

import java.util.ArrayList;
import java.util.Collections;
        
/**
 * This class represents a deck of Uno cards.
 * 
 * @author Mariana Baroni - April 10, 2020
 */
public class UnoDeck extends GroupOfCards {
    
    private final int SIZE = 44;
    private ArrayList<UnoCard> unoCards = new ArrayList<>(SIZE);
    private final int SIZE_WILDCARDS = 4;
    
    public ArrayList<UnoCard> generateDeck() {
        
        if ( unoCards.isEmpty() ) {
            //Regular Uno Cards
            for (UnoCard.Colors color : UnoCard.Colors.values()) {
                for (UnoCard.Values value : UnoCard.Values.values()) {
                    unoCards.add(new UnoCard(color, value));
                }
            }
            //WildCards
            for (int i = 0; i < SIZE_WILDCARDS; i++) {
                unoCards.add(new WildCard("WildCard Any Color", null));
            }
        } 
        
        return (unoCards);
    }

    public ArrayList<UnoCard> getUnoCards() {
        return unoCards;
    }

    public void setUnoCards(ArrayList<UnoCard> unoCards) {
        this.unoCards = unoCards;
    }
   
    @Override
    public void shuffle() {
        Collections.shuffle(unoCards);
    }
    
}