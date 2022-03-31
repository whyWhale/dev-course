
stream get used to


## 생성

---
`스트림 인스턴스 생성`


- 배열 | 컬렉션 | 빈 스트림
- Stream.builder() | Stream.generate() |  Stream.iterate()
- primitive type | String | 파일 스트림
- 병렬 스트림 | 스트림 연결하기


### Stream.generate()
- generate 메소드를 이용하면 Supplier<`T`> 에 해당하는 람다로 값을 넣을 수 있습니다. Supplier<T> 는 인자는 없고 리턴값만 있는 함수형 인터페이스죠. 람다에서 리턴하는 값이 들어갑니다.

```java
    public static<T> Stream<T> generate(Supplier<T> s) { ... }
```
- 이 때 생성되는 스트림은 크기가 정해져있지 않고 무한(infinite)하기 때문에 특정 사이즈로 최대 크기를 제한해야 함.

```java
Stream<String> generatedStream = Stream.generate(() -> "a").limit(5);
```
5개의 “a” 스트림이 생성.

### Stream.iterate()
- iterate 메소드를 이용하면 초기값과 해당 값을 다루는 람다를 이용해서 스트림에 들어갈 요소를 만듬.
- 이 방법도 스트림의 사이즈가 무한하기 때문에 특정 사이즈로 제한해야 함.

## 가공

---
- 🌕 ready..
## 결과

---
- 🌕 ready..