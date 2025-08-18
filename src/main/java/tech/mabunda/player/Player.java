package tech.mabunda.player;

/**
 * Represents a player in the UNO game. This is an abstract base class for different types of players.
 * Subclasses should implement the logic for playing, drawing, and checking if a play is possible.
 */
public abstract class Player {
    private String name;

    /**
     * Constructs a Player with the specified name.
     *
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
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
     * Abstract method to be implemented by subclasses for playing a card.
     *
     * @return true if the play is valid, false otherwise
     */
    public abstract boolean playCard();

    /**
     * Abstract method to be implemented by subclasses for drawing a card.
     *
     * @return true if the draw is successful, false otherwise
     */
    public abstract boolean drawCard();

    /**
     * Abstract method to check if the player can make a valid play.
     *
     * @return true if the player can play, false otherwise
     */
    public abstract boolean canPlay();
}
