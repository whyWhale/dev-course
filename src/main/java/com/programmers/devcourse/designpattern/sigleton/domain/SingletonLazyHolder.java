package com.programmers.devcourse.designpattern.sigleton.domain;

public class SingletonLazyHolder {

    private SingletonLazyHolder() {
    }

    public static class LazyHolder {

        private static SingletonLazyHolder instance = new SingletonLazyHolder();

    }

    public static SingletonLazyHolder getInstance() {
        return LazyHolder.instance;
    }
}

