package week2.chapter1;

public class StackArrayImpl {

	String[] data;
	int current = 0;

	public StackArrayImpl(int size) {
		data = new String[size];
	}

	public void push(String nd) {
		data[current++] = nd;
	}

	public String pop() {
		int bc = current;
		String rs= data[--current];
		data[bc]=null;
		return rs;
	}

	public int size() {
		return current;
	}

	public static void main(String[] args) {
		StackArrayImpl stack = new StackArrayImpl(10);
		stack.push("cat");
		stack.push("dog");
		stack.push("bird");

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.size());
	}
}