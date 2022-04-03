package com.programmers.devcourse.baseball.validation;

import com.github.javafaker.Faker;
import com.programmers.devcourse.baseball.validation.BaseBallValidationImpl;
import com.programmers.devcourse.baseball.validation.InputValidation;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationTest {

    private Faker faker;
    private InputValidation validation;

    @BeforeEach
    public void init() {
        validation = new BaseBallValidationImpl();
        faker = new Faker();
    }

    @DisplayName("0을 포함하지 않는 3자리 숫자 입력 유효성 검증")
    @Test
    void checkValidation() {
        //given
        List<String> DemoDataSets = Stream.generate(() -> {
                StringBuilder numbers = new StringBuilder();

                Stream.generate(() -> faker.number().randomDigitNotZero())
                    .limit(3)
                    .map(String::valueOf)
                    .forEach(numbers::append);

                return numbers.toString();
            })
            .limit(10)
            .collect(Collectors.toList());

        // when, then
        DemoDataSets.forEach(value -> {
            Assertions.assertTrue(validation.isValidInput(value));
        });

    }


    @Test
    @DisplayName("숫자가 4자리 일때 실패 코드")
    public void CheckValidationFalse1() {
        //given
        List<String> DemoDataSets = Stream.generate(() -> {
                StringBuilder numbers = new StringBuilder();

                Stream.generate(() -> faker.number().randomDigitNotZero())
                    .limit(4)
                    .map(String::valueOf)
                    .forEach(numbers::append);

                return numbers.toString();
            })
            .limit(10)
            .collect(Collectors.toList());
        //when, then
        DemoDataSets.forEach(value -> {
            Assertions.assertFalse(validation.isValidInput(value));
        });
    }
}
