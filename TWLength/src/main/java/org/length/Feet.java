package org.length;

class Feet extends Length{
    Feet(int value) {
        super(value);
    }

    @Override
    double getBaseValue() {
        return value * Value.Feet.getValue();
    }
}
