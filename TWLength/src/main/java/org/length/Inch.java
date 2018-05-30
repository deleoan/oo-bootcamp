package org.length;

public class Inch {
    private int value;

    int getValue() {
        return value;
    }

    Inch(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Mile) {
            return this.value == (((Mile) obj).getValue() * 63360.0);
        }
        return obj != null && obj instanceof Feet && this.value == (((Feet) obj).getValue() * 12.0);
    }
}
