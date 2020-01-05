package week1.chapter2.exercises;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ThreeSumQuadratic {

  public static int countThreeSum(int[] data) {
    int count = 0;
    Set<Integer> cache = new HashSet<>();
    
    Arrays.stream(data).forEach(cache::add);
    
    for (int i = 0; i < data.length; i++) {
      for (int j = i + 1; j < data.length; j++) {
        int sum = -(data[i] + data[j]);
        if (cache.contains(sum)) {
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {

    Random rand = new Random();

    int[] numbers = new int[8000];

    for (int i = 0; i < numbers.length; i++) {
      if (rand.nextBoolean()) {
        numbers[i] = rand.nextInt(1000);
      } else {
        numbers[i] = -rand.nextInt(1000);
      }
    }

    long now = System.currentTimeMillis();
    countThreeSum(numbers);
    System.out.println("elapsed: " + (System.currentTimeMillis() - now));
  }

}
