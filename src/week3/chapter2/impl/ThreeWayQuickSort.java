package week3.chapter2.impl;

import java.util.Arrays;
import java.util.Comparator;

public class ThreeWayQuickSort {

	public static <T> void sort(T[] data, Comparator<T> comp) {
		sort(data, comp, 0, data.length - 1);
	}

	public static <T> void sort(T[] data, Comparator<T> comp, int low, int high) {
		if (low >= high) {
			return;
		}
		
		int lt = Dijaktra3WayPartition.partition(data, comp, low, high);

		sort(data, comp, low, lt-1);
		sort(data, comp, lt+1, high);
	}

	public static void main(String[] args) {
		Character[] chars = {'P', 'A', 'B', 'X', 'W', 'P','P','V','P','D','P','C','Y','Z' };
		Comparator<Character> comp = Character::compareTo;
		sort(chars, comp);

		System.out.println(Arrays.toString(chars));
	}
}