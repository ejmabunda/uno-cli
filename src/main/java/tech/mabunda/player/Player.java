package tech.mabunda.player;

import java.util.ArrayList;

import tech.mabunda.card.Card;
import tech.mabunda.deck.Deck;

/**
 * Abstract base class representing a player in the Uno game.
 * <p>
 * Each player has a name and a hand of cards. Subclasses implement logic for playing and drawing cards.
 * Provides common functionality for all player types, including access to the player's name and hand.
 */
public abstract class Player {
    /**
     * The name of the player.
     */
    private String name;

    /**
     * The hand of cards held by the player.
     */
    protected Hand hand;

    /**
     * Constructs a Player with the specified name and initializes an empty hand.
     *
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    /**
     * Returns the name of the player.
     *
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the hand of cards held by the player.
     *
     * @return the player's hand
     */
    public Hand getHand() {
        return hand;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Name: " + name + "\nHand:\n");
        for (Card card: hand.getCards()) {
            result.append("\t- " + card.toString() + "\n");
        }

        return result.toString();
    }

    public boolean hasCard(Card card) {
        return hand.getCards().contains(card);
    }

    // For testing
    public void addCard(Card card) {
        hand.addCard(card);
    }

    /**
     * Draws a card and adds it to the player's hand.
     * <p>
     * This method must be implemented by subclasses to define how a player draws a card from the deck.
     *
     * @param deck the deck to draw from
     * @return true if the draw is successful, false otherwise
     */
    public abstract boolean drawCard(Deck deck);

    /**
     * Checks if the player can make a valid play based on their current hand and the top card of the discard pile.
     * 
     * By default, this method checks if any card in the player's hand matches the top card of the discard pile.
     * Subclasses may override this method to implement custom playability logic.
     *
     * @param deck the current deck (to access the discard pile)
     * @return a list of valid moves
     */
    public ArrayList<Card> getValidMoves(Deck deck) {
        Card topDiscardPileCard = deck.getDiscardPile().get(deck.getDiscardPile().size() - 1);
        ArrayList<Card> validMoves = new ArrayList<>();
        
        for (Card card: hand.getCards()) {
            if (card.match(topDiscardPileCard)) {
                validMoves.add(card);
            }
        }
        return validMoves;
    }
}
