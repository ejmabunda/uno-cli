package tech.mabunda.card;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import tech.mabunda.card.enums.Type;
import tech.mabunda.game.GameState;
import tech.mabunda.player.HumanPlayer;
import tech.mabunda.player.Player;

/**
 * Unit tests for the {@link WildCard} class, verifying initialization, comparison, and playability.
 */
class WildCardTest {
    /**
     * Tests initialization of a WildCard.
     */
    @Test
    void testCardInit() {
        Card wildCard = Card.create("wild draw four");
        assertEquals(Type.WILD, wildCard.getType());
        assertEquals("WILD_DRAW_FOUR", wildCard.getValue());
        assertEquals(null, wildCard.getColor());
    }

    /**
     * Tests comparison of two WildCards for equality.
     */
    @Test
    void testCardComparison() {
        Card wildCard = Card.create("wild draw four");
        Card anotherWildCard = Card.create("wild draw four");
        assertEquals(wildCard, anotherWildCard);
    }

    /**
     * Tests that wild cards are always playable.
     */
    @Test
    void testWildCardAlwaysPlayable() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new HumanPlayer("player 0"));
        GameState state = new GameState(players);
        Card wildCard = Card.create("wild");

        state.getCurrentPlayer().getHand().addCard(wildCard);
        assertTrue(wildCard.play(state));

        Card wildDrawFourCard = Card.create("wild draw four");
        state.getCurrentPlayer().getHand().addCard(wildDrawFourCard);
        assertTrue(wildDrawFourCard.play(state));
    }

    @Test
    void testInvalidWildCard() {
        Card invalidWildCard = Card.create("wild juice box");
        assertNull(invalidWildCard);
    }
}
