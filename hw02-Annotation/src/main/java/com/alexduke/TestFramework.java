package com.alexduke;

import com.alexduke.annotations.AfterEach;
import com.alexduke.annotations.BeforeEach;
import com.alexduke.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestFramework {
    static List<Method> methodTest = new ArrayList<>();
    static List<Method> methodAfterEach = new ArrayList<>();
    static List<Method> methodBeforeEach = new ArrayList<>();

    public static void runTestTasks(String nameClass) throws Exception {
        Class testClass = Class.forName(nameClass);
        System.out.println(testClass);
        methodsByAnnotationToArraylist(testClass);
        runMethods(testClass);
    }

    private static void methodsByAnnotationToArraylist(Class testClass) throws NoSuchMethodException {
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
    }

    private static void runMethods(Class testClass) throws Exception {
        Constructor<Object> constructor = testClass.getConstructor();
        Object object = constructor.newInstance();
        for (Method methodTest : methodTest) {
            for (Method methodBeforeEach : methodBeforeEach) {
                methodInvoke(testClass, object, methodBeforeEach);
            }
            methodInvoke(testClass, object, methodTest);
            for (Method methodAfterEach : methodAfterEach) {
                methodInvoke(testClass, object, methodAfterEach);
            }
        }
    }

    private static void methodInvoke(Class testClass, Object object, Method method) throws Exception {
        String methodName = method.getName();
        Method methodInvoke = testClass.getDeclaredMethod(methodName);
        if (Modifier.isStatic(methodInvoke.getModifiers())) {
            methodInvoke.invoke(methodInvoke);
        } else {
            methodInvoke.invoke(object);
        }
    }
}

