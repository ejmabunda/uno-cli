package tech.mabunda.card;

import java.util.Arrays;
import java.util.List;

import tech.mabunda.card.enums.Action;
import tech.mabunda.card.enums.Color;
import tech.mabunda.card.enums.Number;
import tech.mabunda.card.enums.Type;
import tech.mabunda.card.enums.Wild;

public abstract class Card {
    private Type type;
    private String value;
    private Color color;

    public Card(Type type, String value, Color color) {
        this.type = type;
        this.value = value;
        this.color = color;
    }

    public Type getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public abstract boolean play();

    public static Card create(Type type, String value, Color color) {
        value = value.replace(" ", "_").toUpperCase();
        return switch (type) {
            case NUMBER -> {
                Number number = Number.valueOf(value);
                List<Number> values = Arrays.asList(Number.values());
                yield values.contains(number) ? new NumberCard(number, color) : null;
            }
            case ACTION -> {
                Action action = Action.valueOf(value);
                List<Action> values = Arrays.asList(Action.values());
                yield values.contains(action) ? new ActionCard(action, color) : null;
            }
            case WILD -> {
                Wild wild = Wild.valueOf(value);
                List<Wild> values = Arrays.asList(Wild.values());
                yield values.contains(wild) ? new WildCard(wild): null;
            }
        };
    }

    public static Card create(Type type, String value) {
        return create(type, value, null);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (type != other.type)
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        if (color != other.color)
            return false;
        return true;
    }
}
