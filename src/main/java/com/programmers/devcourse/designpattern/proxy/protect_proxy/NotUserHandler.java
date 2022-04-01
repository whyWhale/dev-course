package com.programmers.devcourse.designpattern.proxy.protect_proxy;

import com.programmers.devcourse.designpattern.proxy.protect_proxy.domain.ProtectionIFS;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NotUserHandler implements InvocationHandler {

        private final static String GET_METHOD_NAME = "get";
        private final static String SET_METHOD_NAME = "set";

        private ProtectionIFS protection;

        public NotUserHandler(ProtectionIFS protection) {
            this.protection = protection;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().startsWith("get")) {
                return method.invoke(protection, args);
            } else if (method.getName().startsWith("set")) {
                System.out.println("접근 권한이 존재하지 않습니다.");
            }
            return null;
    }
}
