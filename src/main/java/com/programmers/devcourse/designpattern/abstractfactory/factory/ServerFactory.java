package com.programmers.devcourse.designpattern.abstractfactory.factory;

import com.programmers.devcourse.designpattern.abstractfactory.domain.Computer;
import com.programmers.devcourse.designpattern.abstractfactory.domain.Server;

public class ServerFactory implements ComputerAbstractFactory {
  private String cpu;
  private String ram;
  private String hdd;

  public ServerFactory(String cpu, String ram, String hdd) {
    this.cpu = cpu;
    this.ram = ram;
    this.hdd = hdd;
  }

  @Override
  public Computer createComputer() {
    return new Server(cpu,ram, hdd);
  }
}
