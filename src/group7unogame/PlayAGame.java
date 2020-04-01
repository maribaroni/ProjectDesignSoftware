package group7unogame;

import group7unogame.model.Card;
import group7unogame.model.Game;
import group7unogame.model.GroupOfCards;
import group7unogame.model.Player;
import group7unogame.model.UnoCard;
import group7unogame.model.UnoDeck;
import group7unogame.model.UnoGame;
import group7unogame.model.UnoPlayer;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This class is the main method to play a Game.
 *
 * GROUP 7:
 *
 * @modified Mariana Baroni - March 10, 2020
 * @modified Danish Siddiqui - February 12, 2020
 * @modified Husam Haidarah - February 12, 2020
 * @modified Katrina Metha - February 12, 2020
 */
public class PlayAGame {

    public static void main(String[] args) {

        //Data field
        Scanner input = new Scanner(System.in);
        String numberOfPlayers = "-1";
        String gameChosen = "-1";
        UnoDeck drawPile = new UnoDeck();
        final int handSize = 4;

        //Greeting players
        System.out.println("***** WELCOME PLAYERS *****");

        //PRINT DECK
        /* UnoDeck deckUno = new UnoDeck();
        deckUno.generateDeck();
        ArrayList<UnoCard> cards = deckUno.getUnoCards();
        for ( Card i : cards){
            System.out.println(i.toString());
        }*/
        
        
        // A loop that presents options to the user until he wants to exit the application
        String regex1 = "[01]{1}";
        do {

            //Ask which game they want to play
            System.out.println("\nWhat card game do you wanna to play? Digit 1 for Uno or 0 to exit the application.");
            //Validate input
            try {
                gameChosen = input.nextLine();
                if (!Pattern.matches(regex1, gameChosen)) {
                    do {
                        System.out.println("Please enter the number 0 or the number 1.");
                        gameChosen = input.nextLine();
                    } while (!Pattern.matches(regex1, gameChosen));
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter the number 0 or the number 1.");
            }

            //Chose the game according to the user input (other games can be added for each case)
            switch (gameChosen) {

                case "0":
                    break;

                case "1":

                    //Instantiate UnoGame
                    Game uno = new UnoGame("Uno");

                    //Ask how many players
                    System.out.println("How many players are playing today (choose a number between 2 and 4)?");
                    String regex2 = "[2-4]{1}";

                    //Validate input
                    try {
                        numberOfPlayers = input.nextLine();
                        if (!Pattern.matches(regex2, numberOfPlayers)) {
                            do {
                                System.out.println("Please enter a number between 2 and 4.");
                                numberOfPlayers = input.nextLine();
                            } while (!Pattern.matches(regex2, numberOfPlayers));
                        }
                    } catch (InputMismatchException ex) {
                        System.out.println("Please enter a number between 2 and 4.");
                    }

                    //Create an ArrayList of Uno Players
                    ArrayList<Player> players = new ArrayList<>(Integer.parseInt(numberOfPlayers));
                    for (int i = 0; i < Integer.parseInt(numberOfPlayers); i++) {
                        System.out.print("Enter the name of " + (i + 1) + " player: ");
                        Player player = new UnoPlayer(input.nextLine().trim());
                        players.add((UnoPlayer) player);
                    }
                    
                    //PRINT PLAYERS
                    /*for(Player i : players){
                        System.out.println(i.getName());
                    }*/

                    
                    
                    //PRINT HAND OF PLAYERS
                    /* for (Player player : players){
                        ArrayList<Card> cardsHand = ((UnoPlayer)player).getHand();
                        for (Card i : cardsHand){
                            System.out.println(i.toString());
                        }
                    }*/

                    //Run the game
                    while (true) {
                        uno.play();
                    }

            }

        }  while (false); 
    }
    
}
