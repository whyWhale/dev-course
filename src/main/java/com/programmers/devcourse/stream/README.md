
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
- 가공한 스트림을 가지고 사용할 결과값을 만들어내는 단계이다.
- 스트림의 최종 작업이다.

### calculating
- count()
- sum()
- min()
- max()
- average()

### Reduction
- 3가지 파라미터
  1. accumulator : 각 요소를 처리하는 계산 로직. 각 요소가 올 때마다 중간 결과를 생성하는 로직.
  2. identity : 계산을 위한 초기값으로 스트림이 비어서 계산할 내용이 없더라도 이 값은 리턴.
  3. combiner : 병렬(parallel) 스트림에서 나눠 계산한 결과를 하나로 합치는 동작하는 로직.

```java
// 1개 (accumulator)
Optional<T> reduce(BinaryOperator<T> accumulator);

// 2개 (identity)
T reduce(T identity, BinaryOperator<T> accumulator);

// 3개 (combiner)
<U> U reduce(U identity,
  BiFunction<U, ? super T, U> accumulator,
  BinaryOperator<U> combiner);
```

- 인자가 1하나만 있는 경우, BinaryOperator\<T> 는 같은 타입의 인자 두개를 받아 같은 타입의 결과를 반화는 함수형 인터페이스이다.
- 인자가 두개인 경우 초기값을 설정하여 BinaryOperator\<T> 결과를 반화하도록 한다.
- 인자가 세게의 경우 Combiner를 포함하여 연산을 하는데 초기값에 각각의 쓰레드가 나뉘어서 계산 결과를 반환하고 마지막에 합치는 역할이다.


```java
// 인자가 1개 일떄.
		OptionalInt reduce = IntStream.range(1, 5)
				.reduce((a, b) -> a + b);
		reduce.ifPresent((val) -> System.out.println(val));

		// 인자가 2개일때
		int reduce1 = IntStream.range(1, 5)
				.reduce(10, (a, b) -> a + b);
		System.out.println("reduce1 = " + reduce1);

		// 인자가 3개일때 : combiner는 병렬 처리시 각각의 쓰레드에서 실행한 결과를 마지막에 합친다.
		Integer reduceParallel = IntStream.range(1, 5)
				.boxed()
				.parallel()
				.reduce(10, (a, b) -> a + b,
						(a, b) -> {
							System.out.println("combiner calling...");
							return a + b;
						});
		System.out.println(reduceParallel);
```

- 병렬 스트림이 무조건 시퀀셜보다 좋은것이 아니다. 오히려 간단한 경우에는 이렇게 부가적인 처리가 필요하므로 느릴수 있다.


### Collecting
- Collectors.joining()
  - 스트림에서 작업한 결과를 하나의 스트링으로 이어 붙일 수 있음.
- Collectors.averageingInt()
  - 숫자값의 평균치 내기
- Collector.summingInt()
  - collect(Collectors.summingInt(${객체 숫자값}))
  - mapToInt(${객체 숫자값}).sum()
- Collectors.summarizingInt()
  - 합계와 평균 정보 한꺼번에 구하기
  - IntSummaryStatistics 객체 정보
    - `IntSummaryStatistics {count=5, sum=86, min=13, average=17.200000, max=23}`
      - 개수 getCount()
      - 합계 getSum()
      - 평균 getAverage()
      - 최소 getMin()
      - 최대 getMax()

- **👉 collect 전에 이런 통계 작업을 위한 map 을 호출할 필요가 없게 됩니다. averaging, summing, summarizing 메소드는 각 기본 타입(int, long, double)별로 제공**


### Collectors.groupingBy()
- 특정 조건으로 요소들을 그룹 지울 수 있다.
- Funtion 인터페이스 사용.

### Collectors.partitioningBy()
- partitioningBy 은 함수형 인터페이스 Predicate 를 받는다.
- Predicate 는 인자를 받아서 boolean 값을 리턴함.
- groupingBy와 같은 map 구조를 반환한다.


### Collectors.collectingAndThen()
- 특정 타입으로 결과를 collect한 이후 추가 작업이 필요한 경우에 사용.
- 이 메소드의 시그니처는 finisher이 추가된 것이며 해당 피니셔는 collect를 한 후에 다음 작업을 의미


### Matching
- Predicate을 받아서 해당 조건을 만족하는 요소가 있는지 체크한 결과를 리턴한다.
  - 하나라도 조건을 만족하는 요소가 있는지(anyMatch)
  - 모두 조건을 만족하는지(allMatch)
  - 모두 조건을 만족하지 않는지(noneMatch)
  - 