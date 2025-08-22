
package tech.mabunda.player;

import tech.mabunda.deck.Deck;

/**
 * Represents a human-controlled player in the UNO game.
 * <p>
 * This class extends {@link Player} and is intended to implement the logic for a player whose actions are determined by user input,
 * such as via a command-line interface (CLI) or graphical user interface (GUI).
 * <p>
 * Methods in this class should be implemented to interact with the user for making moves, drawing cards, and other game actions.
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
     * Prompts the human player to select and play a card from their hand.
     * <p>
     * This method should be implemented to interact with the user and allow them to choose a card to play according to the game rules. Typically, this will call the selected card's {@code play(GameState)} method.
     *
     * @return true if the play is valid and successful, false otherwise
     */
    @Override
    public boolean playCard() {
        return false;
    }

    /**
     * Draws a card from the deck and adds it to the human player's hand.
     * <p>
     * This method should be implemented to notify the user that a card has been drawn and update the hand accordingly.
     *
     * @param deck the deck to draw from
     * @return true if the draw is successful, false otherwise
     */
    @Override
    public boolean drawCard(Deck deck) {
        hand.addCard(deck.drawCard());
        return true;
    }
}
