package com.programmers.devcourse.designpattern.proxy.virtual_proxy;

import com.programmers.devcourse.designpattern.proxy.virtual_proxy.domain.ProxyImage;

public class Main {

    public static void main(String[] args) {
        ProxyImage image1 = new ProxyImage("Image1");
        ProxyImage image2 = new ProxyImage("Image2");

        image1.displayName();
        image2.displayName();
    }

}
