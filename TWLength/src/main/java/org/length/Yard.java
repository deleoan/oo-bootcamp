package org.length;

class Yard implements Length{
    private int value;

    Yard(int value) {
        this.value = value;
    }

    @Override
    public double getBaseValue() {
        return value * 36;
    }
}
