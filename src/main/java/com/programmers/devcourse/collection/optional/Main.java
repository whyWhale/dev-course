package com.programmers.devcourse.collection.optional;

import com.programmers.devcourse.collection._collection.domain.User;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Optional<User> empty = Optional.empty();
        Optional<User> kim = Optional.of(new User("kim", 100));

        empty.ifPresent(System.out::println);
        kim.ifPresentOrElse(System.out::println, () -> System.out.println("NPE"));
    }

}
