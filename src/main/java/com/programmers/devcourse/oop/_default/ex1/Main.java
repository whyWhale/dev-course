package com.programmers.devcourse.oop._default.ex1;


interface MyInterface {

  // NOTE : 구현이 없어서 추상 메소드
  void method1();

  // NOTE : 구현이 있어서 디폴트 메소드 java8 이상 부터
  default void method2() {
    System.out.println("<DEFAULT METHOD> MyInterface.method2");
  }
}

public class Main implements MyInterface{

  public static void main(String[] args) {
    Main main = new Main();
    main.method1();
    main.method2();

    Service service = new Service();
    service.method1();
  }

  public void method2(){
    System.out.println("Main.method2");
  }
  @Override
  public void method1() {
    System.out.println("MyInterface inner method impl : Main.method1 ");
  }
}
