package week3.chapter1.impl;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort {

	public static void main(String[] args) {
		Integer[] numbers = { 2, 4, 1, 3, 5 };

		sort(numbers, Integer::compareTo);

		System.out.println(Arrays.toString(numbers));
	}

	public static <T> void sort(T[] numbers, Comparator<T> c) {
		@SuppressWarnings("unchecked")
		T[] aux = (T[]) new Object[numbers.length];
		sort(numbers, aux, 0, numbers.length - 1, c);
	}

	private static <T> void sort(T[] numbers, T[] aux, int low, int high, Comparator<T> c) {
		if (low >= high) {
			return;
		}

		int medium = low + (high - low) / 2;

		sort(numbers, aux, low, medium, c);
		sort(numbers, aux, medium + 1, high, c);

		merge(numbers, aux, low, medium, high, c);
	}

	private static <T> void merge(T[] numbers, T[] aux, int low, int medium, int high, Comparator<T> c) {
		for (int i = low; i <= high; i++) {
			aux[i] = numbers[i];
		}

		int j = low, k = medium + 1;
		for (int i = low; i <= high; i++) {

			if (j > medium) {
				numbers[i] = aux[k++];
			} else if (k > high) {
				numbers[i] = aux[j++];
			} else if (c.compare(aux[k], aux[j]) < 0) {
				numbers[i] = aux[k++];
			} else {
				numbers[i] = aux[j++];
			}
		}
	}
}