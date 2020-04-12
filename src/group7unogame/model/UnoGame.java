package group7unogame.model;

import group7unogame.model.UnoCard.Colors;
import java.util.ArrayList;

/**
 * This class represents the rules of a Uno Game.
 *
 * @author Mariana Baroni - April 11, 2020
 */
public class UnoGame extends Game {

    private static UnoDeck drawPile;
    public UnoDeck discardPile;
    public static UnoCard cardOnTop;

    static final int HAND_SIZE = 4;

    public UnoGame(String name) {
        super(name);
        this.drawPile = new UnoDeck();
    }

    @Override
    public void play() {

        ArrayList<Player> players = super.players;

        //Preparing the deck 
        drawPile.generateDeck(); //generating Uno deck
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
        cardOnTop = topCard(drawPile);
        System.out.printf("\nThe card on top is: " + cardOnTop.toString());

        //Stores the cards discarded (previous cards on Top)
        ArrayList<Card> cardsDiscarded = new ArrayList<>();

        //Stores the card played by the player
        UnoCard cardDiscarded;

        //Stores de color of the card 
        Colors color;

        do { //do until the declaration of winner

            for (int i = 0; i < players.size(); i++) {

                //Gets player
                Player player = players.get(i);

                //Stores de color of the card on top in case of the Wildcard is played.
                color = cardOnTop.getCardColor();

                do { //player makes a movement

                    player.play(); //Invoke play method

                    //Get the card played by the player 
                    cardDiscarded = ((UnoPlayer) player).getCardPlayed();

                    //If the card of player is a instance of WildCard, setup the color of card 
                    //according to the previous card on top
                    if (cardDiscarded instanceof WildCard) {
                        System.out.printf("\nThe card on top now is: "
                                + ((WildCard) cardDiscarded).toString() + " " + color);
                        cardsDiscarded.add((UnoCard) cardOnTop); //update the discard Pile
                        cardOnTop = cardDiscarded; //update card on top
                        break;
                    } else {
                        //Validates the movement of player
                        if (cardOnTop instanceof WildCard
                                && !cardDiscarded.getCardColor().equals(color)) {
                            System.out.println("Invalid movement. Try Again!");
                            ((UnoPlayer) player).addCardToHand(cardDiscarded); //gives back the card for the user
                            player.play(); //Invoke play method
                        } else if (cardOnTop instanceof WildCard
                                && cardDiscarded.getCardColor().equals(color)) {
                            System.out.println("\nThe card on top now is: " + ((UnoCard) cardDiscarded).toString());
                            cardsDiscarded.add((UnoCard) cardOnTop); //update the discard pile
                            cardOnTop = cardDiscarded; //update card on top
                            break;
                        } else {
                            if (!cardDiscarded.getCardValues().equals(cardOnTop.getCardValues())
                                    && (!cardDiscarded.getCardColor().equals(cardOnTop.getCardColor()))) {
                                System.out.println("Invalid movement. Try Again!");
                                //System.out.printf("\nThe card on top is: " + ((UnoCard) cardOnTop).toString());
                                ((UnoPlayer) player).addCardToHand(cardDiscarded); //gives back the card for the user
                                player.play(); //Invoke play method
                            } else {
                                System.out.println("\nThe card on top now is: " + ((UnoCard) cardDiscarded).toString());
                                cardsDiscarded.add((UnoCard) cardOnTop); //update the discard pile
                                cardOnTop = cardDiscarded; //update card on top
                                break;
                            }
                        }
                    }

                    //Update the color stored 
                    if (cardOnTop instanceof WildCard) {
                        for (int k = cardsDiscarded.size() - 2; k >= 0; k--) {
                            if (cardsDiscarded.get(k) instanceof WildCard) {
                                continue;
                            } else {
                                color = ((UnoCard) cardsDiscarded.get(k)).getCardColor();
                            }
                        }
                    } else {
                        color =  cardOnTop.getCardColor();
                    }

                    /*//Update the color stored 
                    //In case of other wildcard is played, gets the previous color on the discard pile
                    if  ( !(cardDiscarded instanceof WildCard) ){
                        color = cardOnTop.getCardColor();
                    }
                    else{
                        for (int k = cardsDiscarded.size()-1; k >= 0; k--){
                            if (cardsDiscarded.get(k) instanceof WildCard){
                               continue;
                            }else {
                                color = ((UnoCard)cardsDiscarded.get(k)).getCardColor(); 
                            }     
                        }
                    }
                    System.out.println(color);*/
                    //In case of other wildcard is played, gets the previous color on the discard pile
                    /*      int k = 1;
                        Card previusCard;
                        do{ 
                           previusCard = (UnoCard)cardsDiscarded.get(cardsDiscarded.size()-k);
                                   //discardPile.getUnoCards().get(discardPile.getSize() - k);
                           k++;
                        } while ( (previusCard instanceof WildCard) );
                        color = previusCard.getCardColor();
                    }  else {
                        color = cardOnTop.getCardColor();
                    }*/
                    //Update the deck of discard pile
                    discardPile.setCards(cardsDiscarded);

                    //Verifies if there are cards on the draw pile. 
                    //If not, replaces drawPile with the discardPile shuffled,
                    //to be used in case of all the cards on draw deck were used.
                    if (drawPile.getSize() < 1) {
                        discardPile.shuffle();
                        drawPile = discardPile;
                    }

                } while (true);

                //Verifies if there is a winner
                if (((UnoPlayer) player).getHand().isEmpty()) {
                    System.out.printf("\n" + player.getName());
                    declareWinner();
                    players.clear();
                    drawPile.setSize(0);
                    break;
                }
            }

        } while (true);

    }

    /**
     * Verifies if any player has a empty hand of cards.
     */
    @Override
    public void declareWinner() {
        /* for (Player player : getPlayers()) {
            if (((UnoPlayer) player).getHand().isEmpty()) {
                System.out.println(player.getName() + " has won.");
                break;
            }
        } 
        notStopTheGame = false;*/
        System.out.println(" is the winner");
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

}
