package com.programmers.devcourse.collection._iterator;

import java.util.Arrays;
import java.util.Iterator;

public class Main {

  public static void main(String[] args) {
    Iterator<String> iterator = (Arrays.asList("A", "BD", "dasdasd", "cccc")).iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

}
