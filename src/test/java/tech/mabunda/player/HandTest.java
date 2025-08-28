package tech.mabunda.player;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import tech.mabunda.card.Card;

/**
 * Unit tests for the {@link Hand} class, verifying hand initialization, adding, and removing cards.
 */
public class HandTest {
    /**
     * Tests hand initialization, adding a card, and removing a card.
     */
    @Test
    void testHandInit() {
        Player human = new HumanPlayer("bob");
        assertEquals(0, human.getHand().size());

        Card redReverse = Card.create("red reverse");
        
        human.getHand().addCard(redReverse);
        assertEquals(1, human.getHand().size());

        human.getHand().removeCard(redReverse);
        assertEquals(0, human.getHand().size());
    }
}
