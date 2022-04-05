package com.programmers.devcourse.baseball.referee;

public interface Referee<OUTPUT, INPUT> {

	OUTPUT getJudgement(INPUT input, INPUT answer);
}
