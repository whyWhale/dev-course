package com.programmers.devcourse.oop.functional._interface;

@FunctionalInterface
public interface MyMap {
  // NOTE : 추상으로 된 메서드가 단 하나이므로 := 함수형 인터페이스이다.
  void map();
  default void say(){
    System.out.println("MyMap.say hello");
  }

  static void sayBye(){
    System.out.println("MyMap.sayBye");
  }

}
