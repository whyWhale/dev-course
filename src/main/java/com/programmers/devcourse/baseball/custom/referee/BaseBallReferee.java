package com.programmers.devcourse.baseball.custom.referee;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.programmers.devcourse.baseball.custom.dto.JudgementDto;

public class BaseBallReferee implements Referee<JudgementDto, String> {

	@Override
	public JudgementDto getJudgement(String input, String answer) {
		List<Integer> inputNumbers = input.chars().boxed().collect(Collectors.toList());
		List<Integer> answerNumbers = answer.chars().boxed().collect(Collectors.toList());

		AtomicInteger strike = new AtomicInteger();
		AtomicInteger ball = new AtomicInteger();

		inputNumbers.forEach(inputValue -> {
			AtomicInteger inputIndex = new AtomicInteger();

			answerNumbers.forEach(answerValue -> {
				AtomicInteger answerIndex = new AtomicInteger();
				if (inputIndex.get() == answerIndex.get() && inputValue.equals(answerValue)) {
					strike.getAndIncrement();
				} else if (inputValue.equals(answerValue)) {
					ball.getAndIncrement();
				}

				answerIndex.getAndIncrement();
			});

			inputIndex.getAndIncrement();
		});

		return new JudgementDto(strike.get(), ball.get());
	}

}
