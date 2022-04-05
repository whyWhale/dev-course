package com.programmers.devcourse.baseball.custom.referee;

public interface Referee<OUTPUT, INPUT> {

	OUTPUT getJudgement(INPUT input, INPUT answer);
}
