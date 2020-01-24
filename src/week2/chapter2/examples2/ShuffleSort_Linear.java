package week2.chapter2.examples2;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import week2.chapter2.impl.Sort;

public class ShuffleSort_Linear {

	public static void main(String[] args) {
		Integer[] numbers = IntStream.range(1, 100).mapToObj(Integer::valueOf).toArray(Integer[]::new);

		shuffle(numbers);

		Arrays.stream(numbers).map(String::valueOf).reduce((a, b) -> a + "," + b).ifPresent(System.out::println);
	}

	public static void shuffle(Integer[] numbers) {
		Random r = new Random();
		for (int i = 0; i < numbers.length; i++) {
			Sort.exchage(numbers, i, r.nextInt(i + 1));
		}
	}
}