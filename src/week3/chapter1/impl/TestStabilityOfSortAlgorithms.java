package week3.chapter1.impl;

import java.util.Arrays;
import java.util.Comparator;

import week2.chapter2.examples2.InsertionSort;
import week2.chapter2.examples2.SelectionSort;
import week2.chapter2.examples2.ShellSort;

class City {
	String name;
	String code;

	public City(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

	@Override
	public String toString() {
		return code + " " + name;
	}
}

public class TestStabilityOfSortAlgorithms {

	public static void main(String[] args) {
		Comparator<City> byCity = (a, b) -> a.name.compareTo(b.name);
		Comparator<City> byCode = (a, b) -> a.code.compareTo(b.code);

		City[] cities = { new City("Chicago", "IL"), new City("Champaign", "IL"), new City("Detroit", "MI"),
				new City("New York", "NY"), new City("Buffalo", "NY"), new City("Milwaukee", "WI"),
				new City("Albany", "NY"), new City("Green Bay", "WI"), new City("Syracuse", "NY"),
				new City("Rockford", "IL"), new City("Evanston", "IL") };

		City[] cities2 = cities.clone();
		City[] cities3 = cities.clone();
		City[] cities4 = cities.clone();
		
		System.out.println(cities);
		System.out.println(cities2);
		
		
		InsertionSort.sort(cities, byCity);
		System.out.println("insertionsort");
		Arrays.stream(cities).forEach(System.out::println);
		System.out.println();
		SelectionSort.sort(cities2, byCity);
		System.out.println("selectionsort");
		Arrays.stream(cities2).forEach(System.out::println);
		System.out.println();
		ShellSort.sort(cities3, byCity);
		System.out.println("shellsort");
		Arrays.stream(cities3).forEach(System.out::println);
		System.out.println();
		MergeSort.sort(cities4, byCity);
		System.out.println("mergesort");
		Arrays.stream(cities4).forEach(System.out::println);
		System.out.println();
		

		System.out.println("second sort");
		InsertionSort.sort(cities, byCode);
		System.out.println("insertionsort");
		Arrays.stream(cities).forEach(System.out::println);
		System.out.println();

		SelectionSort.sort(cities2, byCode);
		System.out.println("selectionsort");
		Arrays.stream(cities2).forEach(System.out::println);
		System.out.println();

		SelectionSort.sort(cities3, byCode);
		System.out.println("shellsort");
		Arrays.stream(cities3).forEach(System.out::println);
		System.out.println();
		
		SelectionSort.sort(cities4, byCode);
		System.out.println("mergesort");
		Arrays.stream(cities4).forEach(System.out::println);

	}
}