package com.programmers.devcourse.oop.polymorphism;

import com.programmers.devcourse.oop.polymorphism._implements.KakaoLogin;
import com.programmers.devcourse.oop.polymorphism._implements.NaverLogin;
import com.programmers.devcourse.oop.polymorphism._interface.Login;
import java.util.*;

public class Main {

  private final List<Login> loginList;

  public Main() {
    loginList=new ArrayList<>();
    loginList.add(new KakaoLogin());
    loginList.add(new NaverLogin());
  }

  public static void main(String[] args) {
    Main main = new Main();

    UserService userService = new UserService(new KakaoLogin());
    userService.login();
    UserService userService1 = new UserService(new NaverLogin());
    userService1.login();
  }

  private Login getLogin(LoginType type) {
      return loginList.stream().filter(login -> login.getType()==type).findAny().orElseThrow(()-> new RuntimeException("resource not found !"));
  }
}
