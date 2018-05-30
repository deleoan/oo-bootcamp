package org.length;

public class Mile {
    private int value;

    Mile(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == Yard.class) {
            return this.value == (((Yard) obj).getValue() / 1760.0);
        } else if (obj != null && obj.getClass() == Feet.class) {
            return this.value == (((Feet) obj).getValue() / 5280.0);
        } else if (obj != null && obj.getClass() == Inch.class) {
            return this.value == (((Inch) obj).getValue() / 63360.0);
        } 
        return obj != null && obj.getClass() == Mile.class && this.value == ((Mile) obj).value;
    }

    int getValue() {
        return value;
    }
}
