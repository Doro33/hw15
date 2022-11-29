package org.hw_15.q5;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class Q5Test {
    @Test
    public void testStringToInt0() {
        Assert.assertEquals(-3, Q5.stringToInt("-3"));
    }

    @Test
    public void testStringToInt1() {
        Assert.assertEquals(32767, Q5.stringToInt("32767"));
    }

    @Test
    public void testStringToInt2() {
        Assert.assertEquals(350, Q5.stringToInt("350"));
    }

    @Test
    public void testStringToInt3() {
        Assert.assertEquals(-30, Q5.stringToInt("-30"));
    }

    @Test
    public void testStringToInt4() {
        assertThrows(NumberFormatException.class,
                () -> Q5.stringToInt(""));
    }

    @Test
    public void testStringToInt5() {
        assertThrows(NumberFormatException.class,
                () -> Q5.stringToInt("S58"));
    }

    @Test
    public void testStringToInt6() {
        assertThrows(NumberFormatException.class,
                () -> Q5.stringToInt("58 9"));
    }

    @Test
    public void testStringToInt7() {
        assertThrows(NumberFormatException.class,
                () -> Q5.stringToInt("1.1"));
    }

    @Test
    public void testStringToInt8() {
        assertThrows(NumberFormatException.class,
                () -> Q5.stringToInt("2222222222222222222222222222222222222"));
    }
    @Test
    public void testStringToInt9() {
        assertThrows(NumberFormatException.class,
                () -> Q5.stringToInt(null));
    }

    @Test
    public void testStringToInt10() {
        assertThrows(RuntimeException.class,
                () -> Q5.stringToInt("-32768"));
    }

    @Test
    public void testStringToInt11() {
        assertThrows(RuntimeException.class,
                () -> Q5.stringToInt("32768"));
    }
}