package week2.chapter2.exercise;

import java.util.Arrays;

import week2.chapter2.examples.Sort;
import week2.chapter2.examples.Student;

public class SelectionSort {

	public static void sort(Comparable[] data) {
		
		for (int i = 0; i < data.length; i++) {
			int min= i;
			for (int j = i+1; j < data.length; j++) {
				if(Sort.less(data[j], data[min])){
					min = j;
				}
			}
			Sort.exchage(data, i, min);
		}
	}
	
	
	public static void main(String[] args) {
		Student[] ss = {new Student("s1", 56), new Student("s2", 10), new Student("s3", 53)};

		sort(ss);
		Arrays.stream(ss).forEach(System.out::println);
	}
	
}