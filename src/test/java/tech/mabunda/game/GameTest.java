package tech.mabunda.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link Game} class, verifying initialization, player creation, and state setup.
 */
public class GameTest {
    /**
     * Tests that a Game object is initialized correctly.
     */
    @Test
    void testInit() {
        Game game = new Game();
        assertNotNull(game);
    }

    /**
     * Tests that the correct number of players are created for various input values.
     */
    @Test
    void testGetPlayers() {
        Game game = new Game();
        assertEquals(2, game.createPlayers().size());
        
        game = new Game(5);
        assertEquals(5, game.createPlayers().size());
        
        game = new Game(0);
        assertEquals(2, game.createPlayers().size());
        
        game = new Game(12);
        assertEquals(10, game.createPlayers().size());
        
        game = new Game(10);
        assertEquals(10, game.createPlayers().size());
    }
    
    /**
     * Tests that the GameState is initialized with the correct number of players.
     */
    @Test
    void testStateCorrectlyInitialized() {
        Game game = new Game();
        assertEquals(2, game.getState().getPlayers().size());

        game = new Game(3);
        assertEquals(3, game.getState().getPlayers().size());

        game = new Game(7);
        assertEquals(7, game.getState().getPlayers().size());

        game = new Game(10);
        assertEquals(10, game.getState().getPlayers().size());
    }

    @Test
    void testGetPrompt() {
        Game game = new Game();
        String prompt = game.getPrompt();
        assertTrue(prompt.contains("It's player 0's turn!"));
        assertTrue(prompt.contains("The top card is"));
        assertTrue(prompt.contains("Your hand:\n\t-> "));
        assertTrue(prompt.contains("What's your move? "));
    }
}
