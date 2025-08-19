package tech.mabunda.player;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import tech.mabunda.card.Card;
import tech.mabunda.card.enums.Type;
import tech.mabunda.card.enums.Color;

public class HandTest {
    @Test
    void testHandInit() {
        Player human = new HumanPlayer("bob");
        assertEquals(0, human.getHand().size());

        Card redReverse = Card.create(Type.ACTION, "reverse", Color.RED);
        
        human.getHand().add_card(redReverse);
        assertEquals(1, human.getHand().size());

        human.getHand().remove_card(redReverse);
        assertEquals(0, human.getHand().size());
    }
}
