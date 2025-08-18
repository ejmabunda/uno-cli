package tech.mabunda.player;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HumanPlayerTest {
    @Test
    void testHumanPlayerInit() {
        Player human = new HumanPlayer("osito");
        assertEquals("osito", human.getName());
    }
}
