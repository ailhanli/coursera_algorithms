package week2.chapter1;

public class StackLinkedListImpl implements Stack {

	class Node {
		String data;
		Node next;
		Node(String data) {
			this.data = data;
		}
	}

	Node first;

	int size;

	@Override
	public void push(String data) {
		Node old = first;
		first = new Node(data);
		first.next = old;
		size++;
	}

	@Override
	public String pop() {
		if (first == null) {
			throw new IllegalAccessError();
		}
		String data = first.data;
		first = first.next;
		size--;
		return data;
	}

	@Override
	public int size() {
		return size;
	}
	
	public static void main(String[] args) {
		Stack stack = new StackLinkedListImpl();
		stack.push("cat");
		stack.push("dog");
		stack.push("bird");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.size());
	}
}