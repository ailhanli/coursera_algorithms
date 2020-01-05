package week1.chapter2.exercises;

public class BitonicSearch {

	public static boolean exist(int[] numbers, int number) {
		int low = 0;
		int high = numbers.length - 1;
		int medium = low + (high - low) / 2;

		if (numbers[medium] == number) {
			return true;
		}

		return search(numbers, number, 0, medium - 1) || searchReverse(numbers, number, high, medium + 1);
	}

	private static boolean search(int[] numbers, int number, int low, int high) {

		while (low <= high) {
			int medium = low + (high - low) / 2;
			if (numbers[medium] == number) {
				return true;
			} else if (numbers[medium] < number) {
				low = medium + 1;
			} else if (numbers[medium] > number) {
				high = medium - 1;
			}
		}
		return false;
	}

	private static boolean searchReverse(int[] numbers, int number, int low, int high) {
		while (low >= high) {
			int medium = low + (high - low) / 2;
			if (numbers[medium] == number) {
				return true;
			} else if (numbers[medium] < number) {
				low = medium - 1;
			} else if (numbers[medium] > number) {
				high = medium + 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] bitonic = { 1, 3, 4, 6, 9, 14, 11, 7, 2, -4, -9 };

		System.out.println(exist(bitonic, -9));
	}
}
