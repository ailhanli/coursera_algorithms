package week2.chapter1.stack.impl;

import java.util.Iterator;

public class ResizableArrayImpl<Item> implements Stack<Item> {

	Item[] data;
	int current = 0;

	public ResizableArrayImpl() {
		data = (Item[]) new Object[2];
	}

	public void push(Item nd) {
		data[current++] = nd;
		if (current == data.length) {
			resize(data.length * 2);
		}
	}

	private void resize(int ns) {
		Item[] old = data;
		data = (Item[]) new Object[ns];
		for (int i = 0; i < current; i++) {
			data[i] = old[i];
		}
	}

	public Item pop() {
		Item rs = data[--current];
		data[current] = null;
		if (current != 0 && current == data.length / 4) {
			resize(data.length / 2);
		}
		return rs;
	}

	public int size() {
		return current;
	}

	@Override
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			int c = current;
			@Override
			public boolean hasNext() {
				return c!=0;
			}
			@Override
			public Item next() {
				return data[c++];
			}
		};
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new ResizableArrayImpl<>();

//		long before = System.currentTimeMillis();
//		for (int i = 0; i < 10_000_000; i++) {
//			stack.push(i);
//		}
//		System.out.println("elapsed " + (System.currentTimeMillis() - before));
		
		Stack<String> stack2 = new LinkedListImpl<>();
		stack2.push("Abdullah");
		stack2.push("Nesrin");
		stack2.push("Omer");
		
		for(String s: stack2){
			System.out.println(s);
		}
	}
}