package com.programmers.devcourse.baseball.dto;

public class JudgementDto {
	private final int strike;
	private final int ball;

	public JudgementDto(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public String getJudgementResult() {
		return "strike=" + strike + ", ball=" + ball;
	}

	public boolean is3Strike() {
		return strike == 3;
	}

}
