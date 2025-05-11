package com.nsa.juni;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CalculatorTest {

    @Test
    void add_test() {
        Calculator cal = new Calculator();
        int actual = cal.add(10, 20);
        int expected = 30;

        Assertions.assertEquals(expected, actual);
    }


    @Test
    void divide_success_test() {
        int a = 10;
        int b = 2;
        Calculator cal = new Calculator();
        int actual = cal.divide(a, b); // 10/2 -> 5
        int expected = 5;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void divide_exception_test() {
        int a = 10;
        int b = 0;
        Calculator cal = new Calculator();

        ArithmeticException expectedAxception =
                Assertions.assertThrows(ArithmeticException.class, () -> cal.divide(a, b));

        Assertions.assertEquals("/ by zero", expectedAxception.getMessage());

    }
}