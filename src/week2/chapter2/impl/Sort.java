package week2.chapter2.impl;

import java.util.Comparator;

public interface Sort {

	public static <T> void sort(T[] comparables, Comparator<T> c ) {
		if (isSorted(comparables,c)) {
			return;
		}
		for (int i = 0; i < comparables.length; i++) {
			for (int j = i; j > 0; j--) {
				if (less(c,comparables[j], comparables[j - 1])) {
					exchage(comparables, j, j - 1);
				}
			}
		}
	}

	public static <T> boolean isSorted(T[] comps, Comparator<T> c) {
		for (int i = 0; i < comps.length - 1; i++) {
			if (less(c,comps[i], comps[i + 1])) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public static <T> boolean less(Comparator<T>c, T a, T b) {
		return c.compare(a, b)==-1;
	}

	public static void exchage(Object[] comps, int i, int j) {
		Object temp = comps[i];
		comps[i] = comps[j];
		comps[j] = temp;
	}
}
