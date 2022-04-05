package com.programmers.devcourse.baseball.model;

import java.util.function.BiConsumer;

public class Numbers {
	private final Integer[] numbers;

	public Numbers(Integer[] numbers) {
		this.numbers = numbers;
	}

	public Integer[] getNumbers() {
		return numbers;
	}

	public void indexedForEach(BiConsumer<Integer,Integer> biConsumer){
		for (int index = 0; index < numbers.length; index++) {
			biConsumer.accept(numbers[index],index);
		}
	}
}
