package tech.mabunda.deck;

import java.util.ArrayList;
import java.util.Collections;

import tech.mabunda.card.ActionCard;
import tech.mabunda.card.Card;
import tech.mabunda.card.WildCard;
import tech.mabunda.card.enums.Action;
import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Number;
import tech.mabunda.card.enums.Type;
import tech.mabunda.card.enums.Wild;

/**
 * Represents a deck of UNO cards, including draw and discard piles.
 */
/**
 * Represents a deck of UNO cards, including draw and discard piles.
 * Provides methods to initialize, shuffle, and draw cards from the deck.
 */
public class Deck {
    /**
     * The pile of cards from which players draw.
     */
    private ArrayList<Card> draw_pile;
    /**
     * The pile of cards that have been played/discarded.
     */
    private ArrayList<Card> discard_pile;

    /**
     * Constructs a new deck with all UNO cards and shuffles the draw pile.
     * The deck consists of number, action, and wild cards as per UNO rules.
     */
    public Deck() {
        draw_pile = new ArrayList<>();
        draw_pile.addAll(getNumberCards());
        draw_pile.addAll(getActionCards());
        draw_pile.addAll(getWildCards());

        this.discard_pile = new ArrayList<>();

        shuffle();
    }

    /**
     * Shuffles the draw pile. If the draw pile is low, combines it with the discard pile (except the top card),
     * shuffles, and resets the discard pile.
     */
    private void shuffle() {
        if (discard_pile.isEmpty()) {
            Collections.shuffle(draw_pile);
            return;
        }

        Card topDiscardPileCard = discard_pile.get(discard_pile.size());
        discard_pile.remove(discard_pile.size());

        draw_pile.addAll(discard_pile);
        Collections.shuffle(draw_pile);

        discard_pile.clear();
        discard_pile.add(topDiscardPileCard);
    }


    /**
     * Returns the current draw pile.
     *
     * @return the list of cards in the draw pile
     */
    public ArrayList<Card> getDrawPile() {
        return draw_pile;
    }


    /**
     * Draws a card from the top of the draw pile. If the draw pile is low, shuffles the deck.
     *
     * @return the card drawn from the draw pile
     */
    public Card draw_card() {
        if (draw_pile.size() <= 1) {
            shuffle();
        }

        Card topDrawPileCard = draw_pile.get(draw_pile.size());
        draw_pile.remove(draw_pile.size());

        return topDrawPileCard;
    }


    /**
     * Generates all number cards (0-9 in each color) for the UNO deck.
     *
     * @return a list of all number cards
     */
    private ArrayList<Card> getNumberCards() {
        ArrayList<Card> numberCards = new ArrayList<>();

        for (int a = 0; a < 2; a++) {
            for (Color color : Color.values()) {
                for (Number number : Number.values()) {
                    Card numberCard = Card.create(Type.NUMBER, number.toString(), color);
                    if (number.equals(Number.ZERO) && numberCards.contains(numberCard)) {
                        continue;
                    } else {
                        numberCards.add(numberCard);
                    }
                }
            }
        }

        return numberCards;
    }


    /**
     * Generates all action cards (Skip, Reverse, Draw Two in each color) for the UNO deck.
     *
     * @return a list of all action cards
     */
    private ArrayList<Card> getActionCards() {
        ArrayList<Card> actionCards = new ArrayList<>();
        for (int a = 0; a < 2; a++) {
            for (Color color : Color.values()) {
                for (Action action : Action.values()) {
                    actionCards.add(new ActionCard(action, color));
                }
            }
        }

        return actionCards;
    }


    /**
     * Generates all wild cards (Wild, Wild Draw Four) for the UNO deck.
     *
     * @return a list of all wild cards
     */
    private ArrayList<Card> getWildCards() {
        ArrayList<Card> wildCards = new ArrayList<>();

        for (Wild wild : Wild.values()) {
            for (int i = 0; i < 4; i++) {
                wildCards.add(new WildCard(wild));
            }
        }

        return wildCards;
    }
}
