package week2.chapter2.examples2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class MyNumber  {
	Integer number;
	Integer order;

	public MyNumber(Integer number, Integer order) {
		this.number = number;
		this.order = order;
	}

	public Integer getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}
}

public class ShuffleSort_BruteForce {

	public static void main(String[] args) {
		Integer[] numbers = IntStream.range(1, 100).mapToObj(Integer::valueOf).toArray(Integer[]::new);

		System.out.println(Arrays.stream(numbers).map(String::valueOf).reduce((n1, n2) -> n1 + ", " + n2));

		MyNumber[] res1 = shuffle1(numbers);
		MyNumber[] res2 = shuffle2(numbers);

		List<Integer> col = Arrays.stream(numbers).collect(Collectors.toList());
		Collections.shuffle(col);
		col.stream().map(String::valueOf).reduce((n1, n2) -> n1 + ", " + n2).ifPresent(System.out::println);

		Comparator<MyNumber> c = (n1,n2)->n1.getNumber().compareTo(n2.getNumber());
		
		ShellSort.sort(res1,c);
		ShellSort.sort(res2,c);

		Arrays.stream(res1).map(MyNumber::getNumber).map(String::valueOf).reduce((n1, n2) -> n1 + ", " + n2)
				.ifPresent(System.out::println);

		Arrays.stream(res2).map(MyNumber::getNumber).map(String::valueOf).reduce((n1, n2) -> n1 + ", " + n2)
				.ifPresent(System.out::println);

	}

	public static MyNumber[] shuffle1(Integer[] numbers) {
		Random r = new Random();
		return IntStream.range(0, numbers.length).mapToObj(i -> new MyNumber(numbers[i], r.nextInt(numbers.length)))
				.toArray(MyNumber[]::new);
	}

	public static MyNumber[] shuffle2(Integer[] numbers) {
		Random r = new Random();
		return IntStream.range(0, numbers.length).mapToObj(i -> new MyNumber(numbers[i], r.nextInt(i + 1)))
				.toArray(MyNumber[]::new);
	}
}