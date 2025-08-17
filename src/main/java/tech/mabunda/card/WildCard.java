package tech.mabunda.card;

import java.util.List;

import tech.mabunda.card.enums.Type;

public class WildCard extends Card {
    private static List<String> possibleValues = List.of("wild", "wild draw four");

    public WildCard(String value) {
        super(Type.WILD, value, null);
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
