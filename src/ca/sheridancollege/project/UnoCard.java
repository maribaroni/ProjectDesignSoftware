package ca.sheridancollege.project;

/**
 * This class represents a regular Uno Card, with color and value.
 *
 * GROUP 7:
 *
 * @modified Mariana Baroni - March 10, 2020
 * @modified Danish Siddiqui - March, 2020
 * @modified Husam Haidarah - March, 2020
 * @modified Katrina Metha - March, 2020
 */
public class UnoCard extends Card {

    protected Colors cardColor;
    private Values cardValue;

    public enum Colors {
        RED, YELLOW, GREEN, BLUE
    };

    public enum Values {
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGTH, NINE
    };

    public UnoCard(Colors cardColor, Values cardValue) {
        this.cardColor = cardColor;
        this.cardValue = cardValue;
    }

    public UnoCard(Colors cardColor) {
        this.cardColor = cardColor;
    }
    
    public Colors getCardColor() {
        return cardColor;
    }

    public Values getCardValues() {
        return cardValue;
    }

    @Override
    public String toString() {
        return cardColor +" "+cardValue;
    }
}
