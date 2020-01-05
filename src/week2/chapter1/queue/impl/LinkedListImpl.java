package week2.chapter1.queue.impl;

import java.util.Iterator;

public class LinkedListImpl<Item> implements Queue<Item> {
	class Node {
		Node next;
		Item value;
	}

	Node head, tail;

	@Override
	public void enqueue(Item item) {
		Node oldTail = tail;
		tail = new Node();
		tail.value = item;
		if (oldTail == null) {
			head = tail;
		} else {
			oldTail.next = tail;
		}
	}

	@Override
	public Item dequeue() {
		if (head == null) {
			throw new IllegalAccessError();
		}
		Item val = head.value;

		Node oldHead = head;
		head = head.next;
		oldHead.next = null;

		return val;
	}

	@Override
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			Node n = head;
			
			@Override
			public boolean hasNext() {
				return n != null;
			}

			@Override
			public Item next() {
				Item result = n.value;
				n = n.next;
				return result;
			}
		};
	}

	public static void main(String[] args) {
		Queue<String> q = new LinkedListImpl<>();

		q.enqueue("abdullah");
		q.enqueue("nesrin");
		q.enqueue("omer");
		
		for(String s: q){
			System.out.println(s);
		}
	}
}