package tech.mabunda.card;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Type;

class NumberCardTest {
    @Test
    void testCardInit() {
        Card number1Card = new NumberCard("1", Color.BLUE);
        assertEquals(Type.NUMBER, number1Card.getType());
        assertEquals("1", number1Card.getValue());
        assertEquals(Color.BLUE, number1Card.getColor());
    }

    @Test
    void testCardComparison() {
        Card number1Card = new NumberCard("1", Color.BLUE);
        Card anotherNumber1Card = new NumberCard("1", Color.BLUE);
        assertEquals(number1Card, anotherNumber1Card);
    }
}
