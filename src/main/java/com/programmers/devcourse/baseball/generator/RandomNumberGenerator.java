package com.programmers.devcourse.baseball.generator;

import java.util.stream.Stream;

import com.github.javafaker.Faker;

public class RandomNumberGenerator {
	private static final Faker faker = new Faker();

	public String generate3Numbers() {
		StringBuilder result = new StringBuilder();

		Stream.generate(() -> faker.number().randomDigitNotZero())
				.distinct()
				.limit(3)
				.forEach(result::append);

		return result.toString();
	}
}
