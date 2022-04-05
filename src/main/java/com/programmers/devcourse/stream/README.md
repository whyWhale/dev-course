
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
- Filtering
  - 필터(filter)은 스트림 내 요소들을 하나씩 평가해서 걸러내는 작업입니다. 인자로 받는 Predicate 는 boolean 을 리턴하는 함수형 인터페이스로 평가식이 들어가게 됨
```java
  // prdicate 
- Stream<T> filter(Predicate<? super T> predicate);


Stream<String> stream = filter(name -> name.contains("a"));
// [Elena, Java]
```
- Mapping
  - map은 스트림 내 요소들을 하나씩 특정 값으로 변환해준다.
  - 이 때 값을 변환하기 위한 람다를 인자로 받는다.
  - 스트림에 들어가 있는 값이 input이 되어 특정 로직을 거친 후 output 되어 리턴되어 새로운 스트림에 담기게 된다.
  - flatMap이라는 것도 존재하는데, 인자로 mapper를 받고 있는데 리턴 타입이 stream이 이다.
    - 즉 새로운 스트림을 생성해서 리턴하는 람다를 넘겨야 하고 flatMap은 중첩 구조를 한 단계 제거하고 단일 컬렉션으로 만들어 주는 역할을 한다.
    - [flatmap 이해](https://dev-kani.tistory.com/33)
```java
  <R> Stream<R> map(Function<? super T, ? extends R> mapper);

  Stream<String> stream =
  names.stream()
  .map(String::toUpperCase);
  
  // flatmap
  List<List<String>> list =
  Arrays.asList(Arrays.asList("a"),
  Arrays.asList("b"));
  
  // flatmap result
  List<String> flatList = 
    list.stream()
    .flatMap(Collection::stream)
    .collect(Collectors.toList());  
``` 
- Sorting
  - 정렬의 방법은 다른 정렬과 마찬가지로 Comparator 를 이용.
  - Comparator 람다 가능


- Iterating
  - 스트림 내 요소들 각각을 대상으로 특정 연산을 수행하는 메소드로는 peek 이 있습니다. `peek` 은 그냥 확인해본다는 단어 뜻처럼 특정 결과를 반환하지 않는 함수형 인터페이스 Consumer 를 인자로 받습니다.
  - 따라서 스트림 내 요소들 각각에 특정 작업을 수행할 뿐 결과에 영향을 미치지 않는다! . 
  - 다음처럼 작업을 처리하는 중간에 결과를 확인해볼 때 사용할 수 있음.

```java
  Stream<T> peek(Consumer<? super T> action);


  int sum = IntStream.of(1, 3, 5, 7, 9)
  .peek(System.out::println)
  .sum();

    //    1
    //    3
    //    5     //    7
    //    9
    //    25
```
- 따라서 스트림 내 요소들 각각에 특정 작업을 수행할 뿐 결과에 영향을 미치지 않습니다. 다음처럼 작업을 처리하는 중간에 결과를 확인해볼 때 사용할 수 있습니다.



## 결과

---
- 🌕 ready..