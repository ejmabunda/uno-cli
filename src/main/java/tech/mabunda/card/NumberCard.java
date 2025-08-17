package tech.mabunda.card;

import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Number;
import tech.mabunda.card.enums.Type;

/**
 * Represents a number card in UNO (0-9).
 */
public class NumberCard extends Card {
    /**
     * Constructs a NumberCard with the specified number and color.
     *
     * @param value the number value
     * @param color the color of the card
     */
    public NumberCard(Number value, Color color) {
        super(Type.NUMBER, value.toString(), color);
    }

    @Override
    /**
     * Plays the number card. To be implemented.
     *
     * @return true if the play is valid, false otherwise
     */
    public boolean play() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }

}
