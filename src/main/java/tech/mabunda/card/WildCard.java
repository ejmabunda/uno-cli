package tech.mabunda.card;

import tech.mabunda.card.enums.Type;
import tech.mabunda.card.enums.Wild;

/**
 * Represents a wild card in UNO (Wild, Wild Draw Four).
 * <p>
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
     * Plays the wild card. Must be implemented to define the effect of playing a wild card.
     *
     * @return true if the play is valid and successful, false otherwise
     * @throws UnsupportedOperationException if not implemented
     */
    @Override
    public boolean play() {
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }
}
