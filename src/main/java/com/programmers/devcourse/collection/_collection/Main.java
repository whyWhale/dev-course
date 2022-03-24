package com.programmers.devcourse.collection._collection;

import com.programmers.devcourse.collection._collection._interface.MyCollection;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    // NOTE : custom collection
    new MyCollection<>(Arrays.asList(1, 2, 3, 4, 5)).foreach(
        value -> System.out.print(value + " "));
    newLine();
    new MyCollection<>(Arrays.asList("AB", "BC", "CD", "DE", "EF")).foreach(
        value -> System.out.print(value + " "));
    newLine();

    // NOTE : 형 변환 char -> int
    MyCollection<Character> characterMyCollection = new MyCollection<>(
        Arrays.asList('A', 'B', 'C', 'D', 'E'));
    MyCollection<Integer> map = characterMyCollection.map((value) -> value - 0);
    map.foreach((value)-> System.out.print(value + " "));
    newLine();

    // NOTE 짝수 predicate
    map.filter(value -> value % 2 == 0).foreach(value -> System.out.print(value + " "));
    newLine();

    int count = map.filter(value -> value % 2 == 0).count();
    System.out.println(count);

  }

  public static void newLine() {
    System.out.println("");
  }
}
