package com.programmers.devcourse.baseball.javaFake;

import com.github.javafaker.Faker;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Faker faker = new Faker();
        Arrays.stream(Stream.generate(() -> faker.number().randomDigitNotZero())
            .distinct()
            .limit(5)
            .toArray(Integer[]::new)).forEach(val -> System.out.print(val + " "));
        getNewLine();

    }

    public static void getNewLine() {
        System.out.println();
    }

}
