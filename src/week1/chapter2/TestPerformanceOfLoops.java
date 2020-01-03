package week1.chapter2;

public class TestPerformanceOfLoops {

  public static void main(String[] args) {
    
	int a = 2_100_000_000;
	System.out.println(a);
	  
    int sum = 0;
    long now = System.currentTimeMillis();
    for (int i = 0; i < 2_000_000_000; i++) {
      for (int j = 0; j < 2_000_000_000; j++) {
        sum+=i+j;
      }
    }
    
    System.out.println("elapsed time "+(System.currentTimeMillis()-now));
    
    
    sum = 0;
    now = System.currentTimeMillis();
    for (int i = 0; i < 5_000; i++) {
      for (int j = 0; j < 5_000; j++) {
        for (int k = 0; k < 5_000; k++) {
          sum+=i+j;
        }
      }
    }
    
    System.out.println("elapsed time "+(System.currentTimeMillis()-now));
  }
}