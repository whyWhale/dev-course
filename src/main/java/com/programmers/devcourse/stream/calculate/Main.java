package com.programmers.devcourse.stream.calculate;

import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.github.javafaker.Faker;

public class Main {
	public static void main(String[] args) {
		// todo : 결과 만들기

		// note : calculating
		long count = IntStream.of(1, 3, 5, 7, 8).count();
		System.out.println("count = " + count);

		long count2 = IntStream.of().count();
		System.out.println("count2 = " + count2);

		long sum = IntStream.of(1, 3, 5, 7, 8).sum();
		System.out.println("sum = " + sum);

		long sum2 = IntStream.of().sum();
		System.out.println("sum2 = " + sum2);

		DoubleStream.of(1.1, 2.2, 3.3, 4.4, 5.5)
				.average()
				.ifPresent(System.out::println);

		//note : reduction

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

		// collector
		List<User> users = getDemoUserData();

		// joining
		String everyUserName = users.stream()
				.map(user -> user.getName())
				.collect(Collectors.joining(",", "<", ">"));
		System.out.println("everyUserName = " + everyUserName);

		// sum
		Integer summary1 = users.stream()
				.collect(Collectors.summingInt(User::getScore));
		System.out.println("summary1 = " + summary1);

		int summary2 = users.stream()
				.mapToInt(user -> user.getScore())
				.sum();
		System.out.println("summary2 = " + summary2);

		// average
		Double average = users.stream()
				.collect(Collectors.averagingInt(User::getId));
		System.out.println("average = " + average);

		// summarizingint()
		IntSummaryStatistics collect = users.stream()
				.collect(Collectors.summarizingInt(User::getId));
		System.out.println("collect.toString() = " + collect.toString());

		// groupingBy

		Map<Integer, List<User>> mapGrupingById = users.stream()
				.collect(Collectors.groupingBy(User::getId));

		System.out.println("groupingBy");
		mapGrupingById.forEach((key, val) -> {
			System.out.print("key = " + key);
			System.out.print(" val = " + val);
			System.out.println();
		});
		getNewLine();

		System.out.println("user score grater than 20");
		Map<Boolean, List<User>> mapPartitionByScore = users.stream()
				.collect(Collectors.partitioningBy(user -> user.getScore() > 20));
		mapPartitionByScore
				.forEach((key, value) -> System.out.println(key + " , " + value));
		getNewLine();
		Set<User> sets = users.stream()
				.collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
		sets.forEach(val -> System.out.println(val));
		getNewLine();

		// match
		boolean isExistByScore100 = users.stream()
				.anyMatch(user -> user.getScore() == 100);
		System.out.println(isExistByScore100);
		getNewLine();

		boolean isAllScoreGraterThan1 = users.stream()
				.allMatch(user -> user.getScore() > 1);
		System.out.println(isAllScoreGraterThan1);
		getNewLine();

		boolean isAllLessThan100 = users.stream()
				.noneMatch(user -> user.getScore() < 1);
		System.out.println(isAllLessThan100);
		getNewLine();

	}

	public static void getNewLine() {
		System.out.println("====END====");
	}

	public static List<User> getDemoUserData() {
		Faker faker = new Faker();
		AtomicInteger atomicInteger = new AtomicInteger();
		return Stream.generate(() -> {
					return new User(atomicInteger.incrementAndGet(), faker.name().username().toString(),
							faker.number().numberBetween(1, 100));
				}).limit(10)
				.collect(Collectors.toList());
	}
}

class User {
	private final int id;
	private final String name;
	private final int score;

	public User(int id, String name, int score) {
		this.id = id;
		this.name = name;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", score=" + score +
				'}';
	}
}
