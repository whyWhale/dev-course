package com.programmers.devcourse.baseball.custom;

import java.io.IOException;

import com.programmers.devcourse.baseball.custom.engine.BaseBallEngine;
import com.programmers.devcourse.baseball.custom.generator.RandomNumberGenerator;
import com.programmers.devcourse.baseball.custom.io.Console;
import com.programmers.devcourse.baseball.custom.referee.BaseBallReferee;
import com.programmers.devcourse.baseball.custom.validation.BaseBallValidationImpl;

public class Main {

	public static void main(String[] args) throws IOException {
		BaseBallEngine baseBallEngine = new BaseBallEngine(new Console(), new BaseBallValidationImpl(),
				new RandomNumberGenerator(),new BaseBallReferee());
		baseBallEngine.start();
	}

}
