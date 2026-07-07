package com.example.lab5;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    // ProductValidator.java (app/src/main/java/...)
    public static boolean isValidSku(int sku) {
        return sku > 0;
    }

    @Test
    public void skuMustBePositive() {
        assertFalse(ProductValidator.isValidSku(0));
        assertFalse(ProductValidator.isValidSku(-42));
        assertTrue(ProductValidator.isValidSku(1001));
    }
}
