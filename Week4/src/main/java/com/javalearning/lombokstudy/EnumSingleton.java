package com.javalearning.lombokstudy;

public enum EnumSingleton {

    INSTANCE;

    private Student instance;

    EnumSingleton()
    {
        instance = new Student();
    }
    public Student getInstance(){
        return instance;
    }
}
