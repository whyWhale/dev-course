package com.programmers.devcourse.designpattern.proxy.virtual_proxy.domain;

public class RealImage implements Image {

    private final String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading Image ...  " + fileName);
    }

    @Override
    public void displayName() {
        System.out.println("Display image :" + fileName);
    }
}
