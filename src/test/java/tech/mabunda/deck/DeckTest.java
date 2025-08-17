package tech.mabunda.deck;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import tech.mabunda.card.Card;
import tech.mabunda.card.enums.Type;

public class DeckTest {
    @Test
    void testDeckInit() {
        Deck deck = new Deck();
        assertEquals(108, deck.getDrawPile().size());

        int numberCards = 0;
        int actionCards = 0;
        int wildCards = 0;

        for (Card card: deck.getDrawPile()) {
            if (card.getType() == Type.NUMBER) {
                numberCards += 1;
            } else if (card.getType() == Type.ACTION) {
                actionCards += 1;
            } else if (card.getType() == Type.WILD) {
                wildCards += 1;
            }
        }

        assertEquals(76, numberCards);
        assertEquals(24, actionCards);
        assertEquals(8, wildCards);
    }
}
