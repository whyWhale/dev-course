# Inner(Nested) Class


## Non-Static Nested Class(Inner Class)


---


**특징**

- outer class 멤버에 접근 가능하다.
- 무조건 외부 클래스를 인스턴스화 해야한다. 

**주의할점**

- nested class 에 접근하기 위해 outer class를 반드시 인스턴스화 해야함을 인지하라.
- 내부클래스에서 outer class를 접근하기 위해서는 ${outerClassName}.this.${member-variable}로 접근한다.
  - why?
    - inner class 에서 this를 가르키게 되면 outer class 멤버 변수에 접근 할 수 없다.
      - this는 내부 클래스를 가르킨다.
    - **outer class의 멤버 변수 또는 메소드가 `private` 임에도 불구하고 접근할 수 있음에 유의하라.**



## Static Nested Class

---

**특징**

- static inner class 는 inner class 와는 다르게 outer class의 멤버 변수에 접근할 수 없다.
  - why?
    - static nested class 에서는 외부 클래스의 인스턴스를 만들 필요가 없기 때문이다.
    - 외부 클래스의 객체를 사용하여 내부 클래스의 객체를 생성하지 않기 때문에 ${outerClass}.this 에 저장된 outer class 에 대한 참조가 없다.
  - 외부 클래스의 클래스 이름을 사용하여 정적 중첩 클래스의 객체를 생성한다.
  - 따라서 OuterClass.this 를 사용하여 외부 클래스를 참조할 수 없다.



### summary
- java는 내부 클래스를 클래스의 일반 멤버로 취급하며, 클래스 내부에 선언된 변수와 메소드와 같다.
- 비정적 중첩 내부 클래스는 외부 클래스의 구성원으로서 일반 클래스에는 불가능한 private, protected 접근 제약이 걸려있는 것들에 대해서 엑세스 가능하다.
- 내부 클래스는 바깥쪽 클래스의 멤버이므로 dot(`dot`) 표현으로 중첩 클래스 또는 멤버에 접근이 가능하다. 
- 중첩 클래스를 사용하면 코드의 가독성이 좋아지며 더 나은 캡슐화를 제공할 수 있다.



```text
ref :  https://www.programiz.com/java-programming/nested-inner-class
```