package com.alexduke;

import com.alexduke.annotations.AfterEach;
import com.alexduke.annotations.BeforeEach;
import com.alexduke.annotations.Test;

public class CalcTest {
    private static Calc calc;

    @BeforeEach
    static void init() {
        calc = new Calc(5,5);
    }

    @Test
    void multiplication() {
        System.out.println("@Test Result multiplication: \n");
        calc.multiplication();
    }

    @Test
    void  addition() {
        System.out.println("@Test Result addition: \n");
        calc.addition();
    }

    @AfterEach
    void divide() {
        System.out.println("@AfterEach Result division: \n");
        calc.division();
    }

}