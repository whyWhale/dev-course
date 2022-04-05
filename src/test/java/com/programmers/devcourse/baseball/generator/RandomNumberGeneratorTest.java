package com.programmers.devcourse.baseball.generator;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

	private final int FIXED_LENGTH = 3;
	private RandomNumberGenerator randomNumberGenerator;

	@BeforeEach
	void init() {
		randomNumberGenerator = new RandomNumberGenerator();
	}

	@Test
	@DisplayName("랜덤한 3자리 고유 번호 생성하기")
	void generateNumbers() {
		//given
		//when
		Stream.generate(() -> randomNumberGenerator.generate3Numbers())
				.limit(3)
				.forEach(answer -> {
					Set<Integer> numbers = new HashSet<>();
					answer.chars().forEach(numbers::add);
					//then
					Assertions.assertEquals(FIXED_LENGTH, numbers.size());
				});

	}

}