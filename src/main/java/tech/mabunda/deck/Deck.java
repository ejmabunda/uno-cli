package tech.mabunda.deck;

import java.util.ArrayList;
import java.util.Collections;

import tech.mabunda.card.ActionCard;
import tech.mabunda.card.Card;
import tech.mabunda.card.NumberCard;
import tech.mabunda.card.WildCard;
import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Type;

public class Deck {
    private ArrayList<Card> draw_pile;
    private ArrayList<Card> discard_pile;

    public Deck() {
        draw_pile = new ArrayList<>();
        draw_pile.addAll(getNumberCards());
        draw_pile.addAll(getActionCards());
        draw_pile.addAll(getWildCards());
        shuffle();

        discard_pile = new ArrayList<>();
    }

    public void shuffle() {
        Collections.shuffle(draw_pile);
    }

    public ArrayList<Card> getDrawPile() {
        return draw_pile;
    }

    private ArrayList<Card> getNumberCards() {
        ArrayList<Card> numberCards = new ArrayList<>();

        for (int a = 0; a < 2; a++) {
            for (Color color : Color.values()) {
                for (String number : NumberCard.getPossibleValues()) {
                    Card numberCard = Card.create(Type.NUMBER, number, color);
                    if (number.equals("0") && draw_pile.contains(numberCard)) { continue; }
                    else numberCards.add(new NumberCard(number, color));
                }
            }
        }

        return numberCards;
    }

    private ArrayList<Card> getActionCards() {
        ArrayList<Card> actionCards = new ArrayList<>();
        for (int a = 0; a < 2; a++) {
            for (Color color : Color.values()) {
                for (String action : ActionCard.getPossibleValues()) {
                    actionCards.add(new NumberCard(action, color));
                }
            }
        }

        return actionCards;
    }

    private ArrayList<Card> getWildCards() {
        ArrayList<Card> wildCards = new ArrayList<>();
        for (int a = 0; a < 2; a++) {
            for (String action : ActionCard.getPossibleValues()) {
                wildCards.add(new WildCard(action));
            }
        }

        return wildCards;
    }
}
