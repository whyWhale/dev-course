package com.programmers.devcourse.baseball.io;

import com.programmers.devcourse.baseball.model.BallCount;

public interface Output {
	void ballCount(BallCount ballCount);

	void inputError();

	void correct();
}
