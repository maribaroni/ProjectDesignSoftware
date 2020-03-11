package ca.sheridancollege.project;

/**
 * This class ***Insert Description here***
 * 
 * @author Mariana Baroni
 */
public class UnoGame extends Game {
    
    private GroupOfCards drawPile;
    private GroupOfCards discardPile;


    public UnoGame(String name) {
        super(name);
        this.drawPile = new GroupOfCards(44);//4 wildcards and 40 regular cards
        this.discardPile = new GroupOfCards(0);
    }
    
    //code to prepare the
        //dicard pile
        //pick cards to form a hand
        //validate move
    
    
    @Override
    public void play() {
        
        //code to play
    }

    @Override
    public void declareWinner() {
        for(Player player: getPlayers()){
            if (((UnoPlayer)player).getHand().isEmpty()){
                System.out.println(player.getName()+" has won.");
                System.exit(0);
            }
        }
    }
}
