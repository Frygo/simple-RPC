package com.frygo.rpc.common.utils;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * @author frygo
 * @Create 2020--05-11 13:48
 */
public class ReflectionUtilsTest {

    @Test
    public void newInstance() {
        TestClass testClass1 = ReflectionUtils.newInstance(TestClass.class);
        assertNotNull(testClass1);
    }

    @Test
    public void getPublicMethods() {
        Method[] publicMethods = ReflectionUtils.getPublicMethods(TestClass.class);
        assertEquals(2,publicMethods.length);
        for (Method publicMethod : publicMethods) {
            System.out.println(publicMethod.getName());
        }
    }

    @Test
    public void invoke() {
        TestClass testClass1 = ReflectionUtils.newInstance(TestClass.class);
        Method[] publicMethods = ReflectionUtils.getPublicMethods(TestClass.class);
        Object hhhh = ReflectionUtils.invoke(testClass1, publicMethods[0], "hhhh");
        assertEquals("hhhh",hhhh);
    }
}