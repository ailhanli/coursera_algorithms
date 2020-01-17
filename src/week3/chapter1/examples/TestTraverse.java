package week3.chapter1.examples;

public class TestTraverse {

	public static void main(String[] args) {

		
		int N = 12;
		for (int size = 1; size < N; size = size * 2) {
			System.out.println("size is "+size);
			for (int i = 0; i < N; i += 2 * size) {
				int low = i;
				int high = Math.min((i + (2 * size) - 1), N - 1);
				int mid =low + (high-low)/2;
				
				System.out.println(low+" "+mid+" "+high);
			}
			System.out.println();
		}

	}
}