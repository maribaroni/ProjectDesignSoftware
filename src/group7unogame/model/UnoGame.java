package group7unogame.model;

import group7unogame.model.UnoCard.Colors;
import group7unogame.model.UnoCard.Values;

/**
 * This class ***Insert Description here***
 *
 * @author Mariana Baroni
 */
public class UnoGame extends Game {

    private UnoDeck drawPile;
    private UnoDeck discardPile;
    private int playerIndex = 0;

    static final int HAND_SIZE = 4;

    public UnoGame(String name) {
        super(name);
        this.drawPile = new UnoDeck();
        this.discardPile = new UnoDeck();
    }

    //validate move
    @Override
    public void play() {

        //Preparing the deck 
        drawPile.generateDeck(); //generating Uno deck
        drawPile.shuffle(); //Shuffle the cards

        //Preparing the hand of players
        for (Player player : getPlayers()) {
            pickUpCards(player, drawPile, 4);
        }
        //PRINT HAND OF PLAYERS
        /* for (Player player : players){
            ArrayList<Card> cardsHand = ((UnoPlayer)player).getHand();
            for (Card i : cardsHand){
                System.out.println(i.toString());
            }
        }*/
        
        //store players with a hand of cards
        setPlayers(players); 

        System.out.printf("The card on top is: ");
        Card cardOnTop = topCard(drawPile);
        //If the first topCard is a wildcard
  
        do {

            //Verifies if there is a winner
            declareWinner();

            Player player = getPlayers().get(playerIndex);
            player.play(); 
            String cardOnTopPlayer = player.getTopCard(cardOnTop);
            playerIndex++;

        } while (true);
    }

    @Override
    public void declareWinner() {
        for (Player player : getPlayers()) {
            if (((UnoPlayer) player).getHand().isEmpty()) {
                System.out.println(player.getName() + " has won.");
                break;
            }
        }
    }

    public static UnoCard topCard(UnoDeck deckUno) {
        UnoCard card = deckUno.getUnoCards().get(deckUno.getUnoCards().size() - 1); //pick the last card
        deckUno.getUnoCards().remove(card); //remove the card from the deck
        deckUno.setSize(deckUno.getUnoCards().size() - 1); //set the new size to the deck
        return card;
    }

    public static void pickUpCards(Player player, UnoDeck deckUno, int handSize) {
        for (int i = 0; i < handSize; i++) {
            Card card = deckUno.getUnoCards().get(deckUno.getUnoCards().size() - 1); //pick the last card
            ((UnoPlayer) player).addCardToHand(card); //add a Card to the hand's player
            deckUno.getUnoCards().remove(card); //remove the card from the deck
            deckUno.setSize(deckUno.getUnoCards().size() - 1); //set the new size to the deck
        }
    }
    
    public void getTopCard(Card cardOnTop){
            if (cardOnTop instanceof WildCard) {
            cardOnTop = topCard(drawPile);
        }
        System.out.println(cardOnTop.toString());
    }
}
