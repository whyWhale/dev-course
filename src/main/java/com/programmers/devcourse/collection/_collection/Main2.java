package com.programmers.devcourse.collection._collection;

import com.programmers.devcourse.collection._collection._interface.MyCollection;
import com.programmers.devcourse.collection._collection.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main2 {

  public static void main(String[] args) {
    List<User> list = new ArrayList<>();
    IntStream.range(0, 30).forEach(value -> {
      list.add(new User(String.valueOf(value), value));
    });
    int count = new MyCollection<User>(list)
        .filter(user -> user.getAge() >= 19).count();
    System.out.println(count == 11 ? "accept" : new RuntimeException("test false"));

    new MyCollection<User>(list)
        .filter(user -> user.getAge() >= 19)
        .map(user -> user.getName())
        .foreach(username -> System.out.print(username + " "));

  }

  public void newLine() {
    System.out.println();
  }

}
