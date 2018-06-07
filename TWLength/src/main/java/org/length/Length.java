package org.length;

public abstract class Length extends Object {
    int value;

    Length(int value) {
        this.value = value;
    }

    abstract double getBaseValue();

    @Override
    public boolean equals(Object obj) {
        return obj != null && this.getBaseValue() == ((Length) obj).getBaseValue();
    }


    double add(Length length) {
        return this.getBaseValue() + length.getBaseValue();
    }

    enum Value {
        Feet(12),
        Mile(63360),
        Yard(36);

        private final Integer value;

        Value(Integer v) {
            this.value = v;
        }

        public Integer getValue() {
            return value;
        }
    }
}
