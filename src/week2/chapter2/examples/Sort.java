package week2.chapter2.examples;

public interface Sort {

	public static void sort(Comparable[] comparables){
		if(isSorted(comparables)){
			return;
		}
		for (int i = 0; i < comparables.length; i++) {
			for (int j = i; j >0; j--) {
				if(less(comparables[j], comparables[j-1])){
					exchage(comparables, j, j-1);
				}
			}
		}
	}
	
	public static boolean isSorted(Comparable[] comps){
		for (int i = 0; i < comps.length-1; i++) {
			if(less(comps[i],comps[i+1])){
				continue;
			}else{
				return false;
			}
		}
		return true;
	}
	
	public static boolean less(Comparable a, Comparable b){
		return a.compareTo(b)<0;
	}
	
	public static void exchage(Comparable[] comps, int i, int j){
		Comparable temp = comps[i];
		comps[i]= comps[j];
		comps[j]= temp;
	}
}
