package tech.mabunda.game;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.mabunda.card.Card;
import tech.mabunda.card.WildCard;
import tech.mabunda.card.enums.Color;
import tech.mabunda.player.HumanPlayer;
import tech.mabunda.player.Player;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link GameState} class, verifying initialization and core game state behaviors.
 */
public class GameStateTest {
    ArrayList<Player> players;
    GameState state;

    @BeforeEach
    void setUp() {
        players = new ArrayList<>();
        players.add(new HumanPlayer("player 1"));
        players.add(new HumanPlayer("player 2"));
        players.add(new HumanPlayer("player 3"));

        state = new GameState(players);
    }
    /**
     * Tests initialization of the GameState, penalty setting, and top discard retrieval.
     */
    @Test
    void testGameStateInitTest() {
        assertEquals(3, state.getPlayers().size());
        assertEquals("", state.getPenalty());

        Card drawTwoCard = Card.create("yellow draw two");
        state.setPenalty(drawTwoCard.getValue());
        assertEquals("DRAW_TWO", state.getPenalty());
        assertNotNull(state.topDiscardPile());
    }

    /**
     * Tests turn management, including advancing turns and reversing direction.
     */
    @Test
    void testTurnManagement() {
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

    @Test
    void testSetColor() {
        state.setColor(Color.RED);
        assertEquals(Color.RED, state.getColor());

        state.setColor(Color.GREEN);
        assertEquals(Color.GREEN, state.getColor());

        state.setColor(Color.YELLOW);
        assertEquals(Color.YELLOW, state.getColor());

        state.setColor(Color.BLUE);
        assertEquals(Color.BLUE, state.getColor());
    }
}
