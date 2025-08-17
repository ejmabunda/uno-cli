package tech.mabunda.card;

import java.util.List;

import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Type;

public class NumberCard extends Card {
    private static List<String> possibleValues = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");


    public NumberCard(String value, Color color) {
        super(Type.NUMBER, value, color);
    }

    public static List<String> getPossibleValues() {
        return possibleValues;
    }

    @Override
    public boolean play() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }

}
