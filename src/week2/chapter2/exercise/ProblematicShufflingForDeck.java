package week2.chapter2.exercise;

import java.util.Random;

import week2.chapter2.examples.Sort;

public class ProblematicShufflingForDeck {

	public static void main(String[] args) {
		
		Integer[] cards = {};
		
		Random r = new Random();
		for (int i = 1; i <52; i++) {
			int nextR=r.nextInt(i)+1;
			Sort.exchage(cards, i, nextR);
		}
		
		//it is not uniformly disturbided
		//we will never get 52 it is a bug
		//it is predictable. it generates 2'32 numbers whereas we normally expect 52!
	}
	
}