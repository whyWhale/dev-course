package com.programmers.devcourse.stream.manufacture;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.util.comparator.Comparators;

public class Main {
	public static void main(String[] args) {
		List<String> list = List.of("a", "b", "c", "d");

		// filter
		list.stream().filter(value -> value.contains("a")).forEach(val -> System.out.print(val));
		newLine();
		// mapping
		list.stream().map(String::toUpperCase).forEach(val -> System.out.print(val + " "));
		newLine();

		// flatMap
		List<List<String>> nestedList = Arrays.asList(Arrays.asList("a"), Arrays.asList("b"));
		List<String> flatMap = nestedList.stream().flatMap(str -> str.stream()).collect(Collectors.toList());
		flatMap.stream().forEach(val -> System.out.printf(val + " "));
		newLine();

		// sorting
		IntStream.of(14, 11, 39, 3, 77)
				.sorted()
				.boxed()
				.collect(Collectors.toList())
				.forEach(val -> System.out.printf(val + " "));
		newLine();

		List<String> lang =
				Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");
		newLine();
		// 사전 오름차순
		lang.stream()
				.sorted()
				.forEach(val -> System.out.printf(val + " "));
		newLine();
		// 사전 내림차순
		lang.stream()
				.sorted((a, b) -> b.compareTo(a))
				.forEach(val -> System.out.printf(val + " "));
		newLine();

		// 문자열 길이 오름차순, 사전순 오름차순
		lang.stream()
				.sorted((a, b) -> Comparators.comparable().compare(a.length(), b.length()))
				.forEach(val -> System.out.printf(val + " "));
		newLine();
		// 문자열 길이 내림차순, 사전순 오른차순
		lang.stream()
				.sorted((a, b) -> Comparators.comparable().compare(b.length(), a.length()))
				.forEach(val -> System.out.printf(val + " "));
		newLine();

		int sum = IntStream.of(1, 3, 5, 7, 9)
				.peek(System.out::println)
				.sum();
		System.out.print(sum);
		newLine();
		newLine();
		newLine();
	}

	private static void newLine() {
		System.out.println();
	}
}
