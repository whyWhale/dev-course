package com.programmers.devcourse.designpattern.factorymethod.domain;


import com.programmers.devcourse.designpattern.factorymethod.enums.ShapeType;
import com.programmers.devcourse.designpattern.factorymethod.ifs.Shape;

public class Square implements Shape {

  private Square() {
  }

  private static class LazyHolder {

    private final static Square INSTANCE = new Square();
  }

  public static Square getInstance() {
    return LazyHolder.INSTANCE;
  }

  @Override
  public void draw() {
    System.out.println("Square.draw");
  }

  @Override
  public ShapeType getType() {
    return ShapeType.SQUARE;
  }
}
