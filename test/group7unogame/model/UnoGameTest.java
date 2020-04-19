/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group7unogame.model;

import static group7unogame.model.UnoGame.prepareDeck;
import static group7unogame.model.UnoGame.topCard;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class UnoGameTest {

    public UnoGameTest() {
    }

    /*@Test
    public void testPlay() {
        System.out.println("play");
        UnoGame instance = null;
        instance.play();
        fail("The test case is a prototype.");
    }*/
    @Test
    public void testDeclareWinnerGood() {
        System.out.println("declareWinnerGood");
        UnoGame instance = new UnoGame("uno");
        UnoPlayer player = new UnoPlayer("Player1");
        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        instance.setPlayers(players);
        UnoDeck deck = instance.drawPile;
        deck = prepareDeck(deck);
        instance.declareWinner();
    }
    
    @Test
    public void testDeclareWinnerBad() {
        System.out.println("declareWinnerGood");
        UnoGame instance = new UnoGame("uno");
        UnoPlayer player = new UnoPlayer("Player1");
        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        instance.setPlayers(players);
        UnoDeck deck = instance.drawPile;
        deck = prepareDeck(deck);
        instance.distributeHandOfCards();
        instance.declareWinner();
    }

    @Test
    public void testPickUpCardsGood() {
        System.out.println("pickUpCardsGood");
        UnoGame instance = new UnoGame("uno");
        UnoDeck deck = instance.drawPile;
        deck = prepareDeck(deck);
        UnoPlayer player = new UnoPlayer("Player1");
        int numberOfCards = 2;
        UnoGame.pickUpCards(player, numberOfCards);
        assertEquals(2, player.getHand().size());
    }

    @Test
    public void testPickUpCardsBad() {
        System.out.println("pickUpCardsBad");
        UnoGame instance = new UnoGame("uno");
        UnoDeck deck = instance.drawPile;
        deck = prepareDeck(deck);
        UnoPlayer player = new UnoPlayer("Player1");
        int numberOfCards = 0;
        UnoGame.pickUpCards(player, numberOfCards);
        assertEquals(0, player.getHand().size());
    }
    
    @Test
    public void testPickUpCardsBoundary() {
        System.out.println("pickUpCardsBoundary");
        UnoGame instance = new UnoGame("uno");
        UnoDeck deck = instance.drawPile;
        deck = prepareDeck(deck);
        UnoPlayer player = new UnoPlayer("Player1");
        int numberOfCards = 1;
        UnoGame.pickUpCards(player, numberOfCards);
        assertEquals(1, player.getHand().size());
    }


    /*
    @Test
    public void testGetCardPlayed() {
        System.out.println("getCardPlayed");
        UnoGame instance = null;
        UnoCard expResult = null;
        UnoCard result = instance.getCardPlayed();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }*/
    @Test
    public void testDistributeHandOfCardsGood() {
        System.out.println("distributeHandOfCardsGood");
        UnoGame instance = new UnoGame("uno");
        Player player = new UnoPlayer("Player1");
        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        instance.setPlayers(players);
        UnoDeck deck = instance.drawPile;
        deck = prepareDeck(deck);
        instance.distributeHandOfCards();
        int handPlayerSize = ((UnoPlayer) player).getHand().size();
        int deckSize = deck.getUnoCards().size();
        assertTrue(handPlayerSize <= 4);
        assertTrue(deckSize <= 40);
    }

    @Test
    public void testDistributeHandOfCardsBad() {
        System.out.println("distributeHandOfCardsBad");
        UnoGame instance = new UnoGame("uno");
        Player player = new UnoPlayer("Player1");
        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        instance.setPlayers(players);
        UnoDeck deck = instance.drawPile;
        deck = prepareDeck(deck);
        instance.distributeHandOfCards();
        int handPlayerSize = ((UnoPlayer) player).getHand().size();
        int deckSize = deck.getUnoCards().size();
        assertFalse(handPlayerSize > 5);
        assertFalse(deckSize > 40);
    }

    @Test
    public void testDistributeHandOfCardsBoundary() {
        System.out.println("distributeHandOfCardsBad");
        UnoGame instance = new UnoGame("uno");
        Player player = new UnoPlayer("Player1");
        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        instance.setPlayers(players);
        UnoDeck deck = instance.drawPile;
        deck = prepareDeck(deck);
        instance.distributeHandOfCards();
        int handPlayerSize = ((UnoPlayer) player).getHand().size();
        int deckSize = deck.getUnoCards().size();
        assertEquals(handPlayerSize, 4);
        assertEquals(deckSize, 40);
    }

    @Test
    public void testTopCardGood() {
        System.out.println("topCardGood");
        UnoGame instance = new UnoGame("uno");
        UnoDeck deck = instance.drawPile;
        deck = prepareDeck(deck);
        UnoCard card = topCard(deck);
        int deckSize = deck.getUnoCards().size();
        boolean isColouredCard = !(card instanceof WildCard);
        assertTrue(deckSize <= 43 && isColouredCard);
    }

    @Test
    public void testTopCardBad() {
        System.out.println("topCardBad");
        UnoGame instance = new UnoGame("uno");
        UnoDeck deck = instance.drawPile;
        deck = prepareDeck(deck);
        UnoCard card = topCard(deck);
        int deckSize = deck.getUnoCards().size();
        boolean isWildCard = (card instanceof WildCard);
        assertFalse(deckSize != 43 || isWildCard);
    }

    @Test
    public void testTopCardBoundary() {
        System.out.println("topCardGood");
        UnoGame instance = new UnoGame("uno");
        UnoDeck deck = instance.drawPile;
        deck = prepareDeck(deck);
        UnoCard card = topCard(deck);
        int deckSize = deck.getUnoCards().size();
        boolean isColouredCard = !(card instanceof WildCard);
        assertTrue(deckSize == 43 && isColouredCard);
    }
}
