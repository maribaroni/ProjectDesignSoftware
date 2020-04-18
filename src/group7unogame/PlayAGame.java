package group7unogame;

import group7unogame.model.Game;
import group7unogame.model.GroupOfCards;
import group7unogame.model.Player;
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
 * @modified Mariana Baroni - April 17, 2020
 */
public class PlayAGame {

    public static void main(String[] args) {

        //Data field
        Scanner input = new Scanner(System.in);
        String numberOfPlayers = "-1";
        // UnoDeck drawPile = new UnoDeck();
        String gameChosen = "-1";

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
            gameChosen = input.nextLine();
            if (!Pattern.matches(regex1, gameChosen)) {
                do {
                    System.out.println("Please enter the number 0 or the number 1.");
                    gameChosen = input.nextLine();
                } while (!Pattern.matches(regex1, gameChosen));
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
                    numberOfPlayers = input.nextLine();
                    String regex2 = "[234]{1}";

                    //Validate input
                    if (!Pattern.matches(regex2, numberOfPlayers)) {
                        do {
                            System.out.println("Please enter a number between 2 and 4.");
                            numberOfPlayers = input.nextLine();
                        } while (!Pattern.matches(regex2, numberOfPlayers));
                    }

                    //Create an ArrayList of Uno Players
                    ArrayList<Player> players = new ArrayList<>(Integer.parseInt(numberOfPlayers));
                    for (int i = 0; i < Integer.parseInt(numberOfPlayers); i++) {
                        System.out.print("Enter the name of " + (i + 1) + " player: ");
                        Player player = new UnoPlayer(input.nextLine().trim());
                        players.add((UnoPlayer) player);
                    }

                    //Set Players
                    uno.setPlayers(players);

                    //Run the game
                    while (true) {
                        uno.play();
                    }
            }
        } while (false);
    }

}
