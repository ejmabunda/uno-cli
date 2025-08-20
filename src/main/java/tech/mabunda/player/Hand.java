
package tech.mabunda.player;

import java.util.ArrayList;
import tech.mabunda.card.Card;

/**
 * Represents a hand of cards held by a player in the UNO game.
 * <p>
 * This class is a simple wrapper around a list of {@link tech.mabunda.card.Card} objects, providing methods to add, remove,
 * and check the number of cards in the hand.
 */
public class Hand {
    /**
     * The list of cards in the player's hand.
     */
    private ArrayList<Card> cards;

    /**
     * Constructs an empty hand.
     */
    public Hand() {
        this.cards = new ArrayList<>();
    }

    /**
     * Returns the list of cards currently in the hand.
     *
     * @return the list of cards in the hand
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Adds a card to the hand.
     *
     * @param card the card to add
     */
    public void add_card(Card card) {
        cards.add(card);
    }

    /**
     * Removes a card from the hand if it exists.
     *
     * @param card the card to remove
     * @return true if the card was removed, false if the card was not found
     */
    public boolean remove_card(Card card) {
        return cards.remove(card);
    }

    /**
     * Returns the number of cards in the hand.
     *
     * @return the size of the hand
     */
    public int size() {
        return cards.size();
    }
}
