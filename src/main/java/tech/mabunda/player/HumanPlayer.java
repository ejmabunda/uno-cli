
package tech.mabunda.player;

import tech.mabunda.deck.Deck;

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
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean drawCard(Deck deck) {
        hand.add_card(deck.draw_card());

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canPlay() {
        return false;
    }
}
