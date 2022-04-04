package com.programmers.devcourse.baseball.validation;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import com.programmers.devcourse.baseball.exception.NotProperNumber;
import com.programmers.devcourse.baseball.exception.NotUniqueNumber;
import com.programmers.devcourse.baseball.utils.RegexUtils;

public class BaseBallValidationImpl implements InputValidation {

	private static final int DEFAULT_NUMBER_OF_IDENTIFICATION = 3;
	private static final Pattern numericPattern = Pattern.compile(
			RegexUtils.getNumericRegexNoneZero()
	);

	@Override
	public boolean isValidInput(String input) {
		if (!isNumericAnd3SizeNumber(input)) {
			throw new NotProperNumber("숫자가 아닌 문자가 포함되었거나 3자리 숫자가 아닙니다.!");
		}

		if (!isDistinctNumeric(input)) {
			throw new NotUniqueNumber("중복된 숫자가 들어가 있습니다.!");
		}

		return true;
	}

	private boolean isNumericAnd3SizeNumber(String input) {
		return numericPattern.matcher(input).matches();
	}

	private boolean isDistinctNumeric(String input) {
		Set<Character> numbers = new HashSet<>();

		input.chars().forEach(value -> numbers.add((char)value));

		return numbers.size() == DEFAULT_NUMBER_OF_IDENTIFICATION;
	}
}
