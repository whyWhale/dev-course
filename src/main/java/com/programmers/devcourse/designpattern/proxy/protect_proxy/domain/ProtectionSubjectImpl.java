package com.programmers.devcourse.designpattern.proxy.protect_proxy.domain;

public class ProtectionSubjectImpl implements ProtectionIFS {

    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }
}
