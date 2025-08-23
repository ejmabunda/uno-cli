package tech.mabunda.card;

import java.util.Arrays;
import java.util.List;

import tech.mabunda.card.enums.Action;
import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Number;
import tech.mabunda.card.enums.Type;
import tech.mabunda.card.enums.Wild;
import tech.mabunda.game.GameState;

/**
 * Abstract base class for all UNO cards.
 * <p>
 * Provides common properties and methods for UNO cards, including type, value, and color.
 * Subclasses must implement the {@link #play(GameState)} method to define card-specific play behavior.
 */
public abstract class Card {
    /**
     * The type of the card (NUMBER, ACTION, WILD).
     */
    private Type type;
    /**
     * The value of the card (e.g., ONE, SKIP, WILD_DRAW_FOUR).
     */
    protected String value;
    /**
     * The color of the card (RED, GREEN, BLUE, YELLOW), or null for wild cards.
     */
    protected Color color;

    /**
     * Constructs a card with the specified type, value, and color.
     *
     * @param type  the type of the card
     * @param value the value of the card
     * @param color the color of the card (null for wild cards)
     */
    public Card(Type type, String value, Color color) {
        this.type = type;
        this.value = value;
        this.color = color;
    }

    /**
     * Determines if this card matches another card according to UNO rules.
     * <p>
     * A card matches if it is the same card, or if the type, color, or value matches, or if the other card is a wild card.
     *
     * @param card the card to compare against
     * @return true if the cards match, false otherwise
     */
    public boolean match(Card card) {
        if (this.equals(card)) {
            return true;
        }
        if (card.getType() == Type.WILD) {
            return true;
        }
        if (this.color == card.getColor()) {
            return true;
        }
        if (this.value == card.getValue()) {
            return true;
        }
        return false;
    }

    /**
     * Returns the type of the card.
     *
     * @return the card type
     */
    public Type getType() {
        return type;
    }

    /**
     * Returns the value of the card.
     *
     * @return the card value
     */
    public String getValue() {
        return value;
    }

    /**
     * Returns the color of the card.
     *
     * @return the card color, or null if the card is a wild card
     */
    public Color getColor() {
        return color;
    }

    /**
     * Plays the card. Must be implemented by subclasses to define card-specific play logic.
     *
     * @param state the current game state
     * @return true if the play is valid and successful, false otherwise
     */
    public abstract boolean play(GameState state);

    /**
     * Factory method to create a card of the specified type, value, and color.
     *
     * @param type  the type of the card (NUMBER, ACTION, WILD)
     * @param value the value of the card (e.g., ONE, SKIP, WILD_DRAW_FOUR)
     * @param color the color of the card (null for wild cards)
     * @return a new Card instance or null if invalid
     */
    public static Card create(Type type, String value, Color color) {
        value = value.replace(" ", "_").toUpperCase();
        return switch (type) {
            case NUMBER -> {
                Number number = Number.valueOf(value);
                List<Number> values = Arrays.asList(Number.values());
                yield values.contains(number) ? new NumberCard(number, color) : null;
            }
            case ACTION -> {
                Action action = Action.valueOf(value);
                List<Action> values = Arrays.asList(Action.values());
                yield values.contains(action) ? new ActionCard(action, color) : null;
            }
            case WILD -> {
                Wild wild = Wild.valueOf(value);
                List<Wild> values = Arrays.asList(Wild.values());
                yield values.contains(wild) ? new WildCard(wild) : null;
            }
        };
    }

    /**
     * Factory method to create a card of the specified type and value (for wild cards).
     *
     * @param type  the type of the card (should be WILD)
     * @param value the value of the card (e.g., WILD, WILD_DRAW_FOUR)
     * @return a new Card instance or null if invalid
     */
    public static Card create(Type type, String value) {
        return create(type, value, null);
    }

    public String toString() {
        if (type == Type.NUMBER || type == Type.ACTION) {
            return (color.toString() + " " + value.replace("_", " ")).toLowerCase();
        } else {
            return value.replace("_", " ").toLowerCase();
        }
    }

    /**
     * Returns the hash code for this card.
     *
     * @return the hash code value for this card
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        return result;
    }

    /**
     * Compares this card to another object for equality.
     *
     * @param obj the object to compare
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (type != other.type)
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        if (color != other.color)
            return false;
        return true;
    }
}
