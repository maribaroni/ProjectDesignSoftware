package ca.sheridancollege;

import ca.sheridancollege.project.Game;
import ca.sheridancollege.project.Player;
import ca.sheridancollege.project.UnoGame;
import ca.sheridancollege.project.UnoPlayer;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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
        int numberOfPlayers;
        int gameChosen = -1;

        //Greeting players
        System.out.println("***** WELCOME PLAYERS *****");

        // A loop that presents options to the user until he wants to exit the application
        do {
            //Ask which game they want to play
            System.out.println("What card game do you wanna to play? Digit 1 for Uno or 0 to exit the application");
            //Validate input
            do {
                try {
                    gameChosen = input.nextInt();
                    if (gameChosen != 0 && gameChosen != 1) {
                        do {
                            System.out.println("Please enter the number 0 or the number 1.");
                            gameChosen = input.nextInt();
                        } while (gameChosen != 0 && gameChosen != 1);
                    }
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Please enter the number 0 or the number 1.");
                }
            } while (true);

            //Chose the game according to the user input (other games can be added for each case)
            switch (gameChosen) {
                case 1:
                    Game uno = new UnoGame(input.nextLine().trim());
                    //Ask how many players
                    System.out.println("How many players are playing today (choose a number between 2 and 10)?");
                    //Validate the input
                    do {
                        try {
                            numberOfPlayers = input.nextInt();
                        } catch (InputMismatchException ex) {
                            System.out.println("Please, enter a integer number between 2 and 10.");
                        }
                    } while (true);
                    
                    //Create an ArrayList of Uno Players
                    ArrayList<Player> players = new ArrayList<>(numberOfPlayers);
                    for (int i = 0; i < numberOfPlayers; i++) {
                        System.out.print("Enter the namer of " + (i + 1) + " player:");
                        players.add(new UnoPlayer(input.nextLine().trim()));
                    }
                    uno.setPlayers(players);
                    //code to prepare a hand to players

                    //Run the game
                    while (true) {
                        uno.play();
                    }

                   break;
            }

        } while (gameChosen != 0);
    }
}
