package com.programmers.devcourse.inner_class.ex3;

public class MotherBoard {

    final String model;

    public MotherBoard(String model) {
        this.model = model;
    }

    static class USB {

        int usb2 = 2;
        int usb1 = 1;

        public int getTotalPorts() {
            return usb1 + usb2;
        }
    }

    static class USB_ACCESS_MEMBER_VARIABLE {

        int usb2 = 2;
        int usb1 = 1;

        public int getTotalPorts() {
            /**
             * error : error: non-static variable this cannot be referenced from a static context
             * why ?
             *  - 외부 클래스의 객체를 사용하여 내부 클래스의 객체를 생성하지 않기 때문에 ${outerClass}.this 에 저장된 외부 클래스 마더보드에 대한 참조가 없다.
             if (MotherBoard.this.model.equals("MSI")) {
                return 100;
             }
             */
            return usb1 + usb2;
        }
    }

    public static void main(String[] args) {
        MotherBoard.USB usb = new USB();
        System.out.println(usb.getTotalPorts());
    }
}
