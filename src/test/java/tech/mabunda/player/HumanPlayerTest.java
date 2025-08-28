package tech.mabunda.player;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import tech.mabunda.card.Card;
import tech.mabunda.deck.Deck;

/**
 * Unit tests for the {@link HumanPlayer} class, verifying initialization, playability, and string representation.
 */
public class HumanPlayerTest {
    /**
     * Tests that a HumanPlayer is initialized with the correct name.
     */
    @Test
    void testHumanPlayerInit() {
        Player human = new HumanPlayer("osito");
        assertEquals("osito", human.getName());
    }

    /**
     * Tests that a HumanPlayer can play a valid card from their hand.
     */
    @Test
    void testHumanPlayerCanPlay() {
        Deck deck = new Deck();
        ArrayList<Player> players = new ArrayList<>();
        
        Player player1 = new HumanPlayer("Player 1");
        players.add(player1);
        deck.deal(players);

        Card topDiscardPileCard = deck.getDiscardPile().get(deck.getDiscardPile().size() - 1);

        boolean canPlay = false;
        for (Card card: player1.hand.getCards()) {
            if (card.match(topDiscardPileCard)) { canPlay = true; break; }
        }

        assertEquals(canPlay, !player1.getValidMoves(deck).isEmpty());
    }

    /**
     * Tests the string representation of a HumanPlayer's hand.
     */
    @Test
    void testStringRepresentationOfHumanPlayer() {
        Player player = new HumanPlayer("player 0");
        player.addCard(Card.create("wild draw four"));
        player.addCard(Card.create("yellow four"));

        String expected = 
            "Name: player 0\n" + 
            "Hand:\n" +
            "\t- wild draw four\n" +
            "\t- yellow four\n"
        ;

        assertEquals(expected, player.toString());
    }
}
