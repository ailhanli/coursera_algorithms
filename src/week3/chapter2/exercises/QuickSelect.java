package week3.chapter2.exercises;

import static week3.chapter2.exercises.Partition.partition;

import java.util.Arrays;
import java.util.Comparator;

public class QuickSelect {

	public static <T> T quickselect(T[] data, Comparator<T> comp, int k) {
		return quickselect(data, comp, 0, data.length - 1, k-1);
	}

	public static <T> T quickselect(T[] data, Comparator<T> comp, int low, int high, int k) {

		int j = partition(data, comp, low, high);
		if (k == j) {
			return data[j];
		} else if (k < j) {
			high = j - 1;
		} else {
			low = j + 1;
		}
		return quickselect(data, comp, low, high, k);
	}

	public static void main(String[] args) {
		Integer[] numbers = { 5, 1, 3, 8, 10, 56, 0, -12 };
		Comparator<Integer> comp = Integer::compareTo;
		System.out.println(quickselect(numbers, comp, 2));

		System.out.println(Arrays.toString(numbers));
	}
}