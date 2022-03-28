package com.programmers.devcourse.oop._default.ex2._interface;

public interface Swimmable {
  default void swim(){
    System.out.println("Swimmable.swim");
  };

}
