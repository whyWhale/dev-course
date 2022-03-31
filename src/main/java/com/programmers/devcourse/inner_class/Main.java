package com.programmers.devcourse.inner_class;

import com.programmers.devcourse.inner_class.ex2.Car;

public class Main {

    public static void main(String[] args) {

        Car mazda = new Car("Mazda", "8WD");
        Car.Engine engine = mazda.new Engine();
        engine.setEngineType();

        System.out.println("8WD engine : "+engine.getEngineType());

        Car car2 = new Car("Crysler", "4WD");
        Car.Engine c2engine = car2.new Engine();
        c2engine.setEngineType();
        System.out.println("4WD engine : "+c2engine.getEngineType());

    }


}


/**
 * 오늘 계산기는 입력 유효성은 단순하게 가져가고 테스트코드 작성해서 Push 완료했습니다.
 * 스트림 실습을 조금 진행했습니다.
 * inner class , static inner 클래스 문서 읽고 실습해보았습니다.
 * 데이터베이스 강의는 현재 2강 정도 남아서 듣고 있고 계속 들을 예정입니다!
 */
