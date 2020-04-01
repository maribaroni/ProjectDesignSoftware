package group7unogame.model;

/**
 * This class represents a wildcard. It is general enough to be instantiated for any Game. game.
 *
 * GROUP 7:
 *
 * @modified Mariana Baroni - March 10, 2020
 * @modified Danish Siddiqui - March, 2020
 * @modified Husam Haidarah - March, 2020
 * @modified Katrina Metha - March, 2020
 */
public class WildCard extends UnoCard {

    private String name;

    /*public WildCard(String name) {
        this.name = name;
    }

    public WildCard(String name, Colors cardColor) {
        super(cardColor);
        this.name = name;
    }

    public WildCard(Colors cardColor, Values cardValue) {
        super(cardColor, cardValue);
    }*/

    public WildCard(String name, Colors cardColor, Values cardValue) {
        super(cardColor, cardValue);
        this.name = name;
    }
    
    

    /*public WildCard(Colors cardColor) {
        super(cardColor);
    }*/
    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
