package tech.mabunda.player;

/**
 * Represents a player in the UNO game. This is an abstract base class for different types of players.
 * <p>
 * Each player has a name and a hand of cards. Subclasses should implement the logic for playing,
 * drawing, and checking if a play is possible, according to the rules of UNO or any custom rules.
 */
public abstract class Player {
     /**
      * The name of the player.
      */
     private String name;

     /**
      * The hand of cards held by the player.
      */
     private Hand hand;

    /**
     * Constructs a Player with the specified name and initializes an empty hand.
     *
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }


    /**
     * Returns the name of the player.
     *
     * @return the player's name
     */
    public String getName() {
        return name;
    }


    /**
     * Returns the hand of cards held by the player.
     *
     * @return the player's hand
     */
    public Hand getHand() {
        return hand;
    }


    /**
     * Plays a card from the player's hand according to the game rules.
     * This method must be implemented by subclasses.
     *
     * @return true if the play is valid, false otherwise
     */
    public abstract boolean playCard();


    /**
     * Draws a card and adds it to the player's hand.
     * This method must be implemented by subclasses.
     *
     * @return true if the draw is successful, false otherwise
     */
    public abstract boolean drawCard();


    /**
     * Checks if the player can make a valid play based on their current hand and the game state.
     * This method must be implemented by subclasses.
     *
     * @return true if the player can play, false otherwise
     */
    public abstract boolean canPlay();
}
