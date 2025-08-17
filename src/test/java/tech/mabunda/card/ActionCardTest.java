package tech.mabunda.card;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Type;

class ActionCardTest {
    @Test
    void testCardInit() {
        Card number1Card = new ActionCard("reverse", Color.BLUE);
        assertEquals(Type.ACTION, number1Card.getType());
        assertEquals("reverse", number1Card.getValue());
        assertEquals(Color.BLUE, number1Card.getColor());
    }

    @Test
    void testCardComparison() {
        Card number1Card = new ActionCard("reverse", Color.BLUE);
        Card anotherNumber1Card = new ActionCard("reverse", Color.BLUE);
        assertEquals(number1Card, anotherNumber1Card);
    }
}
