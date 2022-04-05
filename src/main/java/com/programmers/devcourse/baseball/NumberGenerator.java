package com.programmers.devcourse.baseball;

import com.programmers.devcourse.baseball.model.Numbers;

/**
 * faker로 의존성이 생기기 때문에.. 다른 방식 택.
 * why : 핵심 비즈니스 로직은 외부 의존성을 안가져 가는 것이 좋다.
 */
public interface NumberGenerator {
	Numbers generate(int count);
}
