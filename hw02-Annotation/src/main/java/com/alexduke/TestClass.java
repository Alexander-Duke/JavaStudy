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

    public void multiplication() {
        int multiplication = getA() * getB();
        System.out.printf("%s * %s = %s", getA(), getB(), multiplication);
    }

    public void division() {
        int division = getA() / getB();
        System.out.printf("%s / %s = %s", getA(), getB(), division);
    }

    public void addition() {
        int addition = getA() + getB();
        System.out.printf("%s + %s = %s", getA(), getB(), addition);
    }
}
