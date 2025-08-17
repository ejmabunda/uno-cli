package tech.mabunda.deck;

import java.util.ArrayList;
import java.util.Collections;

import tech.mabunda.card.ActionCard;
import tech.mabunda.card.Card;
import tech.mabunda.card.NumberCard;
import tech.mabunda.card.WildCard;
import tech.mabunda.card.enums.Action;
import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Number;
import tech.mabunda.card.enums.Type;
import tech.mabunda.card.enums.Wild;

/**
 * Represents a deck of UNO cards, including draw and discard piles.
 */
public class Deck {
    private ArrayList<Card> draw_pile;
    private ArrayList<Card> discard_pile;

    /**
     * Constructs a new deck with all UNO cards and shuffles the draw pile.
     */
    public Deck() {
        draw_pile = new ArrayList<>();
        draw_pile.addAll(getNumberCards());
        draw_pile.addAll(getActionCards());
        draw_pile.addAll(getWildCards());
        shuffle();

        discard_pile = new ArrayList<>();
    }

    /**
     * Shuffles the draw pile.
     */
    public void shuffle() {
        Collections.shuffle(draw_pile);
    }

    /**
     * Returns the draw pile of the deck.
     *
     * @return the draw pile as an ArrayList of Card
     */
    public ArrayList<Card> getDrawPile() {
        return draw_pile;
    }

    private ArrayList<Card> getNumberCards() {
        ArrayList<Card> numberCards = new ArrayList<>();

        for (int a = 0; a < 2; a++) {
            for (Color color : Color.values()) {
                for (Number number : Number.values()) {
                    Card numberCard = Card.create(Type.NUMBER, number.toString(), color);
                    if (number.equals(Number.ZERO) && numberCards.contains(numberCard)) {
                        continue;
                    } else
                    NumberCard numberCard = new NumberCard(number, color);
                    if (number.equals(Number.ZERO) && numberCards.contains(numberCard)) {
                        continue;
                    } else
                        numberCards.add(numberCard);
                }
            }
        }

        return numberCards;
    }

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
