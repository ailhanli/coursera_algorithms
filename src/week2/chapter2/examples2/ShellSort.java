package week2.chapter2.examples2;

import java.util.Arrays;
import java.util.Comparator;

public class ShellSort {

	public static <T> void sort(Object[] data, Comparator c) {
		for (int h = data.length; h > 0; h = h / 2) {
			System.out.println("h is "+h);
			for (int i = h; i < data.length; i++) {
				for (int j = i; j >= h; j=j-h) {
					if (c.compare(data[j],data[j - h])<0) {
						Object temp = data[j];
						data[j] = data[j - 1];
						data[j - 1] = temp;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Integer[] numbers = { 100, 12, 45, 34, 78, 90, 90, 101, 56, 43 };

		Comparator<Integer> c = Integer::compareTo;
		sort(numbers,c);
		Arrays.stream(numbers).forEach(System.out::println);
	}

}