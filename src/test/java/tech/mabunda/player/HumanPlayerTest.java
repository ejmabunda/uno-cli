package tech.mabunda.player;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import tech.mabunda.card.Card;
import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Type;
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

        assertEquals(canPlay, !player1.getValidMoves(deck).isEmpty());
    }

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
