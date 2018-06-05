package org.length;

class Inch implements Length {
    private int value;

    Inch(int value) {
        this.value = value;
    }

    @Override
    public double getBaseValue() {
        return value;
    }
}
