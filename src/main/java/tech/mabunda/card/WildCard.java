package tech.mabunda.card;

import tech.mabunda.card.enums.Type;
import tech.mabunda.card.enums.Wild;

/**
 * Represents a wild card in Uno (Wild, Wild Draw Four).
 * <p>
 * Wild cards allow the player to change the current color or force other players to draw cards.
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
}
