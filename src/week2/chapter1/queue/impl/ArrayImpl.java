package week2.chapter1.queue.impl;

import java.util.Iterator;

public class ArrayImpl<Item> implements Queue<Item> {

	Item[] data;
	int head, tail;

	@SuppressWarnings("unchecked")
	public ArrayImpl(int size) {
		data = (Item[]) new Object[size];
	}

	@Override
	public void enqueue(Item item) {
//		if (tail == data.length) {
//			if (head != 0) {
//				tail = 0;
//			}
//		}
		data[tail++] = item;
	}

	@Override
	public Item dequeue() {
		Item result = data[head++];

//		if (head == data.length) {
//			if (tail != 0) {
//				head = 0;
//			}
//		}

		return result;
	}

	public String toString() {
		return head + "_" + tail;
	}

	@Override
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			int h = head;
			@Override
			public boolean hasNext() {
				return data[h]!=null;
			}

			@Override
			public Item next() {
				return data[h++];
			}
		};
	}

	public static void main(String[] args) {
		Queue<Integer> q = new ArrayImpl<>(10);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(2);
		q.dequeue();
		q.enqueue(3);

		for(Integer i:q){
			System.out.println(i);
		}

	}
}
