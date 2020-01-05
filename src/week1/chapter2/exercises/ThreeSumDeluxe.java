package week1.chapter2.exercises;

import java.util.Random;

public class ThreeSumDeluxe {

  public static int countThreeSum(int[] data) {
    int count = 0;
    for (int i = 0; i < data.length; i++) {
      for (int j = i + 1; j < data.length; j++) {
        int sum = -(data[i] + data[j]);
        int result = search(data, sum);
        if (result != -1) {
          count++;
        }
      }
    }
    return count;
  }

  private static int search(int[] data, int number) {

    int low = 0, high = data.length - 1;
    while (low < high) {
      int medium = low + (high - low) / 2;
      if (data[medium] == number) {
        return 1;
      } else if (number > data[medium]) {
        low = medium + 1;
      } else {
        high = medium - 1;
      }
    }

    return 0;
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
