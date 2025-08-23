package tech.mabunda.card;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import tech.mabunda.card.enums.Type;
import tech.mabunda.game.GameState;
import tech.mabunda.player.HumanPlayer;
import tech.mabunda.player.Player;

class WildCardTest {
    @Test
    void testCardInit() {
        Card wildCard = Card.create(Type.WILD, "wild draw four");
        assertEquals(Type.WILD, wildCard.getType());
        assertEquals("WILD_DRAW_FOUR", wildCard.getValue());
        assertEquals(null, wildCard.getColor());
    }

    @Test
    void testCardComparison() {
        Card wildCard = Card.create(Type.WILD, "wild draw four");
        Card anotherWildCard = Card.create(Type.WILD, "wild draw four");
        assertEquals(wildCard, anotherWildCard);
    }

    @Test
    void testWildCardAlwaysPlayable() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new HumanPlayer("player 0"));
        GameState state = new GameState(players);
        Card wildCard = Card.create(Type.WILD, "wild");
        assertTrue(wildCard.play(state));
        Card wildDrawFourCard = Card.create(Type.WILD, "wild draw four");
        assertTrue(wildDrawFourCard.play(state));
    }
}
