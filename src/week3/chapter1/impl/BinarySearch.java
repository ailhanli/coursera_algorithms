package week3.chapter1.impl;

import java.util.Comparator;

public class BinarySearch {

	public static <T> boolean find(T[] data, T key, Comparator<T> comp) {
		return find(data, key, 0, data.length - 1, comp);
	}

	private static <T> boolean find(T[] data, T key, int i, int j, Comparator<T> comp) {
		if (i >= j) {
			return false;
		}

		int mid = i + (j - i) / 2;
		if (comp.compare(data[mid], key) == 0) {
			return true;
		}

		return find(data, key, i, mid, comp) || find(data, key, mid + 1, j, comp);
	}

	public static void main(String[] args) {

		System.out.println(find(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 7, Integer::compareTo));
	}
}