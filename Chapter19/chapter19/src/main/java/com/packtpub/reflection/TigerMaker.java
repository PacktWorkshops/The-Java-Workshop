package com.packtpub.reflection;

import java.lang.reflect.InvocationTargetException;

public class TigerMaker {
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.packtpub.reflection.SiberianTiger");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (c != null) {
            try {
                Object obj = c.getDeclaredConstructor().newInstance();

                SiberianTiger tiger = (SiberianTiger) obj;

                System.out.println("Do tigers burn bright? " +
                        tiger.burnsBright());

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }
}
