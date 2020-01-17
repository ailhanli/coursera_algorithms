package week2.chapter2.examples;

import java.util.Comparator;

public interface Sort {

	public static void sort(Object[] comparables, Comparator c ) {
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

	public static boolean isSorted(Object[] comps, Comparator c) {
		for (int i = 0; i < comps.length - 1; i++) {
			if (less(c,comps[i], comps[i + 1])) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public static boolean less(Comparator c, Object a, Object b) {
		return c.compare(a, b)==-1;
	}

	public static void exchage(Object[] comps, int i, int j) {
		Object temp = comps[i];
		comps[i] = comps[j];
		comps[j] = temp;
	}
}
