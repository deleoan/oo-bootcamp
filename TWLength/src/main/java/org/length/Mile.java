package org.length;

class Mile implements Length{
    private int value;

    Mile(int value) {
        this.value = value;
    }

    @Override
    public double getBaseValue() {
        return value * 63360;
    }
}
