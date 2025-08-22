package tech.mabunda.game;

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
        
    }
}
