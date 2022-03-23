package com.programmers.devcourse.oop._Lambda;

import com.programmers.devcourse.oop._Lambda._interface.MyConsumer;
import com.programmers.devcourse.oop._Lambda._interface.MyMapper;
import com.programmers.devcourse.oop._Lambda._interface.MyRunnable;
import com.programmers.devcourse.oop._Lambda._interface.MySupplier;

public class Main {

  public static void main(String[] args) {
    System.out.println("====== ex 1 =======");
    // NOTE : 익명 클래스
    new MyRunnable() {
      @Override
      public void run() {
        System.out.println("anonymous run");
      }
    }.run();

    // NOTE : 익명 메소드 := 메소드 이름이 생략 됬다.
    MyRunnable r = () -> {
      System.out.println("lamda run");
      return;
    };
    r.run();

    System.out.println("====== ex 2 =======");
    MySupplier<String> mySupplier = () -> "lamda start run() ";
    MyMapper<String, Integer> mapper = String::length;
    MyConsumer<Integer> consumner = System.out::println;
    MyRunnable runnable = () -> consumner.consume(mapper.map(mySupplier.supply()));
    runnable.run();

    MyMapper<Integer, Integer> sqareMapper = (value) -> value * value;
    MyRunnable runnable1=() -> consumner.consume(sqareMapper.map(mapper.map(mySupplier.supply())));
    runnable1.run();

  }
}
