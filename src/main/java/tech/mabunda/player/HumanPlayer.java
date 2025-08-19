
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
     * Plays a card from the human player's hand. (To be implemented)
     *
     * @return true if the play is valid, false otherwise
     */
    @Override
    public boolean playCard() {
        return false;
    }

    /**
     * Draws a card from the deck and adds it to the human player's hand.
     *
     * @param deck the deck to draw from
     * @return true if the draw is successful, false otherwise
     */
    @Override
    public boolean drawCard(Deck deck) {
        hand.add_card(deck.draw_card());
        return true;
    }

    /**
     * Checks if the human player can make a valid play. (To be implemented)
     *
     * @return true if the player can play, false otherwise
     */
    @Override
    public boolean canPlay() {
        return false;
    }
}
