package tech.mabunda.card;

import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Number;
import tech.mabunda.card.enums.Type;

public class NumberCard extends Card {
    public NumberCard(Number value, Color color) {
        super(Type.NUMBER, value.toString(), color);
    }

    @Override
    public boolean play() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }

}
