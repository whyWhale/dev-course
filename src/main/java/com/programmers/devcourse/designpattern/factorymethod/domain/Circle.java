package com.programmers.devcourse.designpattern.factorymethod.domain;

import com.programmers.devcourse.designpattern.factorymethod.enums.ShapeType;
import com.programmers.devcourse.designpattern.factorymethod.ifs.Shape;

public class Circle implements Shape {

  private Circle() {
  }

  private static class LazyHolder {

    private static final Circle INSTANCE = new Circle();
  }

  public static Circle getInstance() {
    return LazyHolder.INSTANCE;
  }

  @Override
  public void draw() {
    System.out.println("Circle.draw");
  }

  @Override
  public ShapeType getType() {
    return ShapeType.CIRCLE;
  }
}
