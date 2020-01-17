package week2.chapter2.examples2;

import java.util.Arrays;
import java.util.Comparator;

import week2.chapter2.examples.Sort;
import week2.chapter2.examples.Student;

public class InsertionSort {

	public static void sort(Object[] data, Comparator comp) {

		for (int i = 0; i < data.length; i++) {
			for (int j = i; j > 0; j--) {
				if (comp.compare(data[j], data[j - 1]) < 0) {
					Sort.exchage(data, j, j - 1);
				} else {
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		Student[] ss = { new Student("s1", 56), new Student("s2", 10), new Student("s3", 53) };

		Comparator<Student> c = (s1, s2) -> s1.getAge().compareTo(s2.getAge());
		sort(ss, c);
		Arrays.stream(ss).forEach(System.out::println);
	}

}