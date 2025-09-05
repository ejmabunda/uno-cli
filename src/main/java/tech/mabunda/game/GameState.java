package tech.mabunda.game;

import java.util.ArrayList;

import tech.mabunda.card.Card;
import tech.mabunda.card.enums.Color;
import tech.mabunda.deck.Deck;
import tech.mabunda.player.Player;

/**
 * Manages the state of a Uno game, including players, deck, turn order, color, and penalties.
 * <p>
 * Provides methods to access and update the current state, such as the current player, direction, color, and penalties.
 * Handles turn progression, penalty application, and color management.
 */
public class GameState {
    /**
     * The list of players in the game.
     */
    private ArrayList<Player> players;

    /**
     * The deck of UNO cards used in the game.
     */
    private Deck deck;
    /**
     * The index of the current player in the players list.
     */
    private int currentPlayerIndex;
    /**
     * The direction of play (1 for clockwise, -1 for counterclockwise).
     */
    private int direction;
    /**
     * The current color in play.
     */
    private Color color;
    /**
     * The current penalty value, if any.
     */
    private String penalty;

    /**
     * Initializes the game state with the given players, creates a deck, and deals
     * cards.
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
        this.penalty = "";
    }

    public Deck getDeck() {
        return deck;
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
     * Returns the player whose turn it currently is.
     *
     * @return the current player
     */
    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public boolean isWinner() {
        return getCurrentPlayer().getHand().size() == 0;
    }

    /**
     * Sets a penalty based on the given card's value.
     *
     * @param card the card causing the penalty
     */
    public void setPenalty(String penalty) {
        this.penalty = penalty;
    }

    public boolean handlePenalty() {
        if (!penalty.isEmpty()) {
            int cardsToDraw = 0;
            if (penalty.equals("DRAW_TWO")) {
                cardsToDraw = 2;
            } else if (penalty.equals("WILD_DRAW_FOUR")) {
                cardsToDraw = 4;
            }

            for (int i = 0; i < cardsToDraw; i++) {
                getCurrentPlayer().getHand().addCard(getDeck().drawCard());
            }
            System.out.println(">>> " + getCurrentPlayer().getName() + " drew " + cardsToDraw + " card(s).");

            penalty = "";
            return true;
        }
        
        return false;
    }

    /**
     * Sets the current color in play.
     *
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    public void removeColor() {
        color = null;
    }

    public Color getColor() {
        return color;
    }

    /**
     * Reverses the direction of play (e.g., for a reverse card).
     */
    public void updateDirection() {
        this.direction *= -1;
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
