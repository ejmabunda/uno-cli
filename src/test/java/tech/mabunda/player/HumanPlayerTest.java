package tech.mabunda.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import tech.mabunda.card.Card;
import tech.mabunda.deck.Deck;

public class HumanPlayerTest {
    @Test
    void testHumanPlayerInit() {
        Player human = new HumanPlayer("osito");
        assertEquals("osito", human.getName());
    }

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

        assertEquals(canPlay, player1.getValidMoves(deck).size() >= 1);
    }
}
