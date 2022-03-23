package com.programmers.devcourse.oop._default.ex2.domain;

import com.programmers.devcourse.oop._default.ex2._interface.Flyable;
import com.programmers.devcourse.oop._default.ex2._interface.Swimmable;
import com.programmers.devcourse.oop._default.ex2._interface.Walkable;

public class Swan implements Walkable, Flyable, Swimmable {

  @Override
  public void fly() {
    System.out.println("Swan.fly");
  }

  @Override
  public void walk() {
    System.out.println("Swan.walk");
  }
}
