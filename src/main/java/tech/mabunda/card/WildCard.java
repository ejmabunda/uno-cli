package tech.mabunda.card;

public class WildCard extends Card {
    public WildCard(String value) {
        super(Type.WILD, value, null);
    }

    @Override
    public boolean play() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }
}
