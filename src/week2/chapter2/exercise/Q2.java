package week2.chapter2.exercise;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Permutation. Given two integer arrays of size nn, design a subquadratic
 * algorithm to determine whether one is a permutation of the other. That is, do
 * they contain exactly the same entries but, possibly, in a different order.
 * 
 * @author abdullah.ilhanli
 *
 */
public class Q2 {

	public static boolean isPermutation(int[] arr1, int[] arr2) {

		Set<Integer> values = Arrays.stream(arr1).mapToObj(Integer::valueOf)
				.collect(Collectors.toCollection(TreeSet::new));

		for (Integer a : arr2) {
			if (!values.contains(a)) {
				return false;
			}
		}

		return true;
	}
	
	public static void main(String[] args) {
		int[] n1 = {4,1,6,7,8,0};
		int[] n2 = {6,1,4,7,8,67};
		
		System.out.println(isPermutation(n1, n2));
	}

}