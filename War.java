/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War
{
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */
    public War()
    {
        // Initializations here...
        System.out.println("game over in 300 rounds");
        System.out.println();
        Deck deck = new Deck();
        deck.initializeNewDeck();
        deck.shuffle();
        Deck[] halves = deck.dealDeck();
        Deck playerOne = halves[0];
        Deck playerTwo = halves[1];

        // ...then run the event loop

        this.runEventLoop(playerOne, playerTwo);
    }

    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop(Deck playerOne, Deck playerTwo) {
        int round = 1;
        boolean enoughCards = true;

        while(playerOne.getDeckSize() > 0 && playerTwo.getDeckSize() > 0  ) {
            enoughCards = true;
            int sizeOfOne = playerOne.getDeckSize();
            int sizeOfTwo = playerTwo.getDeckSize();
            
            System.out.println("player one has " + sizeOfOne + " cards.");
            System.out.println("player two has " + sizeOfTwo + " cards.");
            System.out.println("it is currently round: " + round);
        }
    }

    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }
}
