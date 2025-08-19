package tech.mabunda.deck;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import tech.mabunda.card.Card;
import tech.mabunda.card.enums.Type;
import tech.mabunda.player.HumanPlayer;
import tech.mabunda.player.Player;

/**
 * Unit tests for the Deck class, verifying deck initialization and dealing logic.
 */
public class DeckTest {
    /**
     * Test that a new deck contains the correct number and type of cards.
     */
    @Test
    void testDeckInit() {
        Deck deck = new Deck();
        
        int numberCards = 0;
        int actionCards = 0;
        int wildCards = 0;
        
        // Count each type of card in the draw pile
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

    /**
     * Test that dealing cards to players works and the discard pile is initialized correctly.
     */
    @Test
    void test_deck_deal() {
        ArrayList<Player> players = new ArrayList<>();
        int numPlayers = 5;

        // Create 5 players
        for (int a = 0; a < numPlayers; a++) {
            players.add(new HumanPlayer("player_" + a));
        }

        Deck deck = new Deck();
        deck.deal(players);

        // Each player should have 7 cards
        for (Player player: players) {
            assertEquals(7, player.getHand().size());
        }

        ArrayList<Card> discard_pile = deck.getDiscardPile();

        // Discard pile should have 1 card, and it should be a number card
        assertEquals(1, discard_pile.size());
        assertEquals(Type.NUMBER, discard_pile.get(discard_pile.size() - 1).getType());
    }
}
