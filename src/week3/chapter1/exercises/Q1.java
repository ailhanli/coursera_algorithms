package week3.chapter1.exercises;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * Merging with smaller auxiliary array. Suppose that the subarray a[0] to
 * a[n−1] is sorted and the subarray a[n] to a[2∗n−1] is sorted. How can you
 * merge the two subarrays so that a[0] to a[2∗n−1] is sorted using an auxiliary
 * array of length n (instead of 2n)?
 * 
 * @author abdullah.ilhanli
 *
 */
public class Q1 {

	public static <T> void merge(T[] numbers, Comparator<T> comp) {
		int n = numbers.length / 2;
		T[] aux = Arrays.copyOf(numbers, n);

		int l = 0, r = n;

		for (int i = 0; i < numbers.length; i++) {
			if (l >= n) {
				break;
			} else if (r >= numbers.length) {
				numbers[i] = aux[l++];
			} else if (comp.compare(numbers[r] , aux[l])<0) {
				numbers[i] = numbers[r++];
			} else {
				numbers[i] = aux[l++];
			}
		}

	}

	public static void main(String[] args) {

		Integer[] array = new Integer[] { 15, 26, 30, 50, 7, 10, 15, 18, 19 };
		System.out.println(Arrays.toString(array));
		merge(array,Integer::compareTo);
		System.out.println(Arrays.toString(array));
	}

}