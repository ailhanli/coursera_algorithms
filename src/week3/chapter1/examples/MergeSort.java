package week3.chapter1.examples;

import week2.chapter2.examples.Sort;
import week2.chapter2.examples2.InsertionSort;

public class MergeSort {

	private static final int CUTOFF = 7;

	public static void main(String[] args) {
		Integer[] numbers = { 1,2,3,4,5,6,7 };
		mergeSort(numbers);

		Sort.isSorted(numbers);
	}

	private static void mergeSort(Comparable[] numbers) {
		Comparable[] aux = new Comparable[numbers.length];
		sort(numbers, aux, 0, numbers.length - 1);
	}

	private static void sort(Comparable[] numbers, Comparable[] aux, int low, int high) {
		if (low+CUTOFF-1 >= high) {
			InsertionSort.sort(numbers);
			return;
		}

		int medium = low + (high - low) / 2;

		sort(numbers, aux, low, medium);
		sort(numbers, aux, medium + 1, high);
		
		if(numbers[high].compareTo(numbers[low])==1){
			return;
		}
		merge(aux, numbers, low, medium, high);
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