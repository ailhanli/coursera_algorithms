package week1.chapter1.exercises;

class WeightedQU{
	
	int[] data;
	int[] sizes;
	int[] roots;
	
	public WeightedQU(int size){
		data = new int[size];
		sizes = new int[size];
		roots = new int[size];
		
		for(int i=0;i<size;i++){
			data[i]=i;
			sizes[i]=1;
			roots[i]=i;
		}
	}
	
	public boolean connected(int i, int j){
		return roots[i]==roots[j];
	}
	
	public void union(int i, int j){
		int ri= root(i);
		int rj= root(j);		
		
		if(ri==rj){
			return;
		}
		
		if(sizes[ri]>sizes[rj]){
			data[rj]= data[ri];
			sizes[ri]+=data[rj];
			roots[i]=roots[j]=ri;
		}else{
			data[ri]= data[rj];
			sizes[rj]+=data[ri];
			roots[i]=roots[j]=rj;
		}		
	}

	private int root(int i) {
		while(i!=data[i]){
			//i= data[data[i]]; path compression make linear because of compression cost
			i= data[i];
		}
		return i;
	}
	
	public void print(){
		System.out.println("roots" + roots);
		System.out.println("data" + data);
		System.out.println("sizes" + sizes);
	}
}

public class LinearFindLogaritmicUnion {
	public static void main(String[] args) {	
		WeightedQU qu = new WeightedQU(7);
		qu.union(1, 2);
		qu.union(3, 4);
		qu.union(4, 5);
		qu.union(1, 6);
		
		qu.print();
	}
}