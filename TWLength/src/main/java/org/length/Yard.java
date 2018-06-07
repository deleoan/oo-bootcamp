package org.length;

class Yard extends Length{
    Yard(int value) {
        super(value);
    }

    @Override
    double getBaseValue() {
        return value * Value.Yard.getValue();
    }
}
