package week1.chapter1.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * find ealist all connected
 * @author Abdullah
 *
 */
class Component{
	int x,y;
	LocalDate date;
	public Component(String component) {
		String[] componentStr = component.split(",");
		this.x = Integer.valueOf(componentStr[0]);
		this.y = Integer.valueOf(componentStr[1]);
		this.date = LocalDate.parse(componentStr[2]);
	}	
}

class WUF1 {
	int[] data;
	int[] sizes;
	
	LocalDate earlistAllFriendShip;
	int maxNodes;
	
	int size;

	public WUF1(int size) {
		this.size = size;
		data = new int[size];
		sizes = new int[size];

		for (int i = 0; i < size; i++) {
			data[i] = i;
			sizes[i] = 1;
		}
	}

	public void union(int x, int y, LocalDate date) {
		int rx = root(x);
		int ry = root(y);

		if (rx == ry) {
			return;
		} else if (sizes[rx] > sizes[ry]) {
			data[ry] = data[rx];
			sizes[rx] += sizes[ry];
			
			if(maxNodes<sizes[rx]){
				maxNodes = sizes[rx];
			}
		} else {
			data[rx] = data[ry];
			sizes[ry] += sizes[rx];
			
			if(maxNodes<sizes[ry]){
				maxNodes = sizes[ry];
			}
		}
		
		if(maxNodes==size-1 && earlistAllFriendShip==null){
			earlistAllFriendShip = date;
		}
	}

	public boolean connected(int x, int y, LocalDate date) {
		return root(x) == root(y);
	}

	private int root(int x) {
		try {
			while (data[x] != x) {
				x = data[x];
			}
			
			return x;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// find all connected
	public static LocalDate find() {
		List<Component> comps = new ArrayList<>();
		try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("/Users/Abdullah/Documents/friendship.txt")))) {
			while(scanner.hasNextLine()){
				String component = scanner.nextLine();
				comps.add(new Component(component));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		WUF1 wuf1 = new WUF1(6);
		comps.stream().forEach(c->wuf1.union(c.x, c.y, c.date));
		
		return wuf1.getEarlistAllFriendShip();
	}
	
	public LocalDate getEarlistAllFriendShip() {
		return earlistAllFriendShip;
	}
}

public class Q1 {

	public static void main(String[] args) {
		System.out.println(WUF1.find()); 
		
	}
}