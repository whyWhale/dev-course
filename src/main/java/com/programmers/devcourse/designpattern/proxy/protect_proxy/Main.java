package com.programmers.devcourse.designpattern.proxy.protect_proxy;

import com.programmers.devcourse.designpattern.proxy.protect_proxy.domain.ProtectionIFS;
import com.programmers.devcourse.designpattern.proxy.protect_proxy.domain.ProtectionSubjectImpl;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {

        ProtectionSubjectImpl protectionSubject = new ProtectionSubjectImpl();

        System.out.println("protection proxy");
        ProtectionIFS userProxy = getProxy(protectionSubject);
        System.out.println(userProxy.getName());
        userProxy.setName("user");
        System.out.println(userProxy.getName());

        System.out.println();

        ProtectionIFS notUserProxy = getNotUserProxy(protectionSubject);
        System.out.println(notUserProxy.getName());
        notUserProxy.setName("user");
        System.out.println(notUserProxy.getName());
    }
    private static ProtectionIFS getProxy(ProtectionIFS protectionIFS) {
        return (ProtectionIFS) Proxy.newProxyInstance(
            protectionIFS.getClass().getClassLoader(),
            protectionIFS.getClass().getInterfaces(),
            new UserHandler(protectionIFS));

    }

    private static ProtectionIFS getNotUserProxy(ProtectionIFS protectionIFS){
        return (ProtectionIFS) Proxy.newProxyInstance(
            protectionIFS.getClass().getClassLoader(),
            protectionIFS.getClass().getInterfaces(),
            new NotUserHandler(protectionIFS));
    }
}
