package com.programmers.devcourse.collection._stream;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Arrays.asList("A", "BDD", "ADSSDA", "CCCCCC")
            .stream().filter(value -> value.length() > 3)
            .forEach(value -> System.out.print(value + " "));


    }
}
