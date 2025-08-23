package tech.mabunda.card;

import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Number;
import tech.mabunda.card.enums.Type;
import tech.mabunda.game.GameState;

/**
 * Represents a number card in UNO (0-9).
 * 
 * Extends the {@link Card} class and provides specific behavior for number cards, which are the most common cards in the game.
 */
public class NumberCard extends Card {
    /**
     * Constructs a NumberCard with the specified number and color.
     *
     * @param value the number value (ZERO-NINE)
     * @param color the color of the card
     */
    public NumberCard(Number value, Color color) {
        super(Type.NUMBER, value.toString(), color);
    }

    /**
     * Plays the number card. Checks if the card can be played (matches color or value) and updates the game state if valid.
     *
     * @param state the current game state
     * @return true if the play is valid and successful, false otherwise
     */
    @Override
    public boolean play(GameState state) {
        if (!state.topDiscardPile().match(this)) {
            return false;
        }

        return true;
    }
}
