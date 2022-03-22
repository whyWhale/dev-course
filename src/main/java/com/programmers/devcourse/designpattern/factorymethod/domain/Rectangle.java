package com.programmers.devcourse.designpattern.factorymethod.domain;

import com.programmers.devcourse.designpattern.factorymethod.enums.ShapeType;
import com.programmers.devcourse.designpattern.factorymethod.ifs.Shape;

public class Rectangle implements Shape {

  private Rectangle() {
  }

  private static class LazyHolder {

    private static final Rectangle INSTANCE = new Rectangle();
  }

  public static Rectangle getInstance() {
    return LazyHolder.INSTANCE;
  }

  @Override
  public void draw() {
    System.out.println("Rectangle.draw");
  }

  @Override
  public ShapeType getType() {
    return ShapeType.RECTANGLE;
  }
}
