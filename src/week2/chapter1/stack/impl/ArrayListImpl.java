package week2.chapter1.stack.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListImpl<Item> implements Stack<Item> {

	List<Item> data = new ArrayList<>();

	public void push(Item nd) {
		data.add(nd);
	}

	public Item pop() {
		return data.remove(data.size() - 1);
	}

	public int size() {
		return data.size();
	}

	@Override
	public Iterator<Item> iterator() {
		return data.iterator();
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new ArrayListImpl<>();

		long before = System.currentTimeMillis();
		for (int i = 0; i < 10_000_000; i++) {
			stack.push(i);
		}
		System.out.println("elapsed " + (System.currentTimeMillis() - before));
	}
}