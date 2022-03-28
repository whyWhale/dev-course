package com.programmers.devcourse.designpattern.sigleton.domain;

public class EagerSingleton {

    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return instance;
    }

    public static void loadTest(){
        System.out.println("load test");
    }
}
