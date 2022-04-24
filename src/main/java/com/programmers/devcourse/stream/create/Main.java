package com.programmers.devcourse.stream.create;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] arr = new String[]{
            "A", "B", "C"
        };
        // 전체 배열 스트림
        Stream<String> stream = Arrays.stream(arr);
        // 1 ~ 2 요소 [B,C]
        Stream<String> subStringStream = Arrays.stream(arr, 1, 3);
        // empty stream
        Stream<Object> empty = Stream.empty();
        // stream.builder
        Stream<String> buildStream = Stream.<String>builder()
            .add("A")
            .add("B")
            .add("C")
            .build();
        // genrate() : Supplier<T>
        Stream<String> limit = Stream.generate(() -> "gen").limit(100);

        // iterator() : seed 값 :=초기값
        Stream.iterate(30, (val) -> val * 2).limit(5).forEach(val -> System.out.println(val));

        // primitive type stream
        IntStream.range(1, 5).forEach(val -> System.out.print(val + " "));

        newLine();
        IntStream.rangeClosed(1, 5).forEach(val -> System.out.print(val + " "));
        newLine();

        // boxing 가능
        Stream<Integer> boxed = IntStream.rangeClosed(1, 10).boxed();

        // Random 스트림
        new Random().doubles(3).distinct().forEach(val -> System.out.print(val + " "));
        newLine();

        // note : 문자열 스트링

        // ascii value 출력
        "Stream".chars().forEach(val -> System.out.print(val + " "));
        newLine();

        Pattern.compile(", ").splitAsStream("Eric, Elena, Mike, Java")
            .forEach(val -> System.out.print(val + " "));
        newLine();

        // note : 파일 스트림
        System.out.println(System.getProperty("user.dir")); // 현재 경로
        Files.lines(Paths.get("README.md"), Charset.forName("UTF-8"))
            .forEach(System.out::print);
        newLine();

        // note : 스트림 연결하기
        Stream<String> stream1 = Stream.of("Java", "Scala", "Groovy");
        Stream<String> stream2 = Stream.of("Python", "Go", "Swift");
        Stream.concat(stream1, stream2)
            .forEach(val -> System.out.print(val + " "));
        newLine();

    }

    public static void newLine() {
        System.out.println();
    }

}
