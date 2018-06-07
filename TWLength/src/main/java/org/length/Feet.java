package org.length;

class Feet extends Length{
    Feet(int value) {
        super(value);
        this.multiplier = Value.Feet.getValue();
    }
}
