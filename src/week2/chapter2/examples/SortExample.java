package week2.chapter2.examples;

import java.util.Arrays;

public class SortExample {

	public static void main(String[] args) {
		Student[] ss = { new Student("s1", 56), new Student("s2", 10), new Student("s3", 53) };

		Sort.sort(ss);
		Arrays.stream(ss).forEach(System.out::println);
	}
}