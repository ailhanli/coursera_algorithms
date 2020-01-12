package week3.chapter1.examples;

import week2.chapter2.examples.Sort;

public class MergeSort {

	public static void main(String[] args) {
		Integer[] numbers = { 6, 1, 7, 3, 2, 10, 16, 0 };
		mergeSort(numbers);

		Sort.isSorted(numbers);
		
		System.out.println(numbers);
	}

	private static void mergeSort(Comparable[] numbers) {
		Comparable[] aux = new Comparable[numbers.length];
		sort(numbers, aux, 0, numbers.length-1);
	}

	private static void sort(Comparable[] numbers, Comparable[] aux, int low, int high) {
		if (low >= high) {
			return;
		}

		int medium = low + (high - low) / 2;

		sort(numbers, aux, low, medium);
		sort(numbers, aux, medium + 1, high);
		merge(numbers, aux, low, medium, high);
	}

	private static void merge(Comparable[] numbers, Comparable[] aux, int low, int medium, int high) {

		// copy
		for (int i = low; i <=high; i++) {
			aux[i] = numbers[i];
		}

		System.out.println("low: "+low+" high "+high+" medium "+medium);
		// merge
		int a = low, b = medium + 1;
		for (int c = low; c <= high; c++) {
			if (a > medium) {
				numbers[c] = aux[b++];
			} else if (b > high) {
				numbers[c] = aux[a++];
			} else if (Sort.less(aux[b], aux[a])) {
				numbers[c] = aux[b++];
			} else {
				numbers[c] = aux[a++];
			}
		}

	}

}