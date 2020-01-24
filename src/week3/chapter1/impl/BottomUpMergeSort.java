package week3.chapter1.impl;

import java.util.Arrays;
import java.util.Comparator;

public class BottomUpMergeSort {

	public static void main(String[] args) {
		Integer[] numbers = { 7,6,5,4,3,2,1,0,12,10,11 };
		mergeSort(numbers, Integer::compareTo);

		Arrays.stream(numbers).map(String::valueOf).reduce((a,b)->a+" "+b).ifPresent(System.out::println);
	}

	private static<T> void mergeSort(T[] numbers, Comparator<T> comp) {
		@SuppressWarnings("unchecked")
		T[] aux = (T[])new Object[numbers.length];

		int N = numbers.length;
		for (int size = 1; size < N; size = size * 2) {
			System.out.println("size is "+size);
			for (int i = 0; i < N; i += 2 * size) {
				int low = i;
				int high = Math.min((i + (2 * size) - 1), N - 1);
				int mid =low + (high-low)/2;
				
				System.out.println(low+" "+mid+" "+high);
				merge(numbers, aux, low, mid,high, comp);
			}
			System.out.println();
		}
	}

	private static<T> void merge(T[] numbers, T[] aux, int low, int medium, int high, Comparator<T> comp) {

		for (int i = low; i <= high; i++) {
			aux[i]=numbers[i];
		}
		
		int j = low, k = medium + 1;
		for (int i = low; i <= high; i++) {
			if (j > medium) {
				numbers[i] = aux[k++];
			} else if (k > high) {
				numbers[i] = aux[j++];
			} else if (comp.compare(aux[k],aux[j])<0) {
				numbers[i] = aux[k++];
			} else {
				numbers[i] = aux[j++];
			}
		}
	}
}