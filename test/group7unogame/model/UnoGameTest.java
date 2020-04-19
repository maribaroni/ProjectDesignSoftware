package group7unogame.model;

import static group7unogame.model.UnoGame.prepareDeck;
import static group7unogame.model.UnoGame.topCard;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * JUnit test of UnoGame class
 * 
 * @author Mariana Baroni - April 19, 2020
 */
public class UnoGameTest {

    public UnoGameTest() {
    }

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
        System.out.println("declareWinnerBad");
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
        System.out.println("distributeHandOfCardsBoundary");
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
        System.out.println("topCardBoundary");
        UnoGame instance = new UnoGame("uno");
        UnoDeck deck = instance.drawPile;
        deck = prepareDeck(deck);
        UnoCard card = topCard(deck);
        int deckSize = deck.getUnoCards().size();
        boolean isColouredCard = !(card instanceof WildCard);
        assertTrue(deckSize == 43 && isColouredCard);
    }

    @Test
    public void testIsValideMoveGood() {
        System.out.println("isValideMoveGood");
        UnoGame.cardOnTop = new UnoCard(UnoCard.Colors.Red, UnoCard.Values.Zero);
        UnoPlayer player = new UnoPlayer("Player1");
        UnoCard cardDiscarded = new UnoCard(UnoCard.Colors.Red, UnoCard.Values.Zero);
        UnoCard.Colors color = UnoGame.cardOnTop.getCardColor();
        boolean expResult = true;
        boolean result = UnoGame.isValideMove(player, cardDiscarded, color);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValideMoveBad() {
        System.out.println("isValideMoveBad");
        UnoGame.cardOnTop = new UnoCard(UnoCard.Colors.Red, UnoCard.Values.Eight);
        UnoPlayer player = new UnoPlayer("Player1");
        UnoCard cardDiscarded = new UnoCard(UnoCard.Colors.Green, UnoCard.Values.One);
        UnoCard.Colors color = UnoGame.cardOnTop.getCardColor();
        boolean expResult = false;
        boolean result = UnoGame.isValideMove(player, cardDiscarded, color);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValideMoveBoundary1() {
        System.out.println("isValideMoveBoundary1");
        UnoGame.cardOnTop = new UnoCard(UnoCard.Colors.Red, UnoCard.Values.Eight);
        UnoPlayer player = new UnoPlayer("Player1");
        UnoCard cardDiscarded = new UnoCard(UnoCard.Colors.Red, UnoCard.Values.One);
        UnoCard.Colors color = UnoGame.cardOnTop.getCardColor();
        boolean expResult = true;
        boolean result = UnoGame.isValideMove(player, cardDiscarded, color);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValideMoveBoundary2() {
        System.out.println("isValideMoveBoundary2");
        UnoGame.cardOnTop = new UnoCard(UnoCard.Colors.Red, UnoCard.Values.One);
        UnoPlayer player = new UnoPlayer("Player1");
        UnoCard cardDiscarded = new UnoCard(UnoCard.Colors.Green, UnoCard.Values.One);
        UnoCard.Colors color = UnoGame.cardOnTop.getCardColor();
        boolean expResult = true;
        boolean result = UnoGame.isValideMove(player, cardDiscarded, color);
        assertEquals(expResult, result);
    }

}
