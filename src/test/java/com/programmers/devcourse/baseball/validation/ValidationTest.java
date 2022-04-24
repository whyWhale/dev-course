package com.programmers.devcourse.baseball.validation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.programmers.devcourse.baseball.custom.validation.BaseBallValidationImpl;
import com.programmers.devcourse.baseball.custom.validation.InputValidation;

public class ValidationTest {

	private Faker faker;
	private InputValidation validation;

	@BeforeEach
	public void init() {
		validation = new BaseBallValidationImpl();
		faker = new Faker();
	}

	@Test
	@DisplayName("0을 포함하지 않고 고유한 3자리 숫자 입력 유효성 검증")
	void checkValidation() {

		//given
		List<String> DemoDataSets = Stream.generate(() -> {
					StringBuilder numbers = new StringBuilder();

					Stream.generate(() -> faker.number().randomDigitNotZero())
							.distinct()
							.limit(3)
							.map(String::valueOf)
							.forEach(numbers::append);

					return numbers.toString();
				})
				.limit(10)
				.collect(Collectors.toList());

		// when, then
		DemoDataSets.forEach(value -> {
			Assertions.assertTrue(validation.isValidInput(value));
		});

	}

	@Test
	@DisplayName("숫자가 4자릿수일 때 실패 코드")
	void CheckValidationFalse1() {

		//given
		List<String> DemoDataSets = Stream.generate(() -> {
					StringBuilder numbers = new StringBuilder();

					Stream.generate(() -> faker.number().randomDigitNotZero())
							.distinct()
							.limit(4)
							.map(String::valueOf)
							.forEach(numbers::append);

					return numbers.toString();
				})
				.limit(10)
				.collect(Collectors.toList());

		//when, then
		DemoDataSets.forEach(value -> {
			Assertions.assertThrows(RuntimeException.class, () -> validation.isValidInput(value));
		});
	}

	@Test
	@DisplayName("고유한 숫자가 아닐 때 실패 코드")
	void CheckValidationFalse2() {

		//given
		List<String> DemoDataSets = Stream.generate(() -> {
					StringBuilder numbers = new StringBuilder();

					Stream.generate(() -> faker.number().numberBetween(1, 2))
							.limit(3)
							.map(String::valueOf)
							.forEach(numbers::append);

					return numbers.toString();
				})
				.limit(10)
				.collect(Collectors.toList());

		//when, then
		DemoDataSets.forEach(value -> {
			System.out.println(value);
			Assertions.assertThrows(RuntimeException.class, () -> validation.isValidInput(value));
		});
	}

	@Test
	@DisplayName("0이 포함될 떄 실패 코드")
	void CheckValidationFalse3() {

		//given
		List<String> DemoDataSets = Stream.generate(() -> {
					StringBuilder numbers = new StringBuilder();
					numbers.append(0);
					Stream.generate(() -> faker.number().randomDigitNotZero())
							.limit(2)
							.map(String::valueOf)
							.forEach(numbers::append);

					return numbers.toString();
				})
				.limit(10)
				.collect(Collectors.toList());

		//when, then
		DemoDataSets.forEach(value -> {
			System.out.println(value);
			Assertions.assertThrows(RuntimeException.class, () -> validation.isValidInput(value));
		});
	}
}
