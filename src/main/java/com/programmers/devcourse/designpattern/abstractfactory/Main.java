package com.programmers.devcourse.designpattern.abstractfactory;

import com.programmers.devcourse.designpattern.abstractfactory.domain.Computer;
import com.programmers.devcourse.designpattern.abstractfactory.domain.Server;
import com.programmers.devcourse.designpattern.abstractfactory.factory.ComputerFactory;
import com.programmers.devcourse.designpattern.abstractfactory.factory.PersonalComputerFactory;
import com.programmers.devcourse.designpattern.abstractfactory.factory.ServerFactory;

public class Main {

  public static void main(String[] args) {
    Computer pc = ComputerFactory.getComputer(
        new PersonalComputerFactory("2.4GHZ", "2G", "1T"));
    Computer server = ComputerFactory.getComputer(
        new ServerFactory("3.7GHZ", "16G", "1T"));

    System.out.println(" pc spec : " + pc.toString());
    System.out.println(" server spec : " + server.toString());

  }

}
