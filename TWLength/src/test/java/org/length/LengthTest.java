package org.length;

import org.junit.Assert;
import org.junit.Test;

public class LengthTest {

    @Test
    public void test_3_mile_equal_to_3_mile() {
        Mile mile = new Mile(3);
        Assert.assertEquals(mile, new Mile(3));
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
        Assert.assertNotEquals(null, new Mile(1));
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
    public void test_null_not_equal_1_yard() {
        Yard yard = new Yard(1);
        Assert.assertNotEquals(null, yard);
    }
}
