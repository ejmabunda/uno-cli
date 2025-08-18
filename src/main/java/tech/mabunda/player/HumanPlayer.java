
package tech.mabunda.player;

/**
 * Represents a human player in the UNO game.
 * This class extends {@link Player} and is intended to implement the logic for a human-controlled player.
 */
public class HumanPlayer extends Player {
    /**
     * Constructs a HumanPlayer with the specified name.
     *
     * @param name the name of the player
     */
    public HumanPlayer(String name) {
        super(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean playCard() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'playCard'");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean drawCard() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drawCard'");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canPlay() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'canPlay'");
    }
}
