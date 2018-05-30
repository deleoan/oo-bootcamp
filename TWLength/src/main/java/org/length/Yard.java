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
        if (obj != null && obj instanceof Feet) {
            return this.value == (((Feet) obj).getValue() / 3.0);
        }
        return obj != null && obj instanceof Yard && this.value == ((Yard) obj).value;
    }
}
