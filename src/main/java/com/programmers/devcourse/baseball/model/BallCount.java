package com.programmers.devcourse.baseball.model;

public class BallCount {
	private final int strike;
	private final int ball;

	public BallCount(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public boolean is3Strike() {
		return this.strike == 3;
	}

	@Override
	public String toString() {
		return "BallCount{" +
				"strike=" + strike +
				", ball=" + ball +
				'}';
	}
}

