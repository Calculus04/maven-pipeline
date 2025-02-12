package com.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        int result = calc.add(5, 3);
        Assert.assertEquals(result, 8, "Addition result is Wrong");
    }
    @Test
    public void testAddWithNegativeNumbers() {
        Calculator calc = new Calculator();
        int result = calc.add(-5, -3);
        Assert.assertEquals(result, -8, "Addition with negative numbers is wrong");
    }

    @Test
    public void testAddWithZero() {
        Calculator calc = new Calculator();
        int result = calc.add(5, 0);
        Assert.assertEquals(result, 5, "Addition with zero is wrong");
    }

    @Test
    public void testAddWithLargeNumbers() {
        Calculator calc = new Calculator();
        int result = calc.add(1_000_000, 2_000_000);
        Assert.assertEquals(result, 3_000_000, "Addition of large numbers is wrong");
    }
}
