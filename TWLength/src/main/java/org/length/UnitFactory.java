package org.length;
//
//public class UnitFactory extends Length {
//
//    UnitFactory(int value) {
//        super(value);
//    }
//
//    @Override
//    Length createUnit(String type, int value) {
//        if(type == "Mile"){
//            return new Mile(value);
//        }
//    }
//
//    @Override
//    double getBaseValue() {
//        return 0;
//    }
//}

public class UnitFactory {
    public boolean isEqual(Length expected, Length actual) {
        if (expected instanceof Mile) {
            return actual != null && expected.getBaseValue() == actual.getBaseValue();
        }
        return false;
    }

//    @Override
//    public boolean equals(Object obj) {
//        return obj != null && this.getBaseValue() == ((Length) obj).getBaseValue();
//    }
}
