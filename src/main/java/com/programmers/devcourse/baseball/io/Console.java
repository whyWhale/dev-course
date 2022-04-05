package com.programmers.devcourse.baseball.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Console implements Input, Output {

	private static final BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));
	private static final BufferedWriter writer = new BufferedWriter(
			new OutputStreamWriter(System.out));

	@Override
	public String read() throws IOException {
		return reader.readLine();
	}

	@Override
	public void print(String message) throws IOException {
		writer.write(message + "\n");
		writer.flush();
		writer.newLine();
	}

}
