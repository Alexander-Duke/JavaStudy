package com.alexduke;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        TestFramework.runTestTasks("com.alexduke.CalcTest");
    }
}
