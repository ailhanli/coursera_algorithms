package week2.chapter1;

public class StackResizableArrayImpl implements Stack{

	String[] data;
	int current = 0;

	public StackResizableArrayImpl() {
		data = new String[2];
	}

	public void push(String nd) {
		data[current++] = nd;
		if (current == data.length) {
			resize(data.length * 2);
		}
	}

	private void resize(int ns) {
		System.out.println("resize is called");
		String[] old = data;
		data = new String[ns];
		for (int i = 0; i < current; i++) {
			data[i] = old[i];
		}
	}

	public String pop() {
		String rs= data[--current];
		data[current]=null;
		if(current!=0 && current==data.length/4) {
			resize(data.length/2);
		}
		return rs;
	}

	public int size() {
		return current;
	}

	public static void main(String[] args) {
		Stack stack = new StackResizableArrayImpl();
		stack.push("cat");
		stack.push("dog");
		stack.push("bird");
		stack.push("bobi");

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.size());
	}
}