package org.length;

class Mile extends Length{

    Mile(int value) {
        super(value);
        this.multiplier = Value.Mile.getValue();
    }
}
