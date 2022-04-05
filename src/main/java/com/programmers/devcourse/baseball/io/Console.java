package com.programmers.devcourse.baseball.io;

import java.util.Scanner;

import com.programmers.devcourse.baseball.model.BallCount;

public class Console implements Input, Output {

	static final Scanner scaner = new Scanner(System.in);

	@Override
	public String readInput(String message) {
		System.out.println(message);
		return scaner.nextLine();
	}

	@Override
	public void ballCount(BallCount ballCount) {
		System.out.println(ballCount.toString());
	}

	@Override
	public void inputError() {
		System.out.println("입력 오류입니다. 다시 입력해주세요.!");
	}

	@Override
	public void correct() {
		System.out.println("정답입니다!\n게임을 종료합니다.");
	}
}
