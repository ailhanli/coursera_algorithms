package week2.chapter1.stack.impl;

import java.util.Iterator;

public class LinkedListImpl<Item> implements Stack<Item> {

	class Node {
		Item data;
		Node next;

		Node(Item data) {
			this.data = data;
		}
	}

	Node first;

	int size;

	@Override
	public void push(Item data) {
		Node old = first;
		first = new Node(data);
		first.next = old;
		size++;
	}

	@Override
	public Item pop() {
		if (first == null) {
			throw new IllegalAccessError();
		}
		Item data = first.data;
		first = first.next;
		size--;
		return data;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			Node it = first;

			@Override
			public boolean hasNext() {
				return it != null;
			}

			@Override
			public Item next() {
				Item item = it.data;
				it = it.next;
				return item;
			}
		};
	}

	public static void main(String[] args) {
//		Stack<Integer> stack = new LinkedListImpl<>();
//
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