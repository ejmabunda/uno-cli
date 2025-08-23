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

class ActionCardTest {
    @Test
    void testCardInit() {
        Card blueReverseCard = Card.create("blue reverse");
        assertEquals(Type.ACTION, blueReverseCard.getType());
        assertEquals("REVERSE", blueReverseCard.getValue());
        assertEquals(Color.BLUE, blueReverseCard.getColor());
    }

    @Test
    void testCardComparison() {
        Card blueReverseCard = Card.create("blue reverse");
        Card anotherBlueReverseCard = Card.create("blue reverse");
        assertEquals(blueReverseCard, anotherBlueReverseCard);
    }

    @Test
    void testActionCardIsPlayable() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new HumanPlayer("player 0"));
        GameState state = new GameState(players);
        Card topDiscard = state.getDeck().getDiscardPile().get(state.getDeck().getDiscardPile().size() - 1);
        Card actionCard = Card.create(topDiscard.getColor() + " skip");
        
        Card anotherActionCard;
        if (actionCard.getColor().equals(Color.BLUE)) {
            anotherActionCard = Card.create("yellow reverse");
        } else {
            anotherActionCard = Card.create("blue reverse");
        }
        
        state.getCurrentPlayer().getHand().addCard(actionCard);
        state.getCurrentPlayer().getHand().addCard(anotherActionCard);
        assertTrue(actionCard.play(state));
        assertFalse(anotherActionCard.play(state));
    }
}
