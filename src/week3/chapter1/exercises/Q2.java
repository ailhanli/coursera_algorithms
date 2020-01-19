package week3.chapter1.exercises;

import java.util.Arrays;
import java.util.Comparator;

public class Q2 {

	public static void main(String[] args) {
		Integer[] numbers = { 2, 4, 1, 3, 5, 0 };

		// 1 2 4 --1
		// 0 3 5 --1
		// 0 1 2 3 4 5 --1
		count(numbers, Integer::compareTo);

		System.out.println(Arrays.toString(numbers));

		System.out.println(invertCount);
	}

	static int invertCount = 0;

	public static <T> void count(T[] numbers, Comparator<T> c) {
		sort(numbers, 0, numbers.length - 1, c);
	}

	private static <T> void sort(T[] numbers, int low, int high, Comparator<T> c) {
		if (low >= high) {
			return;
		}

		int medium = low + (high - low) / 2;

		sort(numbers, low, medium, c);
		sort(numbers, medium + 1, high, c);

		merge(numbers, low, medium, high, c);
	}

	private static <T> void merge(T[] numbers, int low, int medium, int high, Comparator<T> c) {

		int j = low, k = medium + 1;
		for (int i = low; i <= high; i++) {
			if (k > high) {
				break;
			} else if (c.compare(numbers[k], numbers[j]) < 0) {
				invertCount++;
				k++;
			} else {
				j++;
			}
		}
	}
}