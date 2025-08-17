package tech.mabunda.card;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import tech.mabunda.card.enums.Type;

class WildCardTest {
    @Test
    void testCardInit() {
        Card wildCard = new WildCard("wild");
        assertEquals(Type.WILD, wildCard.getType());
        assertEquals("wild", wildCard.getValue());
        assertEquals(null, wildCard.getColor());
    }

    @Test
    void testCardComparison() {
        Card wildCard = new WildCard("wild draw four");
        Card anotherWildCard = new WildCard("wild draw four");
        assertEquals(wildCard, anotherWildCard);
    }
}
