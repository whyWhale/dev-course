package com.programmers.devcourse.oop._default.ex2._interface;

public interface Walkable {
  default void walk(){
    System.out.println("Walkable.walk");
  };
}
