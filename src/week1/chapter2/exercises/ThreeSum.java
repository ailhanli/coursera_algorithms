package week1.chapter2.exercises;

import java.util.Random; 

public class ThreeSum {

  public static int countThreeSum(int[] data) {
    int count= 0;
    for (int i = 0; i < data.length; i++) {
      for (int j = i+1; j < data.length; j++) {
        for (int j2 = j+1; j2 < data.length; j2++) {
          if(data[i]+data[j]+data[j2]==0) {
            count++;
          }
        }
      }
    }
    return count;
  }
  
  
  public static void main(String[] args) {
    
    Random rand = new Random();

    int [] numbers = new int[8000];  
  
    for (int i = 0; i < numbers.length; i++) {
      if(rand.nextBoolean()) {
        numbers[i] = rand.nextInt(1000);
      }else {
        numbers[i] = -rand.nextInt(1000);
      }
    }
    
    long now = System.currentTimeMillis();
    countThreeSum(numbers);
    System.out.println("elapsed: "+(System.currentTimeMillis()-now));
  }

}
