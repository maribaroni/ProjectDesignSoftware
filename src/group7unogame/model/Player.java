package group7unogame.model;

/**
 * A class that models each Player in the game with a unique identifier.
 *
 * @author dancye
 * GROUP 7:
 * @modified Paul Bonenfant Jan 2020
 * @modified Mariana Baroni - April 10, 2020
 * @modified Danish Siddiqui - February 12, 2020
 * @modified Husam Haidarah - February 12, 2020
 * @modified Katrina Metha - February 12, 2020
 */
public abstract class Player {

    private String name; //the unique name for this player

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
     * with logic to play your game.
     */
    public abstract void play();

}
