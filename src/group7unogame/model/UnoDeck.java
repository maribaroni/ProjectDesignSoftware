package group7unogame.model;

import java.util.ArrayList;
import java.util.Collections;
        
/**
 * This class represents a deck of Uno cards.
 * 
 * @author Mariana Baroni
 */
public class UnoDeck extends GroupOfCards {
    
    private final int SIZE = 44;
    private ArrayList<UnoCard> unoCards = new ArrayList<>(SIZE);
    
    public ArrayList<UnoCard> generateDeck() {
        
        if ( unoCards.isEmpty() ) {
            for (UnoCard.Colors color : UnoCard.Colors.values()) {
                for (UnoCard.Values value : UnoCard.Values.values()) {
                    unoCards.add(new UnoCard(color, value));
                }
            }
            unoCards.add(new WildCard("WildCard", null, null));
            unoCards.add(new WildCard("WildCard", null, null));
            unoCards.add(new WildCard("WildCard", null, null));
            unoCards.add(new WildCard("WildCard", null, null));
        } 
        
        return (unoCards);
    }

    public ArrayList<UnoCard> getUnoCards() {
        return unoCards;
    }
    
    @Override
    public void shuffle() {
        Collections.shuffle(unoCards);
    }
    
}