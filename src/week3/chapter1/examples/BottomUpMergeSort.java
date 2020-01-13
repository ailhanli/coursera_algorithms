package week3.chapter1.examples;

import week2.chapter2.examples.Sort;

public class BottomUpMergeSort {

	public static void main(String[] args) {
		Integer[] numbers = { 1, 10, 6, 12, 89, 11 };
		mergeSort(numbers);

		Sort.isSorted(numbers);
	}

	private static void mergeSort(Comparable[] numbers) {
		Comparable[] aux = new Comparable[numbers.length];
		int N = numbers.length;

		for (int sz = 1; sz < N; sz = sz + sz) {
			for (int lo = 0; lo < N - sz; lo += sz + sz) {
				merge(aux, numbers, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
			}
		}
	}

	private static void merge(Comparable[] numbers, Comparable[] aux, int low, int medium, int high) {
		
		int j = low, k = medium + 1;
		for (int i = low; i <= high; i++) {
			if (j > medium) {
				numbers[i] = aux[k++];
			} else if (k > high) {
				numbers[i] = aux[j++];
			} else if (aux[k].compareTo(aux[j]) == -1) {
				numbers[i] = aux[k++];
			} else {
				numbers[i] = aux[j++];
			}
		}
	}
}