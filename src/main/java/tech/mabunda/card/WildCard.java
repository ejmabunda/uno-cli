package tech.mabunda.card;

import java.util.List;

import tech.mabunda.card.enums.Type;
import tech.mabunda.card.enums.Wild;

/**
 * Represents a wild card in UNO (Wild, Wild Draw Four).
 */
public class WildCard extends Card {

    /**
     * Constructs a WildCard with the specified wild value.
     *
     * @param value the wild value
     */
    public WildCard(Wild value) {
        super(Type.WILD, value.toString(), null);
    }

    @Override
    /**
     * Plays the wild card. To be implemented.
     *
     * @return true if the play is valid, false otherwise
     */
    public boolean play() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }

    /**
     * Returns the possible values for wild cards.
     *
     * @return list of possible wild card values
     */
    public static List<String> getPossibleValues() {
        return possibleValues;
    }
}
