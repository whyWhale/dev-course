package com.programmers.devcourse.oop._default.ex2._interface;

public interface Flyable {
  default void fly(){
    System.out.println("Flyable.fly");
  };
}
