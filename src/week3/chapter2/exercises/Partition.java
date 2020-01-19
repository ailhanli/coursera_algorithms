package week3.chapter2.exercises;

import java.util.Comparator;

public class Partition {
	
	public static <T> int partition(T[] data, Comparator<T> comp, int low, int high) {

		int i = low, j = high+1;
		while (true) {
			while (comp.compare(data[++i], data[low]) < 0) {
				if (i == high) {
					break;
				}
			}
			while (comp.compare(data[--j], data[low]) > 0) {
				if (j == low) {
					break;
				}
			}

			if (i >= j) {
				exchange(data, low, j);
				break;
			}

			exchange(data, i, j);
		}

		return j;
	}

	private static <T> void exchange(T[] data, int low, int j) {
		T temp = data[low];
		data[low] = data[j];
		data[j] = temp;
	}
}