package week3.chapter1.examples;

import java.util.Comparator;

import week2.chapter2.examples.Sort;

public class MergeSort {

	private static final int CUTOFF = 7;

	public static void main(String[] args) {
		Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7 };
		sort(numbers, (o1,  o2)->1);

		Comparator<Integer> c = Integer::compareTo;
		Sort.isSorted(numbers, c);
	}

	public static <T> void sort(Object[] numbers, Comparator<T> c) {
		Object[] aux = new Object[numbers.length];
		sort(numbers, aux, 0, numbers.length - 1, c);
	}

	private static  void sort(Object[] numbers, Object[] aux, int low, int high, Comparator c) {
		if (low  >= high) {
			return;
		}

		int medium = low + (high - low) / 2;

		sort(numbers, aux, low, medium, c);
		sort(numbers, aux, medium + 1, high, c);

		if (c.compare(numbers[medium], numbers[medium + 1])<0){ // improvement
			return;
		}
		merge(aux, numbers, low, medium, high, c);
	}

	private static  void merge(Object[] numbers, Object[] aux, int low, int medium, int high, Comparator c) {
		int j = low, k = medium + 1;
		for (int i = low; i <= high; i++) {

			if (j > medium) {
				numbers[i] = aux[k++];
			} else if (k > high) {
				numbers[i] = aux[j++];
			} else if (c.compare(aux[k], aux[j])<0) {
				numbers[i] = aux[k++];
			} else {
				numbers[i] = aux[j++];
			}
		}
	}

}