package tech.mabunda.card;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Type;

/**
 * Unit tests for the {@link Card} class, verifying initialization, comparison, matching, and string representation.
 */
class CardTest {
    /**
     * Tests initialization of various Card types.
     */
    @Test
    void testCardInit() {
        Card number1Card = Card.create("blUe OnE");
        assertEquals(Type.NUMBER, number1Card.getType());
        assertEquals("ONE", number1Card.getValue());
        assertEquals(Color.BLUE, number1Card.getColor());

        Card skipCard = Card.create("rEd skiP");
        assertEquals(Type.ACTION, skipCard.getType());
        assertEquals("SKIP", skipCard.getValue());
        assertEquals(Color.RED, skipCard.getColor());

        Card wildCard = Card.create("WiLd");
        assertEquals(Type.WILD, wildCard.getType());
        assertEquals("WILD", wildCard.getValue());

        Card anotherWildCard = Card.create("WiLd");
        assertTrue(wildCard.equals(anotherWildCard));
    }

    /**
     * Tests comparison of two Cards for equality.
     */
    @Test
    void testCardComparison() {
        Card number1Card = Card.create("blue ONE");
        Card anotherNumber1Card = Card.create("BlUe oNe");
        assertEquals(number1Card, anotherNumber1Card);
    }

    /**
     * Tests the match logic for various Card types.
     */
    @Test
    void testValidMoves() {
        Card number1Card = Card.create("yellow one");
        Card number2Card = Card.create("red two");
        assertFalse(number1Card.match(number2Card));

        Card wildCard = Card.create("wild");
        assertTrue(number1Card.match(wildCard));

        Card yellowNumber1Card = Card.create("yellow one");
        assertTrue(number1Card.match(yellowNumber1Card));

        Card redReverseCard = Card.create("reD RevErsE");
        assertTrue(number2Card.match(redReverseCard));
    }

    /**
     * Tests the string representation of Card objects.
     */
    @Test
    void testCardToString() {
        Card card = Card.create("green three");
        assertEquals("green three", card.toString());
        
        card = Card.create("red draw two");
        assertEquals("red draw two", card.toString());
        
        card = Card.create("wild");
        assertEquals("wild", card.toString());
    }
}