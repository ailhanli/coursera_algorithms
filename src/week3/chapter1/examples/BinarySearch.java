package week3.chapter1.examples;

public class BinarySearch {

	public static boolean find(Comparable[] data, Comparable key) {
		return find(data, key, 0, data.length - 1);
	}

	private static boolean find(Comparable[] data, Comparable key, int i, int j) {
		if (i >= j) {
			return false;
		}

		int mid = i + (j - i) / 2;
		if (data[mid].compareTo(key) == 0) {
			return true;
		}

		return find(data, key, i, mid) || find(data, key, mid + 1, j);
	}

	public static void main(String[] args) {

		System.out.println(find(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 7));
	}
}