package org.length;

/*public abstract class Length {
    int value;

    Length(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }

    abstract double getBaseValue();

    @Override
    public boolean equals(Object obj) {
        return obj != null && this.getBaseValue() == ((Length) obj).getBaseValue();
    }
}*/

public interface Length {
    double getBaseValue();
}
