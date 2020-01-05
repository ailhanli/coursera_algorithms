package week1.chapter1.exercises;

import java.time.LocalDate;

class WUF2 {
	int[] data;
	int[] sizes;
	int[] maxes;

	int size;

	public WUF2(int size) {
		this.size = size;
		data = new int[size];
		sizes = new int[size];
		maxes = new int[size];

		for (int i = 0; i < size; i++) {
			data[i] = i;
			maxes[i] = i;
			sizes[i] = 1;
		}
	}
	
	public int find(int i){
		int ri= root(i);
		return maxes[ri];
	}

	public void union(int x, int y) {

		int rx = root(x);
		int ry = root(y);
		
		if(rx>ry){
			maxes[ry]=rx;
		}else{
			maxes[rx]=ry;
		}

		if (rx == ry) {
			return;
		} else if (sizes[rx] > sizes[ry]) {
			data[ry] = data[rx];
			sizes[rx] += sizes[ry];
		} else {
			data[rx] = data[ry];
			sizes[ry] += sizes[rx];
		}
	}

	public boolean connected(int x, int y, LocalDate date) {
		return root(x) == root(y);
	}

	private int root(int x) {
		while (data[x] != x) {
			x = data[x];
		}
		return x;
	}

}

public class Q2 {
	public static void main(String[] args) {
		WUF2 wf = new WUF2(6);
		wf.union(0, 1);
		wf.union(2, 3);
		wf.union(4, 3);
		System.out.println(wf.find(2));
	}
}