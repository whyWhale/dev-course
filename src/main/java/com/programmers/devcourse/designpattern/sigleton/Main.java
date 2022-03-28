package com.programmers.devcourse.designpattern.sigleton;


import com.programmers.devcourse.designpattern.sigleton.domain.EagerSingleton;
import com.programmers.devcourse.designpattern.sigleton.domain.SingletonLazyHolder;

public class Main {

    public static void main(String[] args) {
        /**
        NOTE : class Load test
        what := singleton class Loader Test compile or runtime
        result := [1.143s][info][class,load] com.programmers.devcourse.designpattern.sigleton.domain.EagerSingleton source: file:/xxxx/xxx/x/x//....
        EagerSingleton.loadTest() 정적 메소드 호출 시 로드됨 확인 := instance 를 생성하지도 않았지만 자동 로드!
        */

        /**
         * NOTE : LazyHolder test
         * what : 클래스의 내부의 클래스는 외부의 클래스가 초기화될때 초기화되지 않고, 클래스의 static 변수는 클래스를 로딩할 때 초기화되는 것을 이용한 기법이다.
         * result :  Class 를 로딩하고 초기화하는건 JVM 의 영역이고 Thread Safe 를 보장한다.
         * SingletonLazyHolder.getInstance();
         */

    }

    public void loadingTest(){
        EagerSingleton.getInstance();
    }
}
