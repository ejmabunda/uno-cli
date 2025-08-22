package tech.mabunda.card;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Type;
import tech.mabunda.game.GameState;
import tech.mabunda.player.HumanPlayer;
import tech.mabunda.player.Player;

class ActionCardTest {
    @Test
    void testCardInit() {
        Card blueReverseCard = Card.create(Type.ACTION, "REVERSE", Color.BLUE);
        assertEquals(Type.ACTION, blueReverseCard.getType());
        assertEquals("REVERSE", blueReverseCard.getValue());
        assertEquals(Color.BLUE, blueReverseCard.getColor());
    }

    @Test
    void testCardComparison() {
        Card blueReverseCard = Card.create(Type.ACTION, "REVERSE", Color.BLUE);
        Card anotherBlueReverseCard = Card.create(Type.ACTION, "reverse", Color.BLUE);
        assertEquals(blueReverseCard, anotherBlueReverseCard);
    }

    @Test
    void testActionCardIsPlayable() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new HumanPlayer("player 0"));
        GameState state = new GameState(players);
        Card topDiscard = state.getDeck().getDiscardPile().get(state.getDeck().getDiscardPile().size() - 1);
        Card blueActionCard = Card.create(Type.ACTION, "skip", topDiscard.getColor());

        assertTrue(blueActionCard.play(state));
    }
}
