package com.programmers.devcourse.oop._default.ex1;

/**
 * method2는 사용을 안할건이라 함은 이렇게 써야한다.
 * 이것이 Adapter pattern 이다.
 * 내가 사용하고 싶은 것만 골라서 쓴다.
 */
public class Service extends MyAdapter{

  @Override
  public void method1() {
    System.out.println("Service.method1");
  }
}
