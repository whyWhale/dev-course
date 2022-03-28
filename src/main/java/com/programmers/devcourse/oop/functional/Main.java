package com.programmers.devcourse.oop.functional;

import com.programmers.devcourse.oop.functional._interface.MyRunnable;
import com.programmers.devcourse.oop.functional._interface.MySupply;

public class Main {

  public static void main(String[] args) {

    // NOTE : 익명 클래스를 생성
    String supply = new MySupply() {
      @Override
      public String supply() {
        return "anonymous hello supply";
      }
    }.supply();
    System.out.println(supply);

  }
}

class Greeting implements MySupply {

  @Override
  public String supply() {
    return "hello supply";
  }
}

class Hello implements MyRunnable {

  @Override
  public void run() {
    System.out.println(new Greeting().supply());
    System.out.println("say Hello!! ");
  }
}