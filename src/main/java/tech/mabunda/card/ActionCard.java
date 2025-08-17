package tech.mabunda.card;

import tech.mabunda.card.enums.Action;
import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Type;

/**
 * Represents an action card in UNO (e.g., Skip, Reverse, Draw Two).
 */
public class ActionCard extends Card {
    /**
     * Constructs an ActionCard with the specified action and color.
     *
     * @param value the action value
     * @param color the color of the card
     */
    public ActionCard(Action value, Color color) {
        super(Type.ACTION, value.toString(), color);
    }

    @Override
    /**
     * Plays the action card. To be implemented.
     *
     * @return true if the play is valid, false otherwise
     */
    public boolean play() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }
}
