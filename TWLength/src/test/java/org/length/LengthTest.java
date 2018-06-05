package org.length;

import org.junit.Assert;
import org.junit.Test;

public class LengthTest {

    @Test
    public void test_3_mile_equal_to_3_mile() {
        UnitFactory unitFactory = new UnitFactory();
//        Mile mile = new Mile(3);
//        Assert.assertEquals(mile, new Mile(3));
    }

    @Test
    public void  test_3_mile_not_equal_to_2_mile() {
        Mile mile = new Mile(3);
        Assert.assertNotEquals(mile, new Mile(2));
    }

    @Test
    public void test_3_mile_not_equal_to_4_mile() {
        Mile mile = new Mile(3);
        Assert.assertNotEquals(mile, new Mile(4));
    }

    @Test
    public void test_1_mile_not_equal_to_null() {
        Mile mile = new Mile(1);
        Assert.assertNotEquals(mile, null);
    }

    @Test
    public void test_null_not_equal_1_mile() {
        Mile mile = new Mile(1);
        Assert.assertNotEquals(null, mile);
    }

    @Test
    public void test_1_mile_equal_to_1760_yard() {
        Mile mile = new Mile(1);
        Assert.assertEquals(mile, new Yard(1760));
    }

    @Test
    public void test_3_yard_equal_to_3_yard() {
        Yard yard = new Yard(3);
        Assert.assertEquals(yard, new Yard(3));
    }

    @Test
    public void test_1_mile_not_equal_to_1761_yard() {
        Mile mile = new Mile(1);
        Assert.assertNotEquals(mile, new Yard(1761));
    }

    @Test
    public void test_3_yard_not_equal_to_4_yard() {
        Yard yard = new Yard(3);
        Assert.assertNotEquals(yard, new Yard(4));
    }

    @Test
    public void test_1_yard_not_equal_to_null() {
        Yard yard = new Yard(1);
        Assert.assertNotEquals(yard, null);
    }

    @Test
    public void test_null_not_equal_to_1_yard() {
        Yard yard = new Yard(1);
        Assert.assertNotEquals(null, yard);
    }

    @Test
    public void test_1_yard_equal_to_3_feet() {
        Yard yard = new Yard(1);
        Assert.assertEquals(yard, new Feet(3));
    }

    @Test
    public void test_1_feet_equal_to_12_inch() {
        Feet feet = new Feet(1);
        Assert.assertEquals(feet, new Inch(12));
    }

    @Test
    public void test_1_mile_equal_to_5280_feet() {
        Mile mile = new Mile(1);
        Assert.assertEquals(mile, new Feet(5280));
    }

    @Test
    public void test_1_mile_equal_to_63360_inch() {
        Mile mile = new Mile(1);
        Assert.assertEquals(mile, new Inch(63360));
    }

    @Test
    public void test_1_yard_not_equal_to_4_feet() {
        Yard yard = new Yard(1);
        Assert.assertNotEquals(yard, new Feet(4));
    }

    @Test
    public void test_1_feet_not_equal_to_13_inch() {
        Feet feet = new Feet(1);
        Assert.assertNotEquals(feet, new Inch(13));
    }

    @Test
    public void test_1_mile_not_equal_to_5281_feet() {
        Mile mile = new Mile(1);
        Assert.assertNotEquals(mile, new Feet(5281));
    }

    @Test
    public void test_1_mile_not_equal_to_63361_inch() {
        Mile mile = new Mile(1);
        Assert.assertNotEquals(mile, new Inch(63361));
    }

    @Test
    public void test_1_feet_not_equal_to_null() {
        Feet feet = new Feet(1);
        Assert.assertNotEquals(feet, null);
    }

    @Test
    public void test_null_not_equal_to_1_feet() {
        Feet feet = new Feet(1);
        Assert.assertNotEquals(null, feet);
    }

    @Test
    public void test_1_inch_not_equal_to_null() {
        Inch inch = new Inch(1);
        Assert.assertNotEquals(inch, null);
    }

    @Test
    public void test_null_not_equal_to_1_inch() {
        Inch inch = new Inch(1);
        Assert.assertNotEquals(null, inch);
    }

    @Test
    public void test_3_feet_equal_to_1_yard() {
        Feet feet = new Feet(3);
        Assert.assertEquals(feet, new Yard(1));
    }

    @Test
    public void test_12_inch_equal_to_1_feet() {
        Inch inch = new Inch(12);
        Assert.assertEquals(inch, new Feet(1));
    }

    @Test
    public void test_5280_feet_equal_to_1_mile() {
        Feet feet = new Feet(5280);
        Assert.assertEquals(feet, new Mile(1));
    }

    @Test
    public void test_63360_inch_equal_to_1_mile() {
        Inch inch = new Inch(63360);
        Assert.assertEquals(inch, new Mile(1));
    }

    @Test
    public void test_4_feet_not_equal_to_1_yard() {
        Feet feet = new Feet(4);
        Assert.assertNotEquals(feet, new Yard(1));
    }

    @Test
    public void test_13_inch_not_equal_to_1_feet() {
        Inch inch = new Inch(13);
        Assert.assertNotEquals(inch, new Feet(1));
    }

    @Test
    public void test_5281_feet_not_equal_to_1_Mile() {
        Feet feet = new Feet(5281);
        Assert.assertNotEquals(feet, new Mile(1));
    }

    @Test
    public void test_63361_inch_not_equal_to_1_Mile() {
        Inch inch = new Inch(63361);
        Assert.assertNotEquals(inch, new Mile(1));
    }
}
