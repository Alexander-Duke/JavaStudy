package com.alexduke;

import com.alexduke.annotations.AfterEach;
import com.alexduke.annotations.BeforeEach;
import com.alexduke.annotations.Test;

public class CalcTest {
    private static Calc calc;

    @BeforeEach
    static void init() {
        calc = new Calc(5,5);
        System.out.println("\n@BeforeEach create object:");
    }

    @Test
    void multiplication() {
        System.out.println("\n@Test Result multiplication:");
        calc.multiplication();
    }

    @Test
    void  addition() {
        System.out.println("\n@Test Result addition:");
        calc.addition();
    }

    @AfterEach
    void divide() {
        System.out.println("\n@AfterEach Result division:");
        calc.division();
    }

}
