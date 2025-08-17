package tech.mabunda.card;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Type;

class CardTest {
    @Test
    void testCardInit() {
        Card number1Card = Card.create(Type.NUMBER, "OnE", Color.BLUE);
        assertEquals(Type.NUMBER, number1Card.getType());
        assertEquals("ONE", number1Card.getValue());
        assertEquals(Color.BLUE, number1Card.getColor());

        Card skipCard = Card.create(Type.ACTION, "skip", Color.RED);
        assertEquals(Type.ACTION, skipCard.getType());
        assertEquals("SKIP", skipCard.getValue());
        assertEquals(Color.RED, skipCard.getColor());

        Card wildCard = Card.create(Type.WILD, "WiLd");
        assertEquals(Type.WILD, wildCard.getType());
        assertEquals("WILD", wildCard.getValue());
    }

    @Test
    void testCardComparison() {
        Card number1Card = Card.create(Type.NUMBER, "one", Color.BLUE);
        Card anotherNumber1Card = Card.create(Type.NUMBER, "onE", Color.BLUE);
        assertEquals(number1Card, anotherNumber1Card);
    }
}
