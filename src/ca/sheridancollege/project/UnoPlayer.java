package ca.sheridancollege.project;

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

    @Override
    public void play() {
        //code to play
    }
}