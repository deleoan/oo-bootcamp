package org.length;

public class Mile {
    private int value;

    Mile(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == Yard.class) {
            return this.value == (((Yard) obj).getValue() / 1760.0);
        }
        return obj != null && obj.getClass() == Mile.class && this.value == ((Mile) obj).value;
    }
}
