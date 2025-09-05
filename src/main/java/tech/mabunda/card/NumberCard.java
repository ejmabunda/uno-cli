package tech.mabunda.card;

import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Number;
import tech.mabunda.card.enums.Type;

/**
 * Represents a number card in Uno (0-9).
 * <p>
 * Number cards are the most common cards and have no special effects.
 */
public class NumberCard extends Card {
    /**
     * Constructs a NumberCard with the specified number and color.
     *
     * @param value the number value (ZERO-NINE)
     * @param color the color of the card (RED, GREEN, BLUE, YELLOW)
     */
    public NumberCard(Number value, Color color) {
        super(Type.NUMBER, value.toString(), color);
    }
}
