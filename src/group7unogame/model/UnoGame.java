package group7unogame.model;

import group7unogame.model.UnoCard.Colors;
import java.util.ArrayList;

/**
 * This class represents the rules of a Uno Game.
 *
 * @author Mariana Baroni - April 17, 2020
 */
public class UnoGame extends Game {

    private static UnoDeck drawPile;
    private ArrayList<Card> discardPile = new ArrayList<>();
    public static UnoCard cardOnTop;
    static final int HAND_SIZE = 10;

    public UnoGame(String name) {
        super(name);
        this.drawPile = new UnoDeck();
    }

    @Override
    public void play() {

        ArrayList<Player> players = super.players;

        //Preparing the deck 
        drawPile.generateDeck();
        drawPile.shuffle(); //Shuffle the cards

        //Preparing the hand of players
        for (Player player : players) {
            for (int i = 0; i < HAND_SIZE; i++) {
                //populates hand and remove the card from the deck
                pickUpCards(player, 1);
            }
        }

        //Store players with a hand of cards
        setPlayers(players);

        //Set up the card on top
        cardOnTop = ((UnoCard) topCard(drawPile));
        System.out.println("\nThe card on top is: " + cardOnTop.toString());

        do { //do until the declaration of winner

            //Stores the card played by the player
            UnoCard cardDiscarded = null;

            for (int i = 0; i < players.size(); i++) {

                //Gets player
                Player player = players.get(i);

                //Stores de color of the card on top in case of the Wildcard is played.
                Colors color = cardOnTop.getCardColor();

                //Presents the current player
                System.out.println("\n\n***** " + player.getName() + "'s turn *****");

                do { //player makes a movement

                    player.play(); //Invoke play method

                    //Get the card played by the player 
                    cardDiscarded = getCardPlayed();

                    //If the card of player is a instance of WildCard, setup the color of card 
                    //according to the previous card on top
                    if (cardDiscarded instanceof WildCard) {
                        System.out.printf("\nThe card on top now is: "
                                + ((WildCard) cardDiscarded).toString() + " " + color);
                        ((WildCard) cardDiscarded).setCardColor(color);
                        cardOnTop = cardDiscarded; //update card on top
                        break;
                    } else {
                        //Validates the movement of player
                        if (cardOnTop instanceof WildCard
                                && (!(cardDiscarded.getCardColor().equals(color)))) {
                            System.out.println("Invalid movement. Try Again!");
                            ((UnoPlayer) player).addCardToHand(cardDiscarded); //gives back the card for the user
                        }
                        if (cardOnTop instanceof WildCard
                                && cardDiscarded.getCardColor().equals(color)) {
                            System.out.println("\nThe card on top now is: " + ((UnoCard) cardDiscarded).toString());
                            cardOnTop = cardDiscarded; //update card on top
                            break;
                        }
                        if (!cardDiscarded.getCardValues().equals(cardOnTop.getCardValues())
                                && (!cardDiscarded.getCardColor().equals(cardOnTop.getCardColor()))) {
                            System.out.println("Invalid movement. Try Again!");
                            ((UnoPlayer) player).addCardToHand(cardDiscarded); //gives back the card for the user
                        } else {
                            System.out.println("\nThe card on top now is: " + ((UnoCard) cardDiscarded).toString());
                            cardOnTop = cardDiscarded; //update card on top
                            break;
                        }
                    }

                } while (true);

                //Update the dicardPile
                discardPile.add(cardDiscarded);

                //Verifies if there are cards on the draw pile. 
                //If not, replaces drawPile with the discardPile shuffled,
                //to be used in case of all the cards on draw deck were used.
                if (drawPile.getUnoCards().size() <= 1) {
                    try {
                        drawPile.setCards(discardPile);
                        drawPile.shuffle();
                    } catch (NullPointerException | IndexOutOfBoundsException ex) {
                        System.out.println("\nAll cards are with the players! Game is over!");
                        System.exit(0);
                    }

                }

                declareWinner();

            }

        } while (true);

    }

    /**
     * Verifies if any player has a empty hand of cards.
     */
    @Override
    public void declareWinner() {
        for (Player player : getPlayers()) {
            if (((UnoPlayer) player).getHand().isEmpty()) {
                System.out.println("\n" + player.getName() + " has won.");
                System.exit(0);
            }
        }
    }

    /**
     * Method responsible to remove one card from the deck and put on top to start the game, avoiding wildcards
     *
     * @param deckUno
     * @return a card
     */
    public static UnoCard topCard(UnoDeck deckUno) {
        int i = 1;
        UnoCard card = deckUno.getUnoCards().get(deckUno.getUnoCards().size() - i); //pick the last card
        //If the first topCard is a wildcard, try another from the deck
        while (card instanceof WildCard) {
            i++;
            card = deckUno.getUnoCards().get(deckUno.getUnoCards().size() - i);
        }
        deckUno.getUnoCards().remove(card); //remove the card from the deck
        deckUno.setSize(deckUno.getUnoCards().size() - 1); //set the new size to the deck
        return card;
    }

    /**
     * Method responsible to pick a card from the deck to the user
     *
     * @param player
     * @param numberOfCards to be picked
     */
    public static void pickUpCards(Player player, int numberOfCards) {
        UnoCard card = drawPile.getUnoCards().get(drawPile.getUnoCards().size() - 1); //pick the last card
        drawPile.getUnoCards().remove(card); //remove the card from the deck
        ((UnoPlayer) player).addCardToHand(card); //add a Card to the hand's player
        drawPile.setSize(drawPile.getUnoCards().size()); //set the new size to the deck
    }

    /**
     * To get the card played by the player
     *
     * @return
     */
    public UnoCard getCardPlayed() {
        return UnoPlayer.cardPlayed;//unoCard;
    }

}
