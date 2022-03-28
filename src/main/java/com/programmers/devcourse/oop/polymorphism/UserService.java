package com.programmers.devcourse.oop.polymorphism;

import com.programmers.devcourse.oop.polymorphism._interface.Login;

public class UserService implements Login {
  // 결합성 naver,kakao 때에 따라 다르다.
  private final Login login;

  /**
   * 구현체가 들어오면 구현체에 대한 행위를 진행할 것이다.
   * 의존성을 외부에 맡긴다면, 의존도율 낮춘다.
   * 결험상 강하게 결합되는데 결과적으로 추상체에 의존하게 되면 결합도가 낮아졌다.
   * 의존성을 외부로 부터 전달받았다라 함은 의존성을 주입받았다 라고 한다. DI
   * @param login
   */
  public UserService(Login login) {
    this.login = login;
  }

  @Override
  public void login() {
    this.login.login();
  }

  @Override
  public LoginType getType() {
    return this.login.getType();
  }
}
