package tech.mabunda.card;

import tech.mabunda.card.enums.Action;
import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Type;

/**
 * Represents an action card in UNO (e.g., Skip, Reverse, Draw Two).
 * <p>
 * Extends the {@link Card} class and provides specific behavior for action cards, which have special effects when played.
 */
public class ActionCard extends Card {
    /**
     * Constructs an ActionCard with the specified action and color.
     *
     * @param value the action value (SKIP, REVERSE, DRAW_TWO)
     * @param color the color of the card
     */
    public ActionCard(Action value, Color color) {
        super(Type.ACTION, value.toString(), color);
    }

    /**
     * Plays the action card. Must be implemented to define the effect of playing an action card.
     *
     * @return true if the play is valid and successful, false otherwise
     * @throws UnsupportedOperationException if not implemented
     */
    @Override
    public boolean play() {
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }
}
