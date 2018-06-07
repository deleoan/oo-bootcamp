package org.length;

public abstract class Length {
    private int value;
    int multiplier;

    Length(int value) {
        this.value = value;
    }

    private double getBaseValue() {
        return value * multiplier;
    }

    public void add(Length length) {
        this.value += (length.getBaseValue() / this.multiplier);
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && this.getBaseValue() == ((Length) obj).getBaseValue();
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
