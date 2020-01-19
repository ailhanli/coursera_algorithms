package week2.chapter2.examples2;

import java.util.Arrays;
import java.util.Comparator;

import week2.chapter2.examples.Sort;
import week2.chapter2.examples.Student;

public class SelectionSort {

	public static <T> void sort(T[] data, Comparator<T> c) {

		for (int i = 0; i < data.length; i++) {
			int min = i;
			for (int j = i + 1; j < data.length; j++) {
				if (c.compare(data[j], data[min]) < 0) {
					min = j;
				}
			}
			Sort.exchage(data, i, min);
		}
	}

	public static void main(String[] args) {
		Student[] ss = { new Student("s1", 56), new Student("s2", 10), new Student("s3", 53) };

		sort(ss, (s1, s2) -> s1.getAge().compareTo(s2.getAge()));

		Arrays.stream(ss).forEach(System.out::println);
	}

}