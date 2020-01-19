package week2.chapter1.stack.impl;

import java.util.Iterator;

public class ArrayImpl<Item> implements Iterable<Item> {
	Item[] data;
	int current = 0;

	@SuppressWarnings("unchecked")
	public ArrayImpl(int size) {
		data = (Item[]) new Object[size];
	}

	public void push(Item nd) {
		data[current++] = nd;
	}

	public Item pop() {
		int bc = current;
		Item rs = data[--current];
		data[bc] = null;
		return rs;
	}

	public int size() {
		return current;
	}

	@Override
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			int last = current-1;
			@Override
			public boolean hasNext() {
				return last!=-1;
			}

			@Override
			public Item next() {
				return data[last--];
			}
		};
	}

	public static void main(String[] args) {
//		ArrayImpl<Integer> stack = new ArrayImpl<>(10_000_000);

//		long before = System.currentTimeMillis();
//		for (int i = 0; i < 10_000_000; i++) {
//			stack.push(i);
//		}
//		System.out.println("elapsed " + (System.currentTimeMillis() - before));
		
		
		ArrayImpl<String> stack2 = new ArrayImpl<String>(10);
		stack2.push("Abdullah");
		stack2.push("Nesrin");
		stack2.push("Omer");
		
		for(String s: stack2){
			System.out.println("*"+s);
		}
	}
}