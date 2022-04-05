package com.programmers.devcourse.baseball.engine;

import java.io.IOException;

import com.programmers.devcourse.baseball.dto.JudgementDto;
import com.programmers.devcourse.baseball.exception.NotProperNumber;
import com.programmers.devcourse.baseball.exception.NotUniqueNumber;
import com.programmers.devcourse.baseball.generator.RandomNumberGenerator;
import com.programmers.devcourse.baseball.io.Console;
import com.programmers.devcourse.baseball.io.Input;
import com.programmers.devcourse.baseball.io.Output;
import com.programmers.devcourse.baseball.referee.Referee;
import com.programmers.devcourse.baseball.validation.InputValidation;

public class BaseBallEngine {

	private final Input input;
	private final Output output;
	private final InputValidation validation;
	private final Referee<JudgementDto, String> referee;
	private final String answer;

	public BaseBallEngine(Console console, InputValidation inputValidation,
			RandomNumberGenerator randomNumberGenerator,
			Referee<JudgementDto, String> referee) {
		input = console;
		output = console;
		this.referee = referee;
		validation = inputValidation;
		answer = randomNumberGenerator.generate3Numbers();
	}

	public void start() throws IOException {

		while (true) {
			output.print("숫자 3자리를 입력하세요.");

			String readInput = input.read();

			try {
				validation.isValidInput(readInput);
			} catch (NotProperNumber | NotUniqueNumber exception) {
				output.print(exception.getMessage());
				continue;
			}

			JudgementDto judgement = referee.getJudgement(readInput, answer);

			output.print(judgement.getJudgementResult());

			if (judgement.is3Strike()) {
				output.print("정답입니다.!\n게임을 종료합니다. ");
				break;
			}
		}
	}

}
