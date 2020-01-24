package week3.chapter2.exercises;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * Given a set of n nuts of different sizes and n bolts of different sizes.
 * There is a one-one mapping between nuts and bolts. Match nuts and bolts
 * efficiently. Constraint: Comparison of a nut to another nut or a bolt to
 * another bolt is not allowed. It means nut can only be compared with bolt and
 * bolt can only be compared with nut to see which one is bigger/smaller.
 * 
 * Other way of asking this problem is, given a box with locks and keys where
 * one lock can be opened by one key in the box. We need to match the pair.
 * 
 * @author abdullah.ilhanli
 *
 */
public class Q1 {

	// Driver method
	public static void main(String[] args) {

		// Nuts and bolts are represented as array of characters
		int nuts[] = { 64, 35, 36, 37, 94, 38 };

		System.out.println();
		int bolts[] = { 36, 37, 38, 94, 64, 35 };

		// Method based on quick sort which matches nuts and bolts
		matchPairs(nuts, bolts, 0, 5);

		System.out.println();
		System.out.println("Matched nuts and bolts are : ");
		System.out.println(Arrays.toString(nuts));
		System.out.println(Arrays.toString(bolts));
	}

	// Method which works just like quick sort
	private static void matchPairs(int[] nuts, int[] bolts, int low, int high) {
		if (low < high) {
			// Choose last character of bolts array for nuts partition.
			int pivot = partition(nuts, low, high, bolts[high]);

			// Now using the partition of nuts choose that for bolts
			// partition.
			partition(bolts, low, high, nuts[pivot]);

			// Recur for [low...pivot-1] & [pivot+1...high] for nuts and
			// bolts array.
			matchPairs(nuts, bolts, low, pivot - 1);
			matchPairs(nuts, bolts, pivot + 1, high);
		}
	}

	// Similar to standard partition method. Here we pass the pivot element
	// too instead of choosing it inside the method.
	private static int partition(int[] arr, int low, int high, int pivot) {
		int i = low;
		int temp1, temp2;
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				temp1 = arr[i];
				arr[i] = arr[j];
				arr[j] = temp1;
				i++;
			} else if (arr[j] == pivot) {
				temp1 = arr[j];
				arr[j] = arr[high];
				arr[high] = temp1;
				j--;
			}
		}
		temp2 = arr[i];
		arr[i] = arr[high];
		arr[high] = temp2;

		// Return the partition index of an array based on the pivot
		// element of other array.
		return i;
	}
}
