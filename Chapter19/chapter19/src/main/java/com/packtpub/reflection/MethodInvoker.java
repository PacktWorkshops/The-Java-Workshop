package com.packtpub.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class MethodInvoker {
    public static final String NAME = "name";

    public static void main(String[] args) {
        Properties properties = new Properties();

        Method setProp = null;
        try {
            Class c = properties.getClass();

            setProp = c.getMethod("setProperty", String.class, String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        if (setProp != null) {
            try {
                setProp.invoke(properties, NAME, "Bob Marley");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        // See if our property was set.
        System.out.println( properties.getProperty(NAME));

    }
}
