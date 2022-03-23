package com.programmers.devcourse.designpattern.abstractfactory.factory;

import com.programmers.devcourse.designpattern.abstractfactory.domain.Computer;

public class ComputerFactory {

  public static Computer getComputer(ComputerAbstractFactory factory) {
    return factory.createComputer();
  }
}
