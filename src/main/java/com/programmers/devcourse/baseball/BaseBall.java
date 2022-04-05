package com.programmers.devcourse.baseball;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import com.programmers.devcourse.baseball.io.Input;
import com.programmers.devcourse.baseball.io.Output;
import com.programmers.devcourse.baseball.model.BallCount;
import com.programmers.devcourse.baseball.model.Numbers;

public class BaseBall implements Runnable {
	private static final int FIXED_NUMBER_COUNT = 3;
	private final NumberGenerator generator;
	private final Input input;
	private final Output output;

	public BaseBall(NumberGenerator generator, Input input, Output output) {
		this.generator = generator;
		this.input = input;
		this.output = output;
	}

	@Override
	public void run() {

		Numbers answer = generator.generate(FIXED_NUMBER_COUNT);
		while (true) {
			String inputNumbers = input.readInput("숫자를 입력하세요.");
			Optional<Numbers> numbers = parse(inputNumbers);

			if (numbers.isEmpty()) {
				output.inputError();
				continue;
			}

			BallCount ballCount = ballCount(answer, numbers.get());
			output.ballCount(ballCount);
			if (ballCount.is3Strike()) {
				output.correct();
				break;
			}
		}
	}

	private BallCount ballCount(Numbers answer, Numbers inputNumbers) {
		AtomicInteger strike = new AtomicInteger();
		AtomicInteger ball = new AtomicInteger();
		answer.indexedForEach((answerValue, answerIndex) -> {

			inputNumbers.indexedForEach((inputValue, inputIndex) -> {
				if (answerValue == inputValue && answerIndex == inputIndex) {
					strike.getAndIncrement();
					return;
				} else if (answerValue == inputValue) {
					ball.getAndIncrement();
				}
			});

		});

		return new BallCount(strike.get(), ball.get());
	}

	private Optional<Numbers> parse(String inputNumbers) {
		if (inputNumbers.length() != FIXED_NUMBER_COUNT) {
			return Optional.empty();
		}

		/** what :
		 * 	1.숫자인지
		 * 	2.0보다 큰 숫자들로만 이루어져 있는
		 * 	3.3자리의 고유 숫자로 되어있는지 판단.
		 */
		long count = inputNumbers.chars()
				.filter(Character::isDigit)
				.map(Character::getNumericValue)
				.filter(value -> value > 0)
				.distinct()
				.count();

		if (count != FIXED_NUMBER_COUNT) {
			return Optional.empty();
		}

		return Optional.of(
				new Numbers(
						inputNumbers
								.chars()
								.map(Character::getNumericValue)
								.boxed()
								.toArray(Integer[]::new)
				)
		);
	}

}
