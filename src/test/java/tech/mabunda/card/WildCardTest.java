package tech.mabunda.card;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import tech.mabunda.card.enums.Type;

class WildCardTest {
    @Test
    void testCardInit() {
        Card wildCard = Card.create(Type.WILD, "wild draw four");
        assertEquals(Type.WILD, wildCard.getType());
        assertEquals("WILD_DRAW_FOUR", wildCard.getValue());
        assertEquals(null, wildCard.getColor());
    }

    @Test
    void testCardComparison() {
        Card wildCard = Card.create(Type.WILD, "wild draw four");
        Card anotherWildCard = Card.create(Type.WILD, "wild draw four");
        assertEquals(wildCard, anotherWildCard);
    }
}
