package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    void testAddPositiveNumbers() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void testAddNegativeNumbers() {
        Calculator calc = new Calculator();
        assertEquals(-5, calc.add(-2, -3));
    }

    @Test
    void testAddZero() {
        Calculator calc = new Calculator();
        assertEquals(2, calc.add(2, 0));
        assertEquals(2, calc.add(0, 2));
    }

    @Test
    void testDividePositiveNumbers() {
        Calculator calc = new Calculator();
        assertEquals(2, calc.divide(6, 3));
    }

    @Test
    void testDivideByZero() {
        Calculator calc = new Calculator();
        assertThrows(ArithmeticException.class, () -> calc.divide(6, 0));
    }

    @Test
    void testDivideNegativeNumbers() {
        Calculator calc = new Calculator();
        assertEquals(2, calc.divide(-6, -3));
    }

    @Test
    void testDivideBoundaryValues() {
        Calculator calc = new Calculator();
        assertEquals(0, calc.divide(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
