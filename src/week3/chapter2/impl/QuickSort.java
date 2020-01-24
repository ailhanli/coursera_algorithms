package week3.chapter2.impl;

import static week3.chapter2.impl.Partition.partition;

import java.util.Arrays;
import java.util.Comparator;

public class QuickSort {

	public static <T> void sort(T[] data, Comparator<T> comp) {
		sort(data, comp, 0, data.length - 1);
	}

	public static <T> void sort(T[] data, Comparator<T> comp, int low, int high) {

		if (low >= high) {
			return;
		}

		int j = partition(data, comp, low, high);

		sort(data, comp, low, j - 1);
		sort(data, comp, j + 1, high);
	}

	public static void main(String[] args) {
		Character[] data = {'A', 'B', 'D', 'U', 'L', 'L' , 'A', 'H'};
		Comparator<Character> comp = Character::compareTo;
		sort(data, comp);

		System.out.println(Arrays.toString(data));
	}
}