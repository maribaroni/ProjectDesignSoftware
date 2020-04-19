/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group7unogame.model;

import static group7unogame.model.UnoGame.prepareDeck;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maria
 */
public class UnoPlayerTest {
    
    public UnoPlayerTest() {
    }

   /* @Test
    public void testPlayGood() {
        System.out.println("playGood");
        UnoGame uno = new UnoGame("uno");
        UnoDeck deck = uno.drawPile;
        deck = prepareDeck(deck);
        UnoPlayer instance = new UnoPlayer("Player1");
        ArrayList<Player> players = new ArrayList<>();
        players.add(instance);
        uno.setPlayers(players);
        uno.distributeHandOfCards();
        instance.play();
        UnoCard card = instance.cardPlayed;
        System.out.println(card.toString());
       // boolean cardColoured = !(card instanceof WildCard);
       // boolean cardWildCard = (card instanceof WildCard);
      //  assertTrue(cardColoured || cardWildCard);
    }*/

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
