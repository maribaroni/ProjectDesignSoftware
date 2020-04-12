package group7unogame.model;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This class represents a Uno Player, with name and a group of cards.
 *
 * @author Mariana Baroni
 */
public class UnoPlayer extends Player {

    private ArrayList<Card> hand;

    public UnoPlayer(String name) {
        super(name);
        hand = new ArrayList<>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    Scanner input = new Scanner(System.in);
    UnoCard cardPlayed;
    
    int countCards; //counter of options to the user
    int counter = 0;

    @Override
    public void play() {

        //Store options in integers to the user 
        ArrayList<Integer> counterCards = new ArrayList<>();

        //Presents the current player
        System.out.printf("\n\n***** " + getName() + "'s turn *****\n");

        countCards = 0; //counter of options to the user

        //Presents the hand of cards to the user
        System.out.println("Choose a card: ");
        for (Card cards : getHand()) {
            countCards++;
            System.out.println(countCards + ". " + ((UnoCard) cards).toString());
            counterCards.add(countCards);
        }

        //in case of user first use of pick a card
        if (counter == 1) {
            System.out.println("0. Skip turn");
            counterCards.add(0);
        } else {
            countCards++;
            System.out.println(countCards + ". Pick a card");
            counterCards.add(countCards);
        }

        //Regular expression of options
        String regex = "[0-9]{1,}";

        String userEnter = null; //input of user
        int userEnterInt = -1; //input of user in integer type
        
        //Validation of user entry
        do {
            userEnter = input.nextLine();
            try {
                userEnterInt = Integer.parseInt(userEnter);
                if (Pattern.matches(regex, userEnter) && !counterCards.contains(userEnterInt)) {
                    System.out.println("Please, enter a number among the options.");
                } else {
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Please, enter a number among the options.");
            }
        } while (true);

        //Play a card from the hand
        
        if (counter == 0 && userEnterInt == countCards){
            counter = 1; //the user can pick a card once
            UnoGame.pickUpCards(this, 1);
            play();  
        } else if (userEnterInt == 0) {
            cardPlayed = UnoGame.cardOnTop;
            counter = 0;
        } else {
            cardPlayed = (UnoCard)(getHand().get(userEnterInt - 1));
            hand.remove(cardPlayed);
            counter = 0;
        }
        
        //verifies and say Uno
        sayUno();

    }

    /**
     * Add a card to the player's hand of cards
     * @param card 
     */
    public void addCardToHand(Card card) {
        hand.add(card);
    }

    /**
     * Says Uno when the player reaches on card in the hand of cards
     */
    public void sayUno() {
        if (getHand().size() == 1) {
            System.out.println("\n" + this.getName() +" says \n------UNO------.");
        }
    }

    /**
     * To get the card played by the player
     * @return 
     */
    public UnoCard getCardPlayed() {
        return this.cardPlayed;//unoCard;
    }

}
