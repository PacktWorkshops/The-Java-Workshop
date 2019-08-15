package com.packtpub.reflection;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

public class ConstructorInfo {

    public static void extractConstructors(Class c) {

        List<Constructor> constructors =
                Arrays.asList( c.getDeclaredConstructors() );

        System.out.println( c.getSimpleName() );
        for( Constructor con : constructors ) {
            System.out.println( "   " + con.toGenericString() );
        }
    }

    public static void main(String[] args) {
        extractConstructors(ClassInfo.class);
        extractConstructors(SiberianTiger.class);
        extractConstructors(Pets.class);
        extractConstructors(Animal.class);
        extractConstructors(java.lang.String.class);
    }
}
