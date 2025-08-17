package tech.mabunda.card;

import tech.mabunda.card.enums.Action;
import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Type;

public class ActionCard extends Card {
    public ActionCard(Action value, Color color) {
        super(Type.ACTION, value.toString(), color);
    }

    @Override
    public boolean play() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }
}
