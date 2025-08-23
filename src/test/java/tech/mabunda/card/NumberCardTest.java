package tech.mabunda.card;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Type;
import tech.mabunda.game.GameState;
import tech.mabunda.player.HumanPlayer;
import tech.mabunda.player.Player;

class NumberCardTest {
    @Test
    void testCardInit() {
        Card number1Card = Card.create(Type.NUMBER, "one", Color.BLUE);
        assertEquals(Type.NUMBER, number1Card.getType());
        assertEquals("ONE", number1Card.getValue());
        assertEquals(Color.BLUE, number1Card.getColor());
    }

    @Test
    void testCardComparison() {
        Card number1Card = Card.create(Type.NUMBER, "one", Color.BLUE);
        Card anotherNumber1Card = Card.create(Type.NUMBER, "one", Color.BLUE);
        assertEquals(number1Card, anotherNumber1Card);
    }

    @Test
    void testNumberCardIsPlayable() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new HumanPlayer("player 0"));
        GameState state = new GameState(players);
        Card topDiscard = state.getDeck().getDiscardPile().get(state.getDeck().getDiscardPile().size() - 1);
        Card numberCard = Card.create(Type.NUMBER, "two", topDiscard.getColor());
        
        Card anotherNumberCard;
        if (numberCard.getColor() == Color.BLUE) {
            anotherNumberCard = Card.create(Type.NUMBER, "three", Color.YELLOW);
        } else {
            anotherNumberCard = Card.create(Type.NUMBER, "three", Color.BLUE);
        }

        assertTrue(numberCard.play(state));
        assertFalse(anotherNumberCard.play(state));
    }
}
