package com.programmers.devcourse.oop._Lambda._interface;

@FunctionalInterface
public interface MyMapper<Input, Output> {

  Output map(Input input);
}
