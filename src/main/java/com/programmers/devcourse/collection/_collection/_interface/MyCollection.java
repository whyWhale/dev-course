package com.programmers.devcourse.collection._collection._interface;

import com.programmers.devcourse.collection.iterateor._interface.MyIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyCollection<T> {

  private List<T> list;

  public MyCollection(List<T> list) {
    this.list = list;
  }

  public MyCollection<T> filter(Predicate<T> predicate) {
    List<T> newList = new ArrayList<>();
    foreach((value) -> {
      if (predicate.test(value)) {
        newList.add(value);
      }
    });
    return new MyCollection<>(newList);
  }

  public int count() {
    return list.size();
  }

  public <U> MyCollection<U> map(Function<T, U> function) {
    List<U> newList = new ArrayList<>();
    foreach((value) -> newList.add(function.apply(value)));
    return new MyCollection<>(newList);
  }

  public void foreach(Consumer<T> consumer) {
    for (int i = 0; i < list.size(); i++) {
      T data = list.get(i);
      consumer.accept(data);
    }
  }

  public MyIterator<T> iterator() {
    return new MyIterator<T>() {
      private int index = 0;

      @Override
      public boolean hasNext() {
        return index < list.size();
      }

      @Override
      public T next() {
        return list.get(index++);
      }
    };
  }
}
