package com.programmers.devcourse.inner_class.ex1;

public class CPU {

    double price;

    // what : nested Class
    public class Processor {

        double cores;
        String manuFacturer; // 제조업자

        public double getCache() {
            return 4.3;
        }
    }


    public class RAM {

        double memory;
        String manuFacturer;

        public double getClockSpeed() {
            return 5.5;
        }
    }

}
