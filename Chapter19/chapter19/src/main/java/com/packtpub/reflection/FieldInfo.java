package com.packtpub.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class FieldInfo {
    public static void extractFields(Class c) {

        List<Field> fields = Arrays.asList( c.getDeclaredFields() );

        System.out.println( c.getSimpleName() );

        if (fields.size() < 1) {
            System.out.println( "   No fields");
        } else {
            for( Field field : fields ) {
                System.out.println( "   " + field.toGenericString() );
            }
        }
    }

    public static void main(String[] args) {
        extractFields(ClassInfo.class);
        extractFields(SiberianTiger.class);
        extractFields(Pets.class);
        extractFields(Animal.class);
        extractFields(java.lang.String.class);
    }
}
