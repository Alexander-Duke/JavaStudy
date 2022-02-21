package com.alexduke;

import com.alexduke.annotations.AfterEach;
import com.alexduke.annotations.BeforeEach;
import com.alexduke.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestFramework {
    static void runTestTasks(String nameClass) throws Exception {
        Class testClass = Class.forName(nameClass); //получили класс
        System.out.println(testClass);
        List<Method> methodTest = new ArrayList<>();
        List<Method> methodAfterEach = new ArrayList<>();
        List<Method> methodBeforeEach = new ArrayList<>();

        Method[] methods = testClass.getDeclaredMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            Method methodByName = testClass.getDeclaredMethod(methodName);
            Annotation[] methodByNameDeclaredAnnotations = methodByName.getDeclaredAnnotations();

            for (Annotation annotation : methodByNameDeclaredAnnotations) {
                if (annotation instanceof Test) {
                    methodTest.add(method);
                } else if (annotation instanceof BeforeEach) {
                    methodBeforeEach.add(method);
                } else if (annotation instanceof AfterEach) {
                    methodAfterEach.add(method);
                }
            }
        }
        System.out.println("methodTest: " + methodTest);
        System.out.println("methodBeforeEach: " + methodBeforeEach);
        System.out.println("methodAfterEach: " + methodAfterEach);

    }

}

