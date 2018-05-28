package org.length;

public class Yard {
    private int value;

    Yard(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == Feet.class) {
            return this.value == (((Feet) obj).getValue() / 3.0);
        }
        return obj != null && obj.getClass() == Yard.class && this.value == ((Yard) obj).value;
    }
}
