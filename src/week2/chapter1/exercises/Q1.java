package week2.chapter1.exercises;

import java.util.Stack;

/**
 * Queue with two stacks. Implement a queue with two stacks so that each queue
 * operations takes a constant amortized number of stack operations.
 * 
 * @author Abdullah
 *
 */
public class Q1<T> {

	private Stack<T> s1 = new Stack<>();
	private Stack<T> s2 = new Stack<>();

	public void enqueue(T t) {
		s1.push(t);
	}

	public T dequeue() {
		T t = null;
		if (s2.isEmpty()) {
			if (!s1.isEmpty()) {

				while(!s1.isEmpty()){
					s2.push(s1.pop());
				}

				t = s2.pop();
			}
		} else {
			t = s2.pop();
		}

		return t;
	}

	public static void main(String[] args) {
		Q1<Integer> q = new Q1<>();
		q.enqueue(12);
		q.enqueue(34);
		q.enqueue(67);
		System.out.println(q.dequeue());
		q.enqueue(78);
		System.out.println(q.dequeue());
	}

}
