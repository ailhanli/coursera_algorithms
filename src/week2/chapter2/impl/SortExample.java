package week2.chapter2.impl;

import java.util.Arrays;

public class SortExample {

	public static void main(String[] args) {
		Student[] ss = { new Student("s1", 56), new Student("s2", 10), new Student("s3", 53) };

		Sort.sort(ss, (s1,s2)->1);
		Arrays.stream(ss).forEach(System.out::println);
	}
}