package week2.chapter1.queue.impl;

public interface Queue<Item> extends Iterable<Item> {
	void enqueue(Item item);
	Item dequeue();
}