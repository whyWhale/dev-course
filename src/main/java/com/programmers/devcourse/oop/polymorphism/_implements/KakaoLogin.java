package com.programmers.devcourse.oop.polymorphism._implements;

import com.programmers.devcourse.oop.polymorphism.LoginType;
import com.programmers.devcourse.oop.polymorphism._interface.Login;

public class KakaoLogin implements Login {

  @Override
  public void login() {
    System.out.println("KakaoLogin.login");
  }

  @Override
  public LoginType getType() {
    return LoginType.KAKAO;
  }


}
