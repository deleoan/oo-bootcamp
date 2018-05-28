package org.length;

public class Feet {
    private int value;

    int getValue() {
        return value;
    }

    Feet(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == Inch.class) {
            return this.value == (((Inch) obj).getValue() / 12.0);
        }
        return obj != null && obj.getClass() == Feet.class && this.value == ((Feet) obj).value;
    }
}
