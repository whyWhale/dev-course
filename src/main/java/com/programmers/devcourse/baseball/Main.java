package com.programmers.devcourse.baseball;

import java.util.stream.Stream;

import com.github.javafaker.Faker;
import com.programmers.devcourse.baseball.io.Console;
import com.programmers.devcourse.baseball.model.Numbers;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		Console console = new Console();
		BaseBall baseBall = new BaseBall(main.BaseBallNumberGenerator(), console, console);
		baseBall.run();
	}

	private NumberGenerator BaseBallNumberGenerator() {
		return count -> {
			Faker faker = new Faker();
			return new Numbers(Stream.generate(() -> faker.number().randomDigitNotZero())
					.limit(count)
					.toArray(Integer[]::new)
			);
		};
	}
}
