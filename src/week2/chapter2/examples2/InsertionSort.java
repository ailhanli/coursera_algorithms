package week2.chapter2.examples2;

import java.util.Arrays;

import week2.chapter2.examples.Sort;
import week2.chapter2.examples.Student;

public class InsertionSort {

	public static void sort(Comparable[] data) {

		for (int i = 0; i < data.length; i++) {
			for (int j = i; j > 0; j--) {
				if (Sort.less(data[j], data[j - 1])) {
					Sort.exchage(data, j, j - 1);
				} else {
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		Student[] ss = { new Student("s1", 56), new Student("s2", 10), new Student("s3", 53) };

		sort(ss);
		Arrays.stream(ss).forEach(System.out::println);
	}

}