package tech.mabunda.card;

import java.util.List;

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
        return switch (type) {
            case NUMBER -> {
                List<String> values = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
                yield values.contains(value) ? new NumberCard(value, color) : null;
            }
            case ACTION -> {
                List<String> values = List.of("skip", "reverse", "draw two");
                yield values.contains(value) ? new ActionCard(value, color) : null;
            }
            case WILD -> {
                List<String> values = List.of("wild", "wild draw four");
                yield values.contains(value) ? new WildCard(value) : null;
            }
        };
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
