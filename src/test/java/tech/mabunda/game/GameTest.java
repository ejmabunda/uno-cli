package tech.mabunda.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    void testInit() {
        Game game = new Game();
        assertNotNull(game);
    }

    @Test
    void testGetPlayers() {
        Game game = new Game();
        assertEquals(2, game.getPlayers().size());
        
        game = new Game(5);
        assertEquals(5, game.getPlayers().size());
        
        game = new Game(0);
        assertEquals(2, game.getPlayers().size());
        
        game = new Game(12);
        assertEquals(10, game.getPlayers().size());
        
        game = new Game(10);
        assertEquals(10, game.getPlayers().size());
    }
    
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
}
