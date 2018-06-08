package org.length;

class Yard extends Length {

    Yard(int value) {
        super(value);
        this.multiplier = Value.Yard.getValue();
    }
}
