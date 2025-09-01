package tech.mabunda.card;

import tech.mabunda.card.enums.Action;
import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Type;

/**
 * Represents an action card in UNO (e.g., Skip, Reverse, Draw Two).
 * <p>
 * Action cards have special effects when played, such as skipping the next player's turn,
 * reversing the direction of play, or forcing the next player to draw cards.
 * Extends the {@link Card} class and provides specific behavior for action cards.
 */
public class ActionCard extends Card {
    /**
     * Constructs an ActionCard with the specified action and color.
     *
     * @param value the action value (SKIP, REVERSE, DRAW_TWO)
     * @param color the color of the card (RED, GREEN, BLUE, YELLOW)
     */
    public ActionCard(Action value, Color color) {
        super(Type.ACTION, value.toString(), color);
    }
}
