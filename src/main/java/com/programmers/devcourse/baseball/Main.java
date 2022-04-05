package com.programmers.devcourse.baseball;

import java.io.IOException;

import com.programmers.devcourse.baseball.engine.BaseBallEngine;
import com.programmers.devcourse.baseball.generator.RandomNumberGenerator;
import com.programmers.devcourse.baseball.io.Console;
import com.programmers.devcourse.baseball.referee.BaseBallReferee;
import com.programmers.devcourse.baseball.validation.BaseBallValidationImpl;

public class Main {

	public static void main(String[] args) throws IOException {
		BaseBallEngine baseBallEngine = new BaseBallEngine(new Console(), new BaseBallValidationImpl(),
				new RandomNumberGenerator(),new BaseBallReferee());
		baseBallEngine.start();
	}

}
