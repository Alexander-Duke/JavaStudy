package com.alexduke;

public class TestClass {
    private int a;
    private int b;

    public TestClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void multiplication(int a, int b) {
        int multiplication = a * b;
        System.out.printf("%i * %i = %i",a,b,multiplication);
    }

    public void division(int a, int b) {
        int division = a / b;
        System.out.printf("%i / %i = %i",a,b,division);
    }

    public void addition(int a, int b) {
        int addition = a + b;
        System.out.printf("%i + %i = %i",a,b,addition);
    }
}
