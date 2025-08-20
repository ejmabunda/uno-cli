package tech.mabunda.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import tech.mabunda.card.Card;
import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Type;
import tech.mabunda.player.HumanPlayer;
import tech.mabunda.player.Player;

/**
 * Unit tests for the {@link GameState} class, verifying initialization and core game state behaviors.
 */
public class GameStateTest {
    /**
     * Tests initialization of the GameState, penalty setting, and top discard retrieval.
     */
    @Test
    void testGameStateInitTest() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new HumanPlayer("player 1"));
        players.add(new HumanPlayer("player 2"));
        players.add(new HumanPlayer("player 3"));

        GameState state = new GameState(players);
        assertEquals(3, state.getPlayers().size());
        assertEquals(null, state.getPenalty());

        Card drawTwoCard = Card.create(Type.ACTION, "draw two", Color.YELLOW);
        state.setPenalty(drawTwoCard);
        assertEquals("DRAW_TWO", state.getPenalty());
        assertNotNull(state.topDiscardPile());
    }

    /**
     * Tests turn management, including advancing turns and reversing direction.
     */
    @Test
    void testTurnManagement() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new HumanPlayer("player 1"));
        players.add(new HumanPlayer("player 2"));
        players.add(new HumanPlayer("player 3"));

        GameState state = new GameState(players);
        assertEquals("player 1", state.getCurrentPlayer().getName());

        state.updatePlayer();
        assertEquals("player 2", state.getCurrentPlayer().getName());

        state.updatePlayer();
        assertEquals("player 3", state.getCurrentPlayer().getName());

        state.updatePlayer();
        assertEquals("player 1", state.getCurrentPlayer().getName());

        state.updateDirection();
        state.updatePlayer();
        assertEquals("player 3", state.getCurrentPlayer().getName());

        state.updatePlayer();
        assertEquals("player 2", state.getCurrentPlayer().getName());
    }
}
