package com.programmers.devcourse.designpattern.factorymethod;

import com.programmers.devcourse.designpattern.factorymethod.enums.ShapeType;
import com.programmers.devcourse.designpattern.factorymethod.factory.ShapeFactory;
import com.programmers.devcourse.designpattern.factorymethod.ifs.Shape;

public class Main {

  public static void main(String[] args) {
    ShapeFactory shapeFactory = new ShapeFactory();
    Shape shape1 = shapeFactory.getShape(ShapeType.CIRCLE);
    Shape shape2 = shapeFactory.getShape(ShapeType.SQUARE);
    Shape shape3 = shapeFactory.getShape(ShapeType.RECTANGLE);

    shape1.draw();
    shape2.draw();
    shape3.draw();
  }
}
