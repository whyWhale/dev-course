package com.programmers.devcourse.oop._default.ex2.domain;

import com.programmers.devcourse.oop._default.ex2._interface.Swimmable;
import com.programmers.devcourse.oop._default.ex2._interface.Walkable;

public class Duck implements Swimmable, Walkable {

  @Override
  public void swim() {
    System.out.println("Duck.swim");
  }

  @Override
  public void walk() {
    System.out.println("Duck.walk");
  }
}
