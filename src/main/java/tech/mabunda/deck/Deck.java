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
import tech.mabunda.player.Player;

/**
 * Represents a deck of Uno cards, including draw and discard piles.
 * <p>
 * Handles card distribution, shuffling, and pile management according to Uno rules.
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

    private int maxStartingCards;

    /**
     * Constructs a new deck with all UNO cards and shuffles the draw pile.
     * <p>
     * The deck consists of number, action, and wild cards as per UNO rules.
     */
    public Deck() {
        this.maxStartingCards = 7;
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

        Card topDiscardPileCard = discard_pile.get(discard_pile.size() - 1);
        discard_pile.remove(discard_pile.size());

        draw_pile.addAll(discard_pile);
        Collections.shuffle(draw_pile);

        discard_pile.clear();
        discard_pile.add(topDiscardPileCard);
    }


    /**
     * Deals 7 cards to each player and sets up the initial discard pile with a number card.
     * <p>
     * Ensures the first discard is a number card as per UNO rules.
     *
     * @param players the list of players to deal cards to
     */
    public void deal(ArrayList<Player> players) {
        // Deal 7 cards to each player
        for (Player player: players) {
            for (int i = 0; i < maxStartingCards; i++) {
                player.drawCard(this);
            }
        }

        // Ensure the first discard is a number card
        Card topDrawPileCard = draw_pile.get(draw_pile.size() - 1);
        while (topDrawPileCard.getType() != Type.NUMBER) {
            shuffle();
            topDrawPileCard = draw_pile.get(draw_pile.size() - 1);
        }

        draw_pile.remove(draw_pile.size() - 1);
        discard_pile.add(topDrawPileCard);
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
     * Returns the current discard pile.
     *
     * @return the list of cards in the discard pile
     */
    public ArrayList<Card> getDiscardPile() {
        return discard_pile;
    }


    /**
     * Draws a card from the top of the draw pile. If the draw pile is low, shuffles the deck.
     *
     * @return the card drawn from the draw pile
     */
    public Card drawCard() {
        if (draw_pile.size() <= 1) {
            shuffle();
        }

        Card topDrawPileCard = draw_pile.get(draw_pile.size() - 1);
        draw_pile.remove(draw_pile.size() - 1);

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
                    Card numberCard = Card.create(color + " " + number.toString());
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
