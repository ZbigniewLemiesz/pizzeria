package com.example.pizzeria.order;

public class Singleton {
    private static Singleton INSTANCE;

    Singleton() {
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) { //operacja kosztowna
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
