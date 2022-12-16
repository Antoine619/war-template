import java.util.ArrayList;
import java.util.List;

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
        Deck deck = new Deck();
        deck.initializeNewDeck();
        deck.shuffle();
        Deck[] halves = deck.dealDeck();
        Deck playerOne = halves[0];
        Deck playerTwo = halves[1];

        // ...then run the event loop

        this.runEventLoop(playerOne, playerTwo);
    }

    public void realWar() {
        Deck deck = new Deck();
        deck.initializeNewDeck();
        deck.shuffle();
        Deck[] halves = deck.dealDeck();
        Deck playerOneWar = halves[0];
        Deck playerTwoWar = halves[1];
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

            System.out.println("ROUND " + round);
            System.out.println("player one has " + sizeOfOne + " cards.");
            System.out.println("player two has " + sizeOfTwo + " cards.");

            System.out.println();

            Card p1 = playerOne.dealCardFromDeck();
            Card p2 = playerTwo.dealCardFromDeck();

            System.out.println("Player one card: " + p1.getFace() + " of " + p1.getSuit());
            System.out.println("Player two card: " + p2.getFace() + " of " + p2.getSuit());
            System.out.println();
            try{
                if(p1.getRank() < p2.getRank()){
                    System.out.println("player 2 wins round " + round);
                    playerOne.addCardToDeck(p1);
                    playerOne.addCardToDeck(p2);
                }
                if(p1.getRank() > p2.getRank()){
                    System.out.println("player 1 wins round " + round);
                    playerTwo.addCardToDeck(p2);
                    playerTwo.addCardToDeck(p1);
                }
                else{
                    List<Card> deckOne = new ArrayList<Card>();
                    List<Card> deckTwo = new ArrayList<Card>();

                    deckOne.add(p1);
                    deckTwo.add(p2);

                    while(p1.getRank() == p2.getRank()){
                        System.out.println("WAR");
                        System.out.println();

                        System.out.println("Player one card " + p1.getFace() + " of " + p1.getSuit());
                        System.out.println("Player two card " + p2.getFace() + " of " + p2.getSuit());
                        System.out.println();
                        for(int i = 0; i < 3; i++){
                            deckOne.add(playerOne.dealCardFromDeck());
                            deckTwo.add(playerTwo.dealCardFromDeck());
                        }
                        p1 = playerOne.dealCardFromDeck();
                        p2 = playerTwo.dealCardFromDeck();

                        deckOne.add(p1);
                        deckTwo.add(p2);

                        System.out.println("Player 1 Card: " + p1.getFace() + " of " + p1.getSuit());
                        System.out.println("Player 2 Card: " + p2.getFace() + " of " + p2.getSuit());
                        System.out.println();

                        if(p1.getRank() < p2.getRank()){
                            System.out.println("player 2 wins the war");
                            for (Card card: deckOne  ) {
                                playerOne.addCardToDeck(card);
                            }
                            for(Card card : deckTwo) {
                                playerOne.addCardToDeck(card);
                            }
                        }
                        if(p1.getRank() > p2.getRank()){
                            System.out.println("player 1 wins the war");
                            for (Card card: deckOne  ) {
                                playerTwo.addCardToDeck(card);
                            }
                            for(Card card : deckTwo) {
                                playerTwo.addCardToDeck(card);
                            }
                        }
                    }   
                }
                round++;
                System.out.println();
            }
            catch (Exception e) {
                enoughCards = false;
                if (playerOne.getDeckSize() < 4) {
                    System.out.println("player 1 - insufficient cards - player 2 wins.");
                }
                System.out.println();
                if (playerTwo.getDeckSize() < 4) {
                    System.out.println("player 2 - insufficient cards - player 1 wins.");
                }
                break;
            }
            if(round > 300) {
                break;
            }
        }
        System.out.println("------------------MATCH RESULTS--------------------");
        System.out.println();
        System.out.println("player one has " + playerOne.getDeckSize() + (" cards."));
        System.out.println();
        System.out.println("player two has " + playerTwo.getDeckSize() + (" cards."));
        System.out.println();
        System.out.println("and thus...");
        System.out.println();
        if(playerOne.getDeckSize() > playerTwo.getDeckSize()){
            System.out.println("player one wins!");
        }
        if(playerOne.getDeckSize() < playerTwo.getDeckSize()) {
            System.out.println("player two wins!");
        }
        System.out.println();
        System.out.println("GAME OVER :-)");
    }

    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }
}
