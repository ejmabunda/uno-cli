package tech.mabunda.card;

public class ActionCard extends Card {
    public ActionCard(String value, Color color) {
        super(Type.ACTION, value, color);
    }

    @Override
    public boolean play() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }
}
