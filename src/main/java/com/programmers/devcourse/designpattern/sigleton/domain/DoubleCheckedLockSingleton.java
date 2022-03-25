package com.programmers.devcourse.designpattern.sigleton.domain;

public class DoubleCheckedLockSingleton {

    private volatile static DoubleCheckedLockSingleton instance;

    private DoubleCheckedLockSingleton() {
    }

    public static DoubleCheckedLockSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockSingleton();
                }
            }
        }
        return instance;
    }
}
