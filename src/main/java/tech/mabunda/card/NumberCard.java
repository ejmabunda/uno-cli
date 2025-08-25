package tech.mabunda.card;

import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Number;
import tech.mabunda.card.enums.Type;

/**
 * Represents a number card in UNO (0-9).
 * <p>
 * Number cards are the most common cards in UNO and have no special effects.
 * Extends the {@link Card} class and provides specific behavior for number cards.
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
