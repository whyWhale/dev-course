package com.programmers.devcourse.designpattern.factorymethod.factory;

import com.programmers.devcourse.designpattern.factorymethod.domain.Circle;
import com.programmers.devcourse.designpattern.factorymethod.domain.Rectangle;
import com.programmers.devcourse.designpattern.factorymethod.domain.Square;
import com.programmers.devcourse.designpattern.factorymethod.enums.ShapeType;
import com.programmers.devcourse.designpattern.factorymethod.ifs.Shape;
import java.util.ArrayList;
import java.util.List;

public class ShapeFactory {

  private final List<Shape> shapes;

  public ShapeFactory() {
    shapes = new ArrayList<>();
    shapes.add(Circle.getInstance());
    shapes.add(Rectangle.getInstance());
    shapes.add(Square.getInstance());
  }

  public Shape getShape(ShapeType type) {
    return shapes.stream().filter(shape -> shape.getType() == type).findAny()
        .orElseThrow(() -> new RuntimeException());
  }

}
