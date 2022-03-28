package com.programmers.devcourse.designpattern.abstractfactory.domain;

public abstract class Computer {
  protected String cpu;
  protected String ram;
  protected String hdd;

  public Computer(String cpu, String ram, String hdd) {
    this.cpu = cpu;
    this.ram = ram;
    this.hdd = hdd;
  }

  public abstract String getCPU();

  public abstract String getRAM();

  public abstract String getHDD();

  @Override
  public String toString() {
    return "CPU : " + this.getCPU() + " RAM : " + this.getRAM() + " HDD : " + this.getHDD();
  }
}
