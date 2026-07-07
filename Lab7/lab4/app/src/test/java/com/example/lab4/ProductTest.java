package com.example.lab4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class ProductTest {

    @Test
    public void testGetId() {
        Product product = new Product("1", "Apples", 1.99);
        assertEquals("1", product.getId());
    }

    @Test
    public void testGetProductName() {
        Product product = new Product("1", "Apples", 1.99);
        assertEquals("Apples", product.getProductName());
    }

    @Test
    public void testGetPrice() {
        Product product = new Product("1", "Apples", 1.99);
        assertEquals(1.99, product.getPrice(), 0.001);
    }

    @Test
    public void testEmptyConstructor() {
        Product product = new Product();
        assertNull(product.getId());
        assertNull(product.getProductName());
        assertEquals(0.0, product.getPrice(), 0.001);
    }

    @Test
    public void testProductWithEmptyStrings() {
        Product product = new Product("", "", 0.0);
        assertEquals("", product.getId());
        assertEquals("", product.getProductName());
        assertEquals(0.0, product.getPrice(), 0.001);
    }
}
//Test for Action: 1st Tiral