package org.length;

class Feet implements Length{
    private int value;

    Feet(int value) {
        this.value = value;
    }

    @Override
    public double getBaseValue() {
        return value * 12;
    }
}
