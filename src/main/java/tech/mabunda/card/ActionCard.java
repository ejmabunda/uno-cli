package tech.mabunda.card;

import java.util.List;

import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Type;

public class ActionCard extends Card {
    private static List<String> possibleValues = List.of("skip", "reverse", "draw two");

    public ActionCard(String value, Color color) {
        super(Type.ACTION, value, color);
    }

    @Override
    public boolean play() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }

    public static List<String> getPossibleValues() {
        return possibleValues;
    }
}
