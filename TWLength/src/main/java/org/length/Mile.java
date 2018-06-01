package org.length;

class Mile extends Length{
    Mile(int value) {
        super(value);
    }

    @Override
    double getBaseValue() {
        return value * 63360;
    }
}
