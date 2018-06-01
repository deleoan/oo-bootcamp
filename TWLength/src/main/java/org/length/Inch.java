package org.length;

class Inch extends Length {

    Inch(int value) {
        super(value);
    }

    @Override
    double getBaseValue() {
        return value;
    }
}
