package week1.chapter2.exercises;

public class ObservationsEx {

	public static void main(String[] args) {
		int a = 2;
		int b = 3;
		@SuppressWarnings("unused")
		int c;
		long before = System.nanoTime();
		c= a+b;
		System.out.println("elapsed "+(System.nanoTime()-before));

	}

}
