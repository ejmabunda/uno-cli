package tech.mabunda.deck;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import tech.mabunda.card.Card;
import tech.mabunda.card.enums.Type;

public class DeckTest {
    @Test
    void testDeckInit() {
        Deck deck = new Deck();
        
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
        
        assertEquals(76, numberCards, "A standard UNO deck has 76 number cards.");
        assertEquals(24, actionCards, "A standard UNO deck has 24 action cards.");
        assertEquals(8, wildCards, "A standard UNO deck has 8 wild cards.");
        
        assertEquals(108, deck.getDrawPile().size(), "A standard UNO deck has 108 cards.");
    }
}
