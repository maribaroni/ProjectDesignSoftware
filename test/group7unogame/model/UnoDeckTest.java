/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group7unogame.model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maria
 */
public class UnoDeckTest {

    public UnoDeckTest() {
    }

    @Test
    public void testGenerateDeckGood() {
        System.out.println("generateDeckGood");
        UnoDeck instance = new UnoDeck();
        int expResultSize = 44;
        int result = instance.generateDeck().size();
        assertEquals(expResultSize, result);
    }

    @Test
    public void testGenerateDeckBad() {
        System.out.println("generateDeckBad");
        UnoDeck instance = new UnoDeck();
        int expResultSize = 44;
        int result = instance.generateDeck().size();
        assertFalse(expResultSize != result);
    }

    @Test
    public void testGenerateDeckBoundary() {
        System.out.println("generateDeckBoundary");
        UnoDeck instance = new UnoDeck();
        int countRegularCards = 0;
        int countWildCards = 0;
        for (Card card : instance.generateDeck()) {
            if (card instanceof WildCard) {
                countWildCards++;
            } else {
                countRegularCards++;
            }
        }
        int expRegularCards = 40;
        int expWildCards = 4;
        assertEquals(expRegularCards, countRegularCards);
        assertEquals(expWildCards, countWildCards);
    }

    @Test
    public void testShuffleGood() {
        System.out.println("shuffleGood");
        UnoDeck instance = new UnoDeck();
        instance.generateDeck();
        Card cardInstance = instance.getUnoCards().get(21);
        instance.shuffle();
        Card cardInstanceShuffled = instance.getUnoCards().get(21);
        assertNotSame(cardInstance, cardInstanceShuffled);
    }

    @Test
    public void testShuffleBad() {
        System.out.println("shuffleBad");
        UnoDeck instance1 = new UnoDeck();
        instance1.generateDeck();
        UnoDeck instance2 = new UnoDeck();
        instance2.generateDeck();
        UnoCard cardInstance1 = instance1.getUnoCards().get(0);
        UnoCard cardInstance2 = instance2.getUnoCards().get(0);
        assertSame(cardInstance1.getCardColor(), cardInstance2.getCardColor());
        assertSame(cardInstance1.getCardValues(), cardInstance2.getCardValues());
    }

    @Test
    public void testShuffleBoundary() {
        System.out.println("shuffleBoundary");
        UnoDeck instance1 = new UnoDeck();
        instance1.generateDeck();
        ArrayList<UnoCard> cardsInstance = instance1.getUnoCards();
        UnoDeck instance2 = new UnoDeck();
        instance2.generateDeck();
        instance2.shuffle();
        ArrayList<UnoCard> cardsInstanceShuffle = instance2.getUnoCards();
        int countCard = 0;
        int countEquals = 0;
        for (UnoCard card : cardsInstance) {
            UnoCard card2 = cardsInstanceShuffle.get(countCard);
            if ((card instanceof WildCard) && (card2 instanceof WildCard)) {
                System.out.println("Enter");
                countEquals++;
            } else {
                if ((card instanceof WildCard) && !(card2 instanceof WildCard)) {
                    continue;
                }
                if (!(card instanceof WildCard) && (card2 instanceof WildCard)) {
                    continue;
                }
                if ((card.getCardColor().equals(card2.getCardColor()))
                        && (card.getCardValues().equals(card2.getCardValues()))) {
                    countEquals++;
                }
            }
            countCard++;
        }
        assertFalse(countEquals >= 39); //39 cards corresponds to 90% of cards
    }

}
