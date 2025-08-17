package tech.mabunda.card;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Type;

class ActionCardTest {
    @Test
    void testCardInit() {
        Card blueReverseCard = Card.create(Type.ACTION, "REVERSE", Color.BLUE);
        assertEquals(Type.ACTION, blueReverseCard.getType());
        assertEquals("REVERSE", blueReverseCard.getValue());
        assertEquals(Color.BLUE, blueReverseCard.getColor());
    }

    @Test
    void testCardComparison() {
        Card blueReverseCard = Card.create(Type.ACTION, "REVERSE", Color.BLUE);
        Card anotherBlueReverseCard = Card.create(Type.ACTION, "reverse", Color.BLUE);
        assertEquals(blueReverseCard, anotherBlueReverseCard);
    }
}
