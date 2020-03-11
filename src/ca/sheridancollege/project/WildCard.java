package ca.sheridancollege.project;

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
public class WildCard extends UnoCard{

    public WildCard(Colors cardColor) {
        super(cardColor);
    }

    public void setCardColor(Colors color){
        this.cardColor = color;
    }
}
