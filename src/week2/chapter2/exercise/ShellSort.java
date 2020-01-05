package week2.chapter2.exercise;

import java.util.Arrays;

import week2.chapter2.examples.Sort;

public class ShellSort {

	public static void sort(Comparable[] data) {

		int h = 1;
		while (h < data.length / 3) {
			h = h * 3 + 1;
		}

		while (h > 0) {
			for (int i = h; i < data.length; i++) {
				for (int j = i; j > 0; j = j - h) {
					if (Sort.less(data[j], data[j - h])) {
						Sort.exchage(data, j, j - h);
					} else {
						break;
					}
				}
			}
			h /= 3;
		}
	}

	public static void main(String[] args) {
		Integer[] numbers = { 100, 12, 45, 34, 78, 90, 90, 101, 56, 43 };

		sort(numbers);
		Arrays.stream(numbers).forEach(System.out::println);
	}

}