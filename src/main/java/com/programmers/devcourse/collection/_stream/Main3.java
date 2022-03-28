package com.programmers.devcourse.collection._stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Stream;

public class Main3 {

    static final int LOOP = 100;

    public static void main(String[] args) {
        Random random = new Random();
        Stream.generate(() -> random.nextInt(6) + 1)
            .limit(LOOP).filter(val -> val == 6).forEach(val -> System.out.print(val + " "));

        //NOTe : 0~200사이 값중에서 랜던한 5개를 내림차순 정렬
        int[] arrs = Stream.generate(() -> random.nextInt(200))
            .limit(5)
            .sorted(Comparator.reverseOrder())
            .mapToInt(val -> val)
            .toArray();
        newLine();
        System.out.println(Arrays.toString(arrs));

    }
    public static void newLine(){
        System.out.println();
    }

}
