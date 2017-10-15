package com.javalearning.lombokstudy;

public class DoubleCheckedLockingSingleton {

    private static DoubleCheckedLockingSingleton instance;

    private int i=0;

    private DoubleCheckedLockingSingleton() {
        i++;
    }

    public static DoubleCheckedLockingSingleton getInstance() {

        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                DoubleCheckedLockingSingleton temp = instance;
                if (temp == null) {
                    synchronized (DoubleCheckedLockingSingleton.class) {
                        temp = new DoubleCheckedLockingSingleton();
                    }
                    instance = temp;
                }
            }
        }
        return instance;
    }

    public void Print()
    {
        System.out.println(String.format("i'm DoubleCheckedLockingSingleton,i was initialized %s times",i));
    }
}
