package week2.chapter2.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnderstandingOrder {

	public static void main(String[] args) {
		
		List<Integer> sample = Arrays.asList(100,3,160,78,500);
		Collections.sort(sample,Collections.reverseOrder());

		System.out.println(sample);
	}

}