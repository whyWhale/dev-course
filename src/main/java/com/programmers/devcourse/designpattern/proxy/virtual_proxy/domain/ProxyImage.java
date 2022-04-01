package com.programmers.devcourse.designpattern.proxy.virtual_proxy.domain;

public class ProxyImage implements Image {

    private final String fileName;
    private Image image;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void displayName() {
        if (image == null) {
            image = new RealImage(fileName);
        }
        image.displayName();
    }
}
