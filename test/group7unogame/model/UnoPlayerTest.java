package group7unogame.model;

import static group7unogame.model.UnoGame.prepareDeck;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test of UnoPlayer class
 *
 * @author Mariana Baroni - April 19, 2020
 */
public class UnoPlayerTest {

    public UnoPlayerTest() {
    }

    @Test
    public void testAddCardToHand() {
        System.out.println("addCardToHand");
        UnoGame uno = new UnoGame("uno");
        UnoPlayer instance = new UnoPlayer("Player1");
        UnoDeck deck = uno.drawPile;
        deck = prepareDeck(deck);
        UnoCard card = deck.getUnoCards().get(0);
        instance.addCardToHand(card);
        assertEquals(1, instance.getHand().size());
    }

    @Test
    public void testSayUnoGood() {
        System.out.println("sayUnoGood");
        UnoGame uno = new UnoGame("uno");
        UnoPlayer instance = new UnoPlayer("Player1");
        UnoDeck deck = uno.drawPile;
        deck = prepareDeck(deck);
        UnoGame.pickUpCards(instance, 1);
        instance.sayUno();
    }

    @Test
    public void testSayUnoBad() {
        System.out.println("sayUnoGood");
        UnoGame uno = new UnoGame("uno");
        UnoPlayer instance = new UnoPlayer("Player1");
        UnoDeck deck = uno.drawPile;
        deck = prepareDeck(deck);
        UnoGame.pickUpCards(instance, 3);
        instance.sayUno();
    }

    @Test
    public void testSayUnoBoundary() {
        System.out.println("sayUnoGood");
        UnoGame uno = new UnoGame("uno");
        UnoPlayer instance = new UnoPlayer("Player1");
        UnoDeck deck = uno.drawPile;
        deck = prepareDeck(deck);
        UnoGame.pickUpCards(instance, 2);
        instance.sayUno();
    }

}
