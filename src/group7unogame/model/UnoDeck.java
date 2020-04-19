package group7unogame.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents a deck of Uno cards.
 *
 * @author Mariana Baroni - April 19, 2020
 */
public class UnoDeck extends GroupOfCards {

    private final int SIZE = 44;
    private ArrayList<UnoCard> unoCards = new ArrayList<>(SIZE);
    private final int SIZE_WILDCARDS = 4;

    /**
     * No-arg constructor to initialize the decks.
     */
    public UnoDeck() {
    }

    /**
     * Two-arg constructor to initialize a deck
     *
     * @param cards
     * @param size
     */
    public UnoDeck(ArrayList<Card> cards, int size) {
        super(cards, size);
    }

    /**
     * Method responsible for generate a Uno Deck with regular and wildcards
     *
     * @return
     */
    public ArrayList<UnoCard> generateDeck() {

        if (unoCards.isEmpty()) {
            //Regular Uno Cards
            for (UnoCard.Colors color : UnoCard.Colors.values()) {
                for (UnoCard.Values value : UnoCard.Values.values()) {
                    unoCards.add(new UnoCard(color, value));
                }
            }
            //WildCards
            for (int i = 0; i < SIZE_WILDCARDS; i++) {
                unoCards.add(new WildCard("WildCard", null));
            }
        }

        return (unoCards);
    }

    /**
     * Getter method
     *
     * @return
     */
    public ArrayList<UnoCard> getUnoCards() {
        return unoCards;
    }

    /**
     * Method responsible for shuffle the cards
     */
    @Override
    public void shuffle() {
        Collections.shuffle(unoCards);
    }

}
