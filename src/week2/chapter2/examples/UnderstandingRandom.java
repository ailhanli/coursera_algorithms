package week2.chapter2.examples;

import java.util.Random;

public class UnderstandingRandom {

	public static void main(String[] args) {
		Random random = new Random();
		
		//it will generate random number 0,1,2
		for (int i = 0; i < 10; i++) {
			System.out.println(random.nextInt(3));
		}
		
		System.out.println(random.nextDouble());

	}
}