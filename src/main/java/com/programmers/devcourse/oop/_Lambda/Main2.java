package com.programmers.devcourse.oop._Lambda;

import com.programmers.devcourse.oop._Lambda._interface.MyConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main2 {

  public static void main(String[] args) {
    // NOTE : 이곳이 host, client 쪽이다.

    // NOTE : 매개변수 익명 클래스 호출
    new Main2().loop(10, new MyConsumer<Integer>() {
      @Override
      public void consume(Integer i) {
        System.out.print(i + " ");
      }
    });

    System.out.println();

    // NOTE : 매개변수 Lamda 해당 역할을 뒤로 계속 떠넘겨준다.
    new Main2().loop(10, (value) -> System.out.print(value + " "));
    System.out.println();
    System.out.println("predicate functional interface");

    new Main2().filteredNumber(100,(value)-> value%2==0, (value) ->System.out.print(value +" "));
  }

  void filteredNumber(int max, Predicate<Integer> p, Consumer<Integer> c) {
    for (int i = 0; i < max; i++) {
      if (p.test(i)) {
        c.accept(i);
      }
    }
  }


  void loop(int n, MyConsumer<Integer> consumner) {
    // hint : 입력은 있고 출력은 따로 없어도 된다 := consumer
    for (int i = 0; i < n; i++) {
      // NOTE: 무언가를 해야한다.
      // 변수 i를 주고 무언가를 해라!
      consumner.consume(i);
    }
  }

}
