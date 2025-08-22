package tech.mabunda.card;

import tech.mabunda.card.enums.Action;
import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Type;
import tech.mabunda.game.GameState;
import tech.mabunda.player.Player;

/**
 * Represents an action card in UNO (e.g., Skip, Reverse, Draw Two).
 * 
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
     * Plays the action card. Checks if the card can be played (matches color or value) and applies the action effect (Skip, Reverse, Draw Two).
     *
     * @param state the current game state
     * @return true if the play is valid and successful, false otherwise
     */
    @Override
    public boolean play(GameState state) {
        if (!state.topDiscardPile().match(this)) {
            return false;
        }

        state.setColor(color);
        state.setPenalty(value);
        // Implementation should apply the action effect to the game state
        return true;
    }
}
