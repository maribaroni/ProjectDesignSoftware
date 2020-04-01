package group7unogame.model;

import java.util.ArrayList;

/**
 * This class represents a Uno Player, with name and a group of cards.
 *
 * @author Mariana Baroni
 */
public class UnoPlayer extends Player {

    private ArrayList<Card> hand;

    public UnoPlayer(String name) {
        super(name);
        hand = new ArrayList<Card>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
    
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    
    @Override
    public void play() {
        //code to play
        System.out.println("***** " + getName() + "'s turn *****");
        
    }

    public void addCardToHand(Card card){
        hand.add(card);
    }
    
    public void sayUno(UnoPlayer player) {
        if (((UnoPlayer) player).getHand().size() == 1) {
            System.out.println(player.getName() + " say UNO.");
        }
    }
    
    public UnoCard getTop(){
        return unoCard;
    }

}