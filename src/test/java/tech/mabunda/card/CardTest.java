package tech.mabunda.card;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Type;

class CardTest {
    @Test
    void testCardInit() {
        Card number1Card = Card.create(Type.NUMBER, "1", Color.BLUE);
        assertEquals(Type.NUMBER, number1Card.getType());
        assertEquals("1", number1Card.getValue());
        assertEquals(Color.BLUE, number1Card.getColor());

        Card skipCard = Card.create(Type.ACTION, "skip", Color.RED);
        assertEquals(Type.ACTION, skipCard.getType());
        assertEquals("skip", skipCard.getValue());
        assertEquals(Color.RED, skipCard.getColor());

        Card wildCard = Card.create(Type.WILD, "wild");
        assertEquals(Type.WILD, wildCard.getType());
        assertEquals("wild", wildCard.getValue());
    }

    @Test
    void testCardComparison() {
        Card number1Card = Card.create(Type.NUMBER, "1", Color.BLUE);
        Card anotherNumber1Card = Card.create(Type.NUMBER, "1", Color.BLUE);
        assertEquals(number1Card, anotherNumber1Card);
    }
}
