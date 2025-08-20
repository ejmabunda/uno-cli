package tech.mabunda.game;

import java.util.ArrayList;

import tech.mabunda.card.Card;
import tech.mabunda.card.enums.Color;
import tech.mabunda.deck.Deck;
import tech.mabunda.player.Player;

/**
 * Manages the state of an UNO game, including players, deck, turn order, color, and penalties.
 */
public class GameState {
    private ArrayList<Player> players;
    private Deck deck;
    private int currentPlayerIndex;
    private int direction;
    private Color color;
    private String penalty;


    /**
     * Initializes the game state with the given players, creates a deck, and deals cards.
     * Sets the starting player and direction.
     *
     * @param players the list of players participating in the game
     */
    public GameState(ArrayList<Player> players) {
        this.players = players;
        this.deck = new Deck();
        this.deck.deal(this.players);
        this.currentPlayerIndex = 0;
        this.direction = 1;
        this.color = topDiscardPile().getColor();
    }


    /**
     * Returns the top card of the draw pile.
     *
     * @return the top card of the draw pile
     */
    public Card topDrawPile() {
        return deck.getDrawPile().get(deck.getDrawPile().size() - 1);
    }


    /**
     * Returns the top card of the discard pile.
     *
     * @return the top card of the discard pile
     */
    public Card topDiscardPile() {
        return deck.getDiscardPile().get(deck.getDiscardPile().size() - 1);
    }


    /**
     * Gets the current penalty value, if any.
     *
     * @return the penalty value or null if no penalty is active
     */
    public String getPenalty() {
        return penalty;
    }


    /**
     * Returns the list of players in the game.
     *
     * @return the list of players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }


    /**
     * Sets a penalty based on the given card's value.
     *
     * @param card the card causing the penalty
     */
    public void setPenalty(Card card) {
        penalty = card.getValue();
    }


    /**
     * Removes any active penalty from the game state.
     */
    public void removePenalty() {
        penalty = null;
    }


    /**
     * Sets the current color in play.
     *
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }


    /**
     * Advances the turn to the next player, considering the current direction.
     * Wraps around if the index goes out of bounds.
     */
    public void updatePlayer() {
        currentPlayerIndex += direction;
        if (currentPlayerIndex >= players.size()) {
            currentPlayerIndex = 0;
        } else if (currentPlayerIndex < 0) {
            currentPlayerIndex = players.size() - 1;
        }
    }
}
