package group7unogame.model;

/**
 * This class represents a wildcard. It is general enough to be instantiated for any Game. 
 * In case of UnoGame, the wildcard inherent color.
 *
 * GROUP 7:
 *
 * @modified Mariana Baroni - April 17, 2020
 */
public class WildCard extends UnoCard {

    private String name;

    public WildCard(String name, Colors cardColor) {
        super(cardColor);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCardColor(Colors color) {
        super.cardColor = color;
    }

    @Override
    public Colors getCardColor() {
        return cardColor;
    }
}
