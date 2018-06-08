package org.length;

class Inch extends Length {

    Inch(int value) {
        super(value);
        this.multiplier = Value.Inch.getValue();
    }
}
