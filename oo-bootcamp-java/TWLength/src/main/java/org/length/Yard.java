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
        return obj != null && obj.getClass() == Yard.class && this.value == ((Yard) obj).value;
    }
}
