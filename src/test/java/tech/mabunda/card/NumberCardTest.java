package tech.mabunda.card;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Type;

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
}
