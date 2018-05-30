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
        } else if (obj != null && obj instanceof Yard){
            return this.value == (((Yard) obj).getValue() * 3.0);
        } else if (obj != null && obj instanceof Mile){
            return this.value == (((Mile) obj).getValue() * 5280.0);
        }
        return obj != null && obj.getClass() == Feet.class && this.value == ((Feet) obj).value;
    }
}
