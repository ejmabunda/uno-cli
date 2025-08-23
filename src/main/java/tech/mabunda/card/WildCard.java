package tech.mabunda.card;

import tech.mabunda.card.enums.Type;
import tech.mabunda.card.enums.Wild;
import tech.mabunda.game.GameState;

/**
 * Represents a wild card in UNO (Wild, Wild Draw Four).
 * 
 * Extends the {@link Card} class and provides specific behavior for wild cards, which allow the player to change the current color or force other players to draw cards.
 */
public class WildCard extends Card {

    /**
     * Constructs a WildCard with the specified wild value.
     *
     * @param value the wild value (WILD, WILD_DRAW_FOUR)
     */
    public WildCard(Wild value) {
        super(Type.WILD, value.toString(), null);
    }

    /**
     * Plays the wild card. Allows the player to choose a new color and, for Wild Draw Four, forces the next player to draw four cards.
     *
     * @param state the current game state
     * @return true if the play is valid and successful, false otherwise
     */
    @Override
    public boolean play(GameState state) {
        state.setPenalty(value);
        
        return true;
    }
}
