package week3.chapter1.exercises;

import java.util.Arrays;

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

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void merge(Comparable[] array) {
		int n = array.length / 2;
		Comparable[] aux = new Comparable[n];
		for (int i = 0; i < n; i++) {
			aux[i] = array[i];
		}
		System.out.println(Arrays.toString(aux));
		
		int l = 0;
		int r = n;
		for (int k = 0; k < 2 * n; k++) {
			if (l >= n)
				break;
			else if (r >= 2 * n)
				array[k] = aux[l++];
			else if (less(array[r], aux[l]))
				array[k] = array[r++];
			else
				array[k] = aux[l++];
		}
	}

	public static void main(String[] args) {
		int n = 4;
		int[] subarray1 = {1,2,67,89};
		int[] subarray2 = {4,5,100,200};

		Arrays.sort(subarray1);
		Arrays.sort(subarray2);
		Integer[] array = new Integer[2 * n];
		for (int i = 0; i < n; i++) {
			array[i] = subarray1[i];
			array[n + i] = subarray2[i];
		}
		System.out.println(Arrays.toString(array));
		merge(array);
		System.out.println(Arrays.toString(array));
	}

}