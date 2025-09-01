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

/**
 * Unit tests for the {@link NumberCard} class, verifying initialization, comparison, and playability.
 */
class NumberCardTest {
    /**
     * Tests initialization of a NumberCard.
     */
    @Test
    void testCardInit() {
        Card number1Card = Card.create("blue one");
        assertEquals(Type.NUMBER, number1Card.getType());
        assertEquals("ONE", number1Card.getValue());
        assertEquals(Color.BLUE, number1Card.getColor());
    }

    /**
     * Tests comparison of two NumberCards for equality.
     */
    @Test
    void testCardComparison() {
        Card number1Card = Card.create("blue one");
        Card anotherNumber1Card = Card.create("blue one");
        assertEquals(number1Card, anotherNumber1Card);
    }

    /**
     * Tests that a NumberCard is playable if it matches the top discard card.
     */
    @Test
    void testNumberCardIsPlayable() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new HumanPlayer("player 0"));
        GameState state = new GameState(players);
        Card topDiscard = state.getDeck().getDiscardPile().get(state.getDeck().getDiscardPile().size() - 1);
        Card numberCard = Card.create(topDiscard.getColor() + " seven");

        state.getCurrentPlayer().getHand().addCard(numberCard);
        assertTrue(numberCard.play(state));
    }
}
