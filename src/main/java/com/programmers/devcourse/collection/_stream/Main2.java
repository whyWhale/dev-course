package com.programmers.devcourse.collection._stream;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main2 {

    public static void main(String[] args) {

        Stream<Integer> stream1 = Arrays.asList(1, 2, 3).stream();

        // primitive type을 위한 IntStream type이 존재함 단, 반드시 map() 호출 해야함.
        Arrays.stream(new int[]{1, 2, 3}).boxed().toArray(Integer[]::new);
        // NOTE : 스트림 생성 방법 generate() , iterator()가 있다.
        Stream.generate(() -> 1).limit(10).forEach(value -> System.out.print(value + " "));
        newLine();
        Stream.iterate(0, value -> value + 1).limit(5)
            .forEach(value -> System.out.print(value + " "));

    }

    public static void newLine() {
        System.out.println();
    }
}
