package tech.mabunda.card;

import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Number;
import tech.mabunda.card.enums.Type;

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
     * Plays the number card. Must be implemented to define the effect of playing a number card.
     *
     * @return true if the play is valid and successful, false otherwise
     * @throws UnsupportedOperationException if not implemented
     */
    @Override
    public boolean play() {
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }
}
