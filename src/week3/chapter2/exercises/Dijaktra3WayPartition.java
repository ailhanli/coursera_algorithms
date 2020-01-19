package week3.chapter2.exercises;

import java.util.Comparator;

public class Dijaktra3WayPartition {

	public static <T> int partition(T[]data,Comparator<T> comp, int low, int high ) {
		
		int i=low+1, lt=low, gt=high;

		while(true) {
			
			if(comp.compare(data[i], data[lt])<0) {
				exchange(data, i, lt);
				lt++;
				i++;
			}else if(comp.compare(data[i], data[lt])>0) {
				exchange(data, i, gt);
				gt--;
			}else {
				i++;
			}
			
			if(i>=gt) {
				break;
			}
		}
		
		return lt;
	}
	
	private static <T> void exchange(T[] data, int low, int j) {
		T temp = data[low];
		data[low] = data[j];
		data[j] = temp;
	}
}