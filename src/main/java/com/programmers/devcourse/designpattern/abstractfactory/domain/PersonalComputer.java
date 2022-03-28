package com.programmers.devcourse.designpattern.abstractfactory.domain;

public class PersonalComputer extends Computer {

  public PersonalComputer(String cpu, String ram, String hdd) {
      super(cpu,ram,hdd);
  }

  @Override
  public String getCPU() {
    return this.cpu;
  }

  @Override
  public String getRAM() {
    return this.ram;
  }

  @Override
  public String getHDD() {
    return this.hdd;
  }
}
