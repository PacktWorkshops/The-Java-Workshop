package com.packtpub.reflection;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class MethodInfo {
    public static void extractMethods(Class c) {

        List<Method> methods = Arrays.asList( c.getMethods() );

        System.out.println( c.getSimpleName() );

        for( Method method : methods ) {
            System.out.println( "   " + method.toGenericString() );
        }
    }
    public static void main(String[] args) {
        extractMethods(SiberianTiger.class);
        extractMethods(Pets.class);
        extractMethods(Animal.class);
        extractMethods(java.lang.Object.class);
        extractMethods(java.lang.StringBuilder.class);
    }
}
