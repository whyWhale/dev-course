package com.programmers.devcourse.designpattern.abstractfactory.factory;

import com.programmers.devcourse.designpattern.abstractfactory.domain.Computer;
import com.programmers.devcourse.designpattern.abstractfactory.domain.PersonalComputer;

public class PersonalComputerFactory implements ComputerAbstractFactory {

  private String cpu;
  private String ram;
  private String hdd;

  public PersonalComputerFactory(String cpu, String ram, String hdd) {
    this.cpu = cpu;
    this.ram = ram;
    this.hdd = hdd;
  }

  @Override
  public Computer createComputer() {
    return new PersonalComputer(cpu,ram, hdd);
  }
}
