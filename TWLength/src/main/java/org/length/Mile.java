package org.length;

public class Mile {
    private int value;

    Mile(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Yard) {
            return this.value == (((Yard) obj).getValue() / 1760.0);
        } else if (obj != null && obj instanceof Feet) {
            return this.value == (((Feet) obj).getValue() / 5280.0);
        } else if (obj != null && obj instanceof Inch) {
            return this.value == (((Inch) obj).getValue() / 63360.0);
        } 
        return obj != null && obj instanceof Mile && this.value == ((Mile) obj).value;
    }
}
